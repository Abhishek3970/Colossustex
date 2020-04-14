package com.example.colossustex.colossusCare

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.colossustex.R
import com.example.colossustex.databinding.ResumeDetailsBinding
import com.google.firebase.storage.FirebaseStorage

class ResumeDetails : Fragment() {
    lateinit var binding: ResumeDetailsBinding
    lateinit var store: FirebaseStorage
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.resume_details, container, false)
        val args = ResumeDetailsArgs.fromBundle(arguments!!)
        binding.nameView.setText(args.name)
        binding.categoryView.setText(args.category)
        binding.locationView.setText(args.location)
        binding.ctcView.setText(args.ctc)
        binding.timeView.setText(args.time)
        binding.employerdetailsView.setText(args.employerDetails)
        binding.academicDetailsView.setText(args.academicDet)
        binding.accomplishmentsView.setText(args.accomplishments)
        val progress = ProgressDialog(context!!)
        progress.setTitle("Loading...")
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
        store = FirebaseStorage.getInstance()
        binding.viewResume.setOnClickListener {
            progress.show()
            progress.progress=50
            store.getReference("CV").child(args.id+".pdf").downloadUrl.addOnSuccessListener {
                val intent = Intent(Intent.ACTION_VIEW)
                progress.progress=50
                Log.i("u",it.toString())
                Log.i("u",args.id)
                intent.setData(it)
                progress.dismiss()
                startActivity(intent)
            }
        }
        return binding.root
    }

}
