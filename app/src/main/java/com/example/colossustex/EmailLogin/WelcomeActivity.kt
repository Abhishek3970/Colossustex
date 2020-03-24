package com.example.colossustex.EmailLogin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.colossustex.MainActivity
import com.example.colossustex.R
import com.example.colossustex.databinding.ActivityWelcomeBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

val RC_SIGN_IN = 1

const val SHARED_PREFERRENCE = "SHARED PREFERENCE"
const val state = "state"


lateinit var googleSignInClient: GoogleSignInClient

class WelcomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
        binding.customerBt.setOnClickListener {
            val intent = Intent(this, MainLogin::class.java).putExtra("category", "Company")
            startActivity(intent)
            finish()
        }
        binding.agentBt.setOnClickListener {
            val intent = Intent(this, MainLogin::class.java).putExtra("category", "Agent")
            startActivity(intent)
            finish()
        }
    }
    override fun onStart() {
        super.onStart()
        val auth = FirebaseAuth.getInstance()
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
                Log.i("i", "verified")
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
            }
        }
    }
}
