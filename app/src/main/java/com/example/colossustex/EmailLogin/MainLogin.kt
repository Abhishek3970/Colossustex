package com.example.colossustex.EmailLogin

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.colossustex.MainActivity
import com.example.colossustex.R
import com.example.colossustex.databinding.ActivityMainLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.FirebaseDatabase

lateinit var googleSignInClient: GoogleSignInClient
val RC_SIGN_IN = 1

const val SHARED_PREFERRENCE = "SHARED PREFERENCE"
const val state = "state"

class MainLogin : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var binding: ActivityMainLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_login)
        auth = FirebaseAuth.getInstance()
        binding.textRegister.setOnClickListener {
            val intent = Intent(this, MainRegister::class.java)
            startActivity(intent)
        }
        binding.loginBtn.setOnClickListener {
            dologin()
        }
        binding.mobile.setOnClickListener {
            startActivity(Intent(this, MobileLogin::class.java))
        }
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
        val signinbt = binding.googleSigninBtn
        signinbt.setOnClickListener {
            signin()
        }
        binding.forgotPass.setOnClickListener {
            startActivity(Intent(this, ForgotPassword::class.java))
        }
    }

    private fun dologin() {
        if (binding.emaillogin.text.toString() == "") {
            binding.emaillogin.error = "Enter Email"
            binding.emaillogin.requestFocus()
            return
        }
        if (binding.passlogin.text.toString() == "" || (binding.passlogin.text.toString().length) < 6) {
            binding.passlogin.error = "Enter min 6 Chars"
            binding.passlogin.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(binding.emaillogin.text.toString()).matches()) {
            binding.emaillogin.error = "Enter Proper Email"
            binding.emaillogin.requestFocus()
            return
        }
        auth.signInWithEmailAndPassword(
                binding.emaillogin.text.toString(),
                binding.passlogin.text.toString()
            )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Toast.makeText(this, "Failed...Please sign up", Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }

    private fun signin() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                updateUI(null)
            }
        }
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    val userDetails =
                        UserDetails(user?.uid, user?.email, user?.displayName, user?.phoneNumber)
                    val mref = FirebaseDatabase.getInstance().getReference("User")
                        .child(user?.uid.toString())
                    mref.setValue(userDetails)
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "Authentication Failed", Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }

    override fun onStart() {
        super.onStart()

        val sharedPreferences = getSharedPreferences(SHARED_PREFERRENCE, MODE_PRIVATE)
        val state = sharedPreferences.getInt("state", -1)
        val currentUser = auth.currentUser
        if (currentUser != null) {

            if (state == 1) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            if (currentUser.isEmailVerified) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            if (currentUser.isEmailVerified) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Verify your email", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
