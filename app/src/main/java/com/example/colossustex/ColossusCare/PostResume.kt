package com.example.colossustex.ColossusCare

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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


        return binding.root
    }



}
