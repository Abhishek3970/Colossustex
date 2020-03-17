package com.example.colossustex.EmailLogin

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.colossustex.R
import com.example.colossustex.databinding.ActivityMobileLoginBinding

class MobileLogin : AppCompatActivity() {

    lateinit var binding: ActivityMobileLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_mobile_login)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mobile_login)
        binding.spinnerCountry.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, countryNames)
        binding.buttonSubmit.setOnClickListener{
            val code = countryCode[ binding.spinnerCountry.selectedItemPosition ]
            val number = binding.editTextMobile.text.toString().trim()
            if(number.isEmpty() || number.length < 10){
                binding.editTextMobile.error = "valid number is required"
                binding.editTextMobile.requestFocus()
                return@setOnClickListener
            }
            val phoneNo = "+$code$number"
            val intent = Intent(this ,  VerifyNumber::class.java)
            intent.putExtra("number" , phoneNo)
            startActivity(intent)
        }

    }
}
