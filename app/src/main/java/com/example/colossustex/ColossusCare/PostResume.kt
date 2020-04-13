package com.example.colossustex.ColossusCare

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil

import com.example.colossustex.R
import com.example.colossustex.databinding.PostResumeFragmentBinding

class PostResume : Fragment() {

    private lateinit var viewModel: PostResumeViewModel
    private lateinit var binding: PostResumeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.post_resume_fragment  , container , false)
        viewModel = ViewModelProviders.of(this).get(PostResumeViewModel::class.java)

        setUpAdapters()



        return binding.root
    }



    private fun setUpAdapters() {
        val categoryAdapter =
            ArrayAdapter<String>(context!!, R.layout.spinner_post_resume, viewModel.category)
        val timeAdapter =
            ArrayAdapter<String>(context!!, R.layout.spinner_post_resume, viewModel.time)
        binding.category.adapter = categoryAdapter
        binding.time.adapter = timeAdapter
    }


}
