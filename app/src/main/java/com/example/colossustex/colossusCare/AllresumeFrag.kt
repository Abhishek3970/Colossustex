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
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AllresumeFrag : Fragment() {
    lateinit var binding: AllResumesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.all_resumes,container,false)
        binding.allResumesRecycler.layoutManager= LinearLayoutManager(context!!)

        binding.toolbarResumes.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        val ref=FirebaseDatabase.getInstance().getReference("ResumeData")
        ref.addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                val resumelist= mutableListOf<AllresumesData>()
                if(p0.exists()){
                    for(i in p0.children){
                        val resdata=i.getValue(AllresumesData::class.java)
                        resumelist.add(resdata!!)
                    }
                    binding.allResumesRecycler.adapter=AllresumesAdapter(resumelist)
                }
            }

        })
        return binding.root
    }

}
