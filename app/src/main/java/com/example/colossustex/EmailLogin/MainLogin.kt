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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

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
                    updateUI(null)
                }

                // ...
            }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
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
        } else {
            Toast.makeText(
                baseContext, "Login Failed.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
