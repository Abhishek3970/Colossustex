package com.example.colossustex.EmailLogin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.colossustex.MainActivity
import com.example.colossustex.R
import com.example.colossustex.databinding.ActivityUserInfoBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class InfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserInfoBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_info)
        val name = intent.extras?.getString("name")
        val email = intent.extras?.getString("email")
        var pass = intent.extras?.getString("pass")
        val category = intent.extras?.getString("category")
        val google=intent.extras?.getString("google")
        if (name != null) {
            binding.nameInfo.setText(name)
        }
        if (email != null) {
            binding.emailInfo.setText(email)
        }
        if (category != null) {
            binding.categoryInfo.setText(category)
        }
        if (pass == null) {
            pass = ""
        }

        binding.procBtInfo.setOnClickListener {
            auth = FirebaseAuth.getInstance()
            val user = auth.currentUser
            val mref = FirebaseDatabase.getInstance().getReference("User")
                .child(user?.uid.toString()).child("userData")
            if (binding.categoryInfo.text.isEmpty() || binding.cityInfo.text.isEmpty() || binding.countryInfo.text.isEmpty() || binding.emailInfo.text.isEmpty() || binding.mobileInfo.text.isEmpty() || binding.nameInfo.text.isEmpty()) {
                Toast.makeText(this,"Fill all fields",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val userinfo = UserRegister(
                user?.uid,
                binding.emailInfo.text.toString(),
                binding.nameInfo.text.toString(),
                pass,
                binding.mobileInfo.text.toString(),
                binding.countryInfo.text.toString()
                ,
                binding.cityInfo.text.toString(),
                category,
                "",
                "",
                "",
                "",
                ""
            )
            mref.setValue(userinfo)
            if(google=="google"){
                startActivity(Intent(this, MainActivity::class.java).apply {
                    flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                })
            }else {
                startActivity(Intent(this, MainLogin::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                })
            }
        }
    }
}
