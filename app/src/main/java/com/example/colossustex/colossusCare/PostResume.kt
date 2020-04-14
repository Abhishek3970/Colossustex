package com.example.colossustex.colossusCare

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.colossustex.R
import com.example.colossustex.databinding.PostResumeFragmentBinding

class PostResume : Fragment() {

    private lateinit var viewModel: PostResumeViewModel
    private lateinit var binding: PostResumeFragmentBinding
    private lateinit var adapter: EmployeeAdapter
    private lateinit var list: MutableList<String>
    private lateinit var manager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setUpDataBindingAndViewModel(inflater, container)

        setUpAdaptersSpinner()

        setUpRecyclerView()

        viewModel.addMore?.observe(viewLifecycleOwner , Observer {add->
            if(add){
                val newText = binding.employDetails.editText?.text.toString().trim()
                if(newText.isNotEmpty()) {
                    list.add(newText)
                    adapter.notifyDataSetChanged()
                    Toast.makeText(context!! , "Added",Toast.LENGTH_SHORT).show()
                    binding.employDetails.editText?.text?.clear()
                }
                else
                    Toast.makeText(context!! , "First Enter Field..",Toast.LENGTH_SHORT).show()

                viewModel.done()
            }

        })


        viewModel.uploadCV?.observe(viewLifecycleOwner , Observer {uploadCV->
            if(uploadCV){
                viewModel.uploadCV(context!!)
                viewModel.done()
            }
        })

        return binding.root
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


}
