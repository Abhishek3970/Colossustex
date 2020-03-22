package com.example.colossustex.EmailLogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.colossustex.MainActivity
import com.example.colossustex.R
import com.example.colossustex.databinding.ActivityWelcomeBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

lateinit var googleSignInClient: GoogleSignInClient
class WelcomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_welcome)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
        binding.customerBt.setOnClickListener {
            val intent= Intent(this,MainLogin::class.java).putExtra("category","Company")
            startActivity(intent)
            finish()
        }
        binding.agentBt.setOnClickListener {
            val intent=Intent(this,MainLogin::class.java).putExtra("category","Agent")
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        val auth=FirebaseAuth.getInstance()
        val sharedPreferences = getSharedPreferences(SHARED_PREFERRENCE, MODE_PRIVATE)
        val state = sharedPreferences.getInt("state", -1)
        val currentUser = auth.currentUser
        var country=""
        if (currentUser != null) {
            val mref = FirebaseDatabase.getInstance().getReference("Users").child(currentUser.uid)
                .child("userData")
            mref.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(p0: DataSnapshot) {
                    if (p0.exists()) {
                        country = p0.child("country").value.toString()
                    }
                }

            })
            if (state == 1) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            if (currentUser.isEmailVerified) {
                if (country != "") {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    if (GoogleSignIn.getLastSignedInAccount(this) != null) {
                        val intent = Intent(this, InfoActivity::class.java).putExtra("google","google")
                        startActivity(intent)
                        finish()
                    }
                    else{
                        val intent=Intent(this,InfoActivity::class.java)
                        startActivity(intent)
                        finish()
                    }

                }
            }
        }
    }
}
