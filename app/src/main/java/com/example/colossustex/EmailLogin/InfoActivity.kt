package com.example.colossustex.EmailLogin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.colossustex.MainActivity
import com.example.colossustex.R
import com.example.colossustex.databinding.ActivityUserInfoBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class InfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserInfoBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_info)
        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        val name = intent.extras?.getString("name")
        var pass = intent.extras?.getString("pass")
        val category = intent.extras?.getString("category")
        val google = intent.extras?.getString("google")
        val phone = intent.extras?.getString("phone")
        var country = intent.extras?.getString("country")
        val countries = resources.getStringArray(R.array.countries_array)
        val aa=
            ArrayAdapter<String>(this,R.layout.spineer_item_country,countries)
        aa.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        binding.countryInfo.adapter=aa
        if (country != null) {
            var j = 0;
            for (i in 0 until countries.size) {
                if (countries[i] == country) {
                    j = i
                    break
                }
            }
            binding.countryInfo.setSelection(j)
        }
        else{
            country=""
        }
        binding.countryInfo.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                country = countries[position]
            }

        }
        if (name != null) {
            binding.nameInfo.setText(name)
        } else {
            binding.nameInfo.setText(user?.displayName)
        }
        binding.emailInfo.setText(user?.email)
        if (category != null) {
            binding.categoryInfo.setText(category)
        }
        if (phone != null) {
            binding.mobileInfo.setText(phone)
        }
        if (pass == null) {
            pass = ""
        }

        binding.procBtInfo.setOnClickListener {
            val mref = FirebaseDatabase.getInstance().getReference("User")
                .child(user?.uid.toString()).child("userData")
            if (binding.categoryInfo.text.isEmpty() || binding.cityInfo.text.isEmpty() || country=="" || binding.emailInfo.text.isEmpty() || binding.mobileInfo.text.isEmpty() || binding.nameInfo.text.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val userinfo = UserRegister(
                user?.uid,
                binding.emailInfo.text.toString(),
                binding.nameInfo.text.toString(),
                pass,
                binding.mobileInfo.text.toString(),
                country
                ,
                binding.cityInfo.text.toString(),
                binding.categoryInfo.text.toString(),
                "",
                "",
                "",
                "",
                ""
            )
            mref.setValue(userinfo)
            if (google == "google") {
                startActivity(Intent(this, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                })
            } else {
                startActivity(Intent(this, MainLogin::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                })
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this, "Data is not stored", Toast.LENGTH_SHORT).show()
        if (GoogleSignIn.getLastSignedInAccount(this) != null) {
            googleSignInClient.signOut()
        }
    }
}
