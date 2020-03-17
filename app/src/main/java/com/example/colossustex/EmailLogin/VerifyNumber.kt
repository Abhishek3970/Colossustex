package com.example.colossustex.EmailLogin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.colossustex.R
import com.example.colossustex.databinding.ActivityVerifyNumberBinding

class VerifyNumber : AppCompatActivity() {

    lateinit var binding: ActivityVerifyNumberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_verify_number)

        val phoneNo = intent.getStringExtra("number")

    }
}
