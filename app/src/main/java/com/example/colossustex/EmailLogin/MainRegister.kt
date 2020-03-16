package com.example.colossustex.EmailLogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.colossustex.R
import com.example.colossustex.databinding.ActivityMainRegisterBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.texturised_fragment1.*

class MainRegister : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var binding: ActivityMainRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main_register)
        auth=FirebaseAuth.getInstance()
        binding.resgisterBtn.setOnClickListener {
            signup()
        }
        binding.loginNowText.setOnClickListener {
            val intent=Intent(this,MainLogin::class.java)
            .apply {  flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK }
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left,R.anim.still)

        }

    }

    private fun signup() {
        if(binding.nameEt.text.toString()==""){
            binding.nameEt.error="Enter Name"
            binding.nameEt.requestFocus()
            return
        }
        if(binding.emailEt.text.toString()==""){
            binding.emailEt.error="Enter Email"
            binding.emailEt.requestFocus()
            return
        }
        if(binding.passEt.text.toString()==""||(binding.passEt.text.toString().length)<6){
            binding.passEt.error="Enter min 6 Chars"
            binding.passEt.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(binding.emailEt.text.toString()).matches()){
            binding.emailEt.error="Enter Proper Email"
            binding.emailEt.requestFocus()
            return
        }
        binding.progresslayout.visibility=View.VISIBLE
        auth.createUserWithEmailAndPassword(binding.emailEt.text.toString(), binding.passEt.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user=auth.currentUser
                    user?.sendEmailVerification()
                        ?.addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                binding.progresslayout.visibility=View.GONE
                                Snackbar.make(binding.registerLayout,"Email Sent",Snackbar.LENGTH_SHORT).show()
                                startActivity(Intent(this,MainLogin::class.java))
                                finish()
                            }else{
                                binding.progresslayout.visibility=View.GONE
                                Toast.makeText(this,"Please check your network",Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    binding.progresslayout.visibility=View.GONE
                    Toast.makeText(baseContext, "Sign Up Failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }


    }
}
