package com.example.colossustex.EmailLogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.colossustex.R
import com.example.colossustex.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_welcome)
        binding.customerBt.setOnClickListener {
            val intent= Intent(this,MainLogin::class.java).putExtra("category","Customer")
            startActivity(intent)
        }
        binding.agentBt.setOnClickListener {
            val intent=Intent(this,MainLogin::class.java).putExtra("category","Agent")
            startActivity(intent)
        }
    }
}
