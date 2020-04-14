package com.example.colossustex.colossusCare

import android.Manifest
import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.colossustex.R
import com.example.colossustex.databinding.PostResumeFragmentBinding

class PostResume : Fragment() {

    private lateinit var viewModel: PostResumeViewModel
    private lateinit var binding: PostResumeFragmentBinding
    private lateinit var adapter: EmployeeAdapter
    private lateinit var list: MutableList<String>
    private lateinit var manager: LinearLayoutManager
    private lateinit var progress: ProgressDialog
    private val PERMISSION_CODE = 10
    private val INTENT_CODE = 9
    private var pdfUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setUpDataBindingAndViewModel(inflater, container)

        setUpAdaptersSpinner()

        setUpRecyclerView()

        setUpProgressDialog()

        viewModel.addMore?.observe(viewLifecycleOwner, Observer { add ->
            if (add) {
                val newText = binding.employDetails.editText?.text.toString().trim()
                if (newText.isNotEmpty()) {
                    list.add(newText)
                    adapter.notifyDataSetChanged()
                    Toast.makeText(context!!, "Added", Toast.LENGTH_SHORT).show()
                    binding.employDetails.editText?.text?.clear()
                } else
                    Toast.makeText(context!!, "First Enter Field..", Toast.LENGTH_SHORT).show()

                viewModel.done()
            }

        })

        viewModel.uploadCV?.observe(viewLifecycleOwner, Observer { uploadCV ->
            if (uploadCV) {
                uploadCV(context!!)
                viewModel.done()
            }
        })

        viewModel.submit?.observe(viewLifecycleOwner, Observer { submit ->
            if (submit) {
                val locationRef = binding.locationReference.editText?.text.toString().trim()
                val ctc = binding.currentCTC.editText?.text.toString().trim()
                val academicDetails = binding.academicDetails.editText?.text.toString().trim()
                val category = binding.category.selectedItem.toString()
                val time = binding.time.selectedItem.toString()
                var employeeDetail = ""
                if (list.isNotEmpty()) {
                    for (i in list) {
                        employeeDetail += i
                        employeeDetail += ","
                    }
                }
                val notableAccomplishments =
                    binding.notableAccomplishments.editText?.text.toString().trim()


                if (viewModel.verify(locationRef, ctc, academicDetails)) {
                    if (pdfUri == null) {
                        Toast.makeText(
                            context,
                            "CV Required",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        viewModel.upload(
                            category,
                            locationRef,
                            ctc,
                            time,
                            employeeDetail,
                            academicDetails,
                            notableAccomplishments,
                            pdfUri!!,
                            context!!
                        )
                    }
                } else {
                    Toast.makeText(
                        context,
                        "All fields with * are Required",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                viewModel.done()
            }

        })

        viewModel.showProgress?.observe(viewLifecycleOwner, Observer { show ->

            if (show) {
                progress.show()
                progress.progress = viewModel.progress
            } else {
                progress.dismiss()
                progress.progress = 0
            }
        })

        return binding.root
    }

    private fun setUpProgressDialog() {
        progress = ProgressDialog(context!!)
        progress.setTitle("Uploading Data...")
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
        progress.progress = 0
    }

    private fun setUpDataBindingAndViewModel(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) {
        binding = DataBindingUtil.inflate(inflater, R.layout.post_resume_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(PostResumeViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    private fun setUpRecyclerView() {
        list = mutableListOf()
        manager = LinearLayoutManager(context!!, LinearLayoutManager.HORIZONTAL, false)
        adapter = EmployeeAdapter(list)
        binding.recyclerView.layoutManager = manager
        binding.recyclerView.adapter = adapter
    }


    private fun setUpAdaptersSpinner() {
        val categoryAdapter =
            ArrayAdapter<String>(context!!, R.layout.spinner_post_resume, viewModel.category)
        val timeAdapter =
            ArrayAdapter<String>(context!!, R.layout.spinner_post_resume, viewModel.time)
        binding.category.adapter = categoryAdapter
        binding.time.adapter = timeAdapter
        //        binding.recyclerView.itemAnimator = DefaultItemAnimator()
    }


    fun uploadCV(context: Context) {

        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            selectPdf(context)
        } else {
            requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), PERMISSION_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        if (requestCode == PERMISSION_CODE && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            selectPdf(context!!)
        } else {
            Toast.makeText(
                context,
                "Permission Not Granted",
                Toast.LENGTH_SHORT
            ).show()
        }


    }

    private fun selectPdf(context: Context) {
        val intent = Intent()
        intent.type = "application/pdf"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, INTENT_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == INTENT_CODE && resultCode == Activity.RESULT_OK && data != null) {
            pdfUri = data.data!!
            binding.uploadResume.isEnabled = false
            Toast.makeText(
                context,
                "File Selected",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            Toast.makeText(
                context,
                "Please select PDF file",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}
