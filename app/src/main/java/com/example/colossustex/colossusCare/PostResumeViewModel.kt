package com.example.colossustex.colossusCare

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostResumeViewModel : ViewModel() {

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

    init {
        _addMore.value = false
    }


    fun more() {
        _addMore.value = true
    }

    fun done(){
        _addMore.value = false
    }


}
