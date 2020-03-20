package com.example.colossustex.EmailLogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.colossustex.R
import com.example.colossustex.databinding.ActivityForgotPassBinding
import com.google.firebase.auth.FirebaseAuth

class ForgotPassword : AppCompatActivity() {
    lateinit var binding: ActivityForgotPassBinding
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_forgot_pass)
        auth=FirebaseAuth.getInstance()
        binding.forgotBt.setOnClickListener {
            val em=binding.passForgotEt.text.toString()
            auth.sendPasswordResetEmail(em).addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(this,"Email sent",Toast.LENGTH_SHORT).show()
                    val intent= Intent(this,MainLogin::class.java).apply {
                        flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Failed..Please sign up ",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
