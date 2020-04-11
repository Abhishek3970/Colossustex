package com.example.colossustex.ColossusCare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.colossustex.R
import com.example.colossustex.databinding.AllResumesBinding

class Allresumes : AppCompatActivity() {
    lateinit var binding: AllResumesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.all_resumes)
        binding.allResumesRecycler.layoutManager=LinearLayoutManager(this)
        val data=AllresumesData("Student","Anubhav","Chandigarh")
        val list= mutableListOf(data,data,data)
        binding.allResumesRecycler.adapter=AllresumesAdapter(list)
    }
}
