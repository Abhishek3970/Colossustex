package com.example.colossustex.colossusCare


import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

class PostResumeViewModel : ViewModel() {

    private val database = FirebaseDatabase.getInstance().reference
    private val storage = FirebaseStorage.getInstance()

    val category = arrayListOf(
        "Category",
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

    private val _showProgress = MutableLiveData<Boolean>()
    val showProgress: LiveData<Boolean>?
        get() = _showProgress

    var progress = 0

    init {
        _uploadCV.value = false
        _addMore.value = false
        _submit.value = false
        _showProgress.value = false

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
        pdfUri: Uri,
        context: Context
    ) {

        val fileName = System.currentTimeMillis().toString()

        val storageRef = storage.reference

        val filePath = storageRef.child("CV/$fileName.pdf")

        Log.i("uri", "$pdfUri")

        filePath.putFile(pdfUri)
            .addOnSuccessListener { task ->

                val uri = task.storage.downloadUrl
                while (!uri.isComplete) {
                }
                val url = uri.result

                val data = AllresumesData(
                    id =fileName,
                    category = category,
                    location = locationRef,
                    ctc = ctc,
                    time = time,
                    emp_details = employeeDetail,
                    academic_details = academicDetails,
                    accomplishments = notableAccomplishments,
                    resumeLink = url.toString()
                )

                database.child("ResumeData").child(fileName).setValue(data)

                _showProgress.value = false
                progress = 0

                Toast.makeText(
                    context,
                    "Uploaded successfully",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .addOnFailureListener { task ->
                Toast.makeText(
                    context,
                    "File Not Uploaded Due to some error. Please Try Again",
                    Toast.LENGTH_SHORT
                ).show()
                _showProgress.value = false
                progress = 0
            }
            .addOnProgressListener { task ->
                _showProgress.value = true
                progress = (100 * task.bytesTransferred / task.totalByteCount).toInt()
            }


    }


}
