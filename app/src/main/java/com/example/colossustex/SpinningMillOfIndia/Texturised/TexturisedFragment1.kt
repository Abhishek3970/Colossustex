package com.example.colossustex.SpinningMillOfIndia.Texturised


import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R
import com.example.colossustex.SpinningMillOfIndia.Viscose.ViewedHistoryAdapter
import com.example.colossustex.SpinningMillOfIndia.Viscose.ViewedHistoryData
import com.example.colossustex.databinding.TexturisedFragment1Binding
import com.example.dialogcustom.SpinnerDialogAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class TexturisedFragment1 : Fragment() {
    lateinit var binding: TexturisedFragment1Binding
    lateinit var viewed_list: MutableList<ViewedHistoryData>
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.texturised_fragment1, container, false)
        val list = mutableListOf(
            binding.brightText,
            binding.fulldull,
            binding.catonicText,
            binding.FDYText,
            binding.semidullText,
            binding.airtex,
            binding.blackdope,
            binding.stretch
        )
        val list2 = mutableListOf(binding.NIM, binding.GFT, binding.LIM, binding.IM, binding.HIM)
        val list3 = mutableListOf(binding.firstText, binding.PQ, binding.CLQ, binding.STD)
        val data = mutableListOf<Int>()
        for (i in 1..500) {
            data.add(i)
        }
        val dialog = Dialog(context!!)
        val dialog2 = Dialog(context!!)
        dialog.setContentView(R.layout.viscose_dialog)
        dialog2.setContentView(R.layout.viscose_dialog2)
        val recycler = dialog.findViewById<RecyclerView>(R.id.viscose_recycler)
        recycler.layoutManager = GridLayoutManager(context, 4)
        recycler.adapter = SpinnerDialogAdapter(data, context!!, dialog2,dialog,binding.spinnerViscose)
        binding.spinnerViscose.setOnClickListener {
            dialog.show()
        }
        for (i in list) {
            i.setOnClickListener {
                i.isSelected = true
                i.setTextColor(Color.WHITE)
                for (j in list) {
                    if (j != i) {
                        j.setTextColor(Color.BLACK)
                        j.isSelected = false
                    }
                }
            }
        }
        for (i in list2) {
            i.setOnClickListener {
                i.isSelected = true
                i.setTextColor(Color.WHITE)
                for (j in list2) {
                    if (j != i) {
                        j.isSelected = false
                        j.setTextColor(Color.BLACK)
                    }
                }
            }
        }
        for (i in list3) {
            i.setOnClickListener {
                i.isSelected = true
                i.setTextColor(Color.WHITE)
                for (j in list3) {
                    if (j != i) {
                        j.setTextColor(Color.BLACK)
                        j.isSelected = false
                    }
                }
            }
        }
        binding.regularText.setOnClickListener {
            binding.regularText.isSelected = true
            binding.regularText.setTextColor(Color.WHITE)
            binding.dyedText.isSelected = false
            binding.dyedText.setTextColor(Color.BLACK)
        }
        binding.dyedText.setOnClickListener {
            binding.dyedText.isSelected = true
            binding.dyedText.setTextColor(Color.WHITE)
            binding.regularText.isSelected = false
            binding.regularText.setTextColor(Color.BLACK)
        }
        val dialog_search_history = Dialog(context!!)
        dialog_search_history.setContentView(R.layout.dialog_viewed_history)
        val recycler2 =
            dialog_search_history.findViewById<RecyclerView>(R.id.recycler_search_history)
        recycler2.layoutManager = LinearLayoutManager(context)
        binding.viewedHistoryViscose.setOnClickListener {
            val ref3 = FirebaseDatabase.getInstance().getReference("ViscoseHistory").child("ViewedHistory")
            ref3.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(p0: DataSnapshot) {
                    if (p0.exists()) {
                        dialog_search_history.findViewById<androidx.appcompat.widget.Toolbar>(R.id.search_his_toolbar)
                            .title = "Viewed History"
                        viewed_list = mutableListOf()
                        for (datasnap in p0.children) {
                            val data2 = datasnap.getValue(ViewedHistoryData::class.java)
                            viewed_list.add(data2!!)
                        }
                        viewed_list.reverse()
                        recycler2.adapter = ViewedHistoryAdapter(viewed_list)
                        dialog_search_history.show()
                    } else {
                        Snackbar.make(
                            binding.coordinator,
                            "NO HISTORY",
                            Snackbar.LENGTH_SHORT
                        ).setTextColor(Color.WHITE).show()
                    }
                }

            })
        }
        return binding.root
    }


}
