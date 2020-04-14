package com.example.colossustex.colossusCare

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.colossustex.R
import com.example.colossustex.databinding.ResumeDetailsBinding

class ResumeDetails : Fragment() {
    lateinit var binding: ResumeDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.resume_details,container,false)
        val args=ResumeDetailsArgs.fromBundle(arguments!!)
        binding.nameView.setText(args.name)
        binding.categoryView.setText(args.category)
        binding.locationView.setText(args.location)
        binding.ctcView.setText(args.ctc)
        binding.timeView.setText(args.time)
        binding.employerdetailsView.setText(args.employerDetails)
        binding.academicDetailsView.setText(args.academicDet)
        binding.accomplishmentsView.setText(args.accomplishments)
        return binding.root
    }

}
