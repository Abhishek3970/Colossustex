package com.example.colossustex.colossusCare


import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

class PostResumeViewModel : ViewModel() {

    private val database = FirebaseDatabase.getInstance()
    private val storage = FirebaseStorage.getInstance()

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

    private val _submit = MutableLiveData<Boolean>()
    val submit: LiveData<Boolean>?
        get() = _submit

    init {
        _uploadCV.value = false
        _addMore.value = false
        _submit.value = false
    }

    fun uploadCV() {
        _uploadCV.value = true
    }

    fun more() {
        _addMore.value = true
    }

    fun submit() {
        _submit.value = true
    }

    fun done() {
        _addMore.value = false
        _uploadCV.value = false
        _submit.value = false
    }

    fun verify(locationRef: String, ctc: String, academicDetails: String) =
        locationRef.isNotEmpty() && ctc.isNotEmpty() && academicDetails.isNotEmpty()

    fun upload(
        category: String,
        locationRef: String,
        ctc: String,
        time: String,
        employeeDetail: String,
        academicDetails: String,
        notableAccomplishments: String,
        pdfUri: Uri
    ) {

        val fileName = System.currentTimeMillis().toString()

        val storageRef = storage.reference

        storageRef.child("CV").child(fileName).putFile(pdfUri)
            .addOnSuccessListener { task ->

            }
            .addOnFailureListener { task->

            }
            .addOnProgressListener { task->

            }
    }


}
