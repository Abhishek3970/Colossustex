package com.example.colossustex.colossusCare

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase

class PostResumeViewModel : ViewModel() {

    private val database = FirebaseDatabase.getInstance()
//    private val storge = Firebase

    val category = arrayListOf(
        "Catagory",
        "Sales",
        "Advertising",
        "Marketing",
        "Business Development",
        "Product Management",
        "Corporate Finance",
        "Investment Finance",
        "Human Resources",
        "Accounting",
        "Information Technology",
        "Engineering",
        "Consulting",
        "Operation/Supply Chain",
        "Strategy",
        "Other"
    )
    val time = arrayListOf(
        "Full Time",
        "Functional",
        "Manager",
        "Director",
        "VP",
        "Executive",
        "Other"
    )

    private val _addMore = MutableLiveData<Boolean>()
    val addMore: LiveData<Boolean>?
        get() = _addMore

    private val _uploadCV = MutableLiveData<Boolean>()
    val uploadCV: LiveData<Boolean>?
        get() = _uploadCV

    init {
        _uploadCV.value = false
        _addMore.value = false
    }

    fun uploadCV(){
        _uploadCV.value = true
    }


    fun more() {
        _addMore.value = true
    }

    fun done(){
        _addMore.value = false
        _uploadCV.value = false
    }

    fun uploadCV(context: Context){

    }


}
