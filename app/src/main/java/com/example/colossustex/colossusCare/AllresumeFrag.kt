package com.example.colossustex.colossusCare

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.colossustex.R
import com.example.colossustex.databinding.AllResumesBinding

class AllresumeFrag : Fragment() {
    lateinit var binding: AllResumesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.all_resumes,container,false)
        binding.allResumesRecycler.layoutManager= LinearLayoutManager(context!!)
        val data=AllresumesData("Student","Anubhav","Chandigarh")
        val list= mutableListOf(data,data,data)
        binding.allResumesRecycler.adapter=AllresumesAdapter(list)
        binding.toolbarResumes.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }

}
