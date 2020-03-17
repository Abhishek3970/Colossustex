package com.example.colossustex.EmailLogin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.colossustex.MainActivity
import com.example.colossustex.R
import com.example.colossustex.databinding.ActivityVerifyNumberBinding
import com.example.colossustex.homePage.HomePage
import com.google.android.gms.tasks.TaskExecutors
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class VerifyNumber : AppCompatActivity() {

    var verificationID: String? = null
    lateinit var binding: ActivityVerifyNumberBinding
    lateinit var mAuth: FirebaseAuth
    lateinit var progressBar: ProgressBar
    lateinit var edit: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_verify_number)

        mAuth = FirebaseAuth.getInstance()
        progressBar = binding.progressBar
        edit = binding.editOTP

        val phoneNo = intent.getStringExtra("number")
        sendVerificationCode(phoneNo)

        binding.buttonSubmit.setOnClickListener {
            val code = binding.editOTP.text.toString().trim()

            if (code.isEmpty() || code.length < 6) {
                binding.editOTP.error = "Enter Correct Code..."
                binding.editOTP.requestFocus()
                return@setOnClickListener
            }
            verifyCode(code)
        }

    }

    fun verifyCode(code: String) {
        val credential = verificationID?.let { PhoneAuthProvider.getCredential(it, code) }
        if (credential != null) {
            signInWithCredential(credential)
        } else {
            Toast.makeText(this@VerifyNumber, "Invalid Code" , Toast.LENGTH_LONG).show()

        }
    }

    private fun signInWithCredential(credential: PhoneAuthCredential) {
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->

                if (task.isSuccessful) {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                } else {
                    Toast.makeText(this@VerifyNumber, task.exception?.message, Toast.LENGTH_LONG)
                        .show()

                }

            }
    }

    private fun sendVerificationCode(number: String) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            number,
            60,
            TimeUnit.SECONDS,
            TaskExecutors.MAIN_THREAD,
            mCallback
        )

    }

    private val mCallback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
            super.onCodeSent(p0, p1)
            verificationID = p0
        }

        override fun onVerificationCompleted(p0: PhoneAuthCredential) {
            val code = p0.smsCode
            code?.let { code ->
                verifyCode(code)
            }
        }

        override fun onVerificationFailed(e: FirebaseException) {
            binding.progressBar.visibility = View.INVISIBLE
            finish()
            Toast.makeText(this@VerifyNumber, e.message, Toast.LENGTH_LONG).show()
        }

    }

}
