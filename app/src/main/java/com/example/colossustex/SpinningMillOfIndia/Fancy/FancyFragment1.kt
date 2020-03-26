package com.example.colossustex.SpinningMillOfIndia.Fancy


import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R
import com.example.colossustex.SpinningMillOfIndia.Common.AllProducts
import com.example.colossustex.SpinningMillOfIndia.Common.AllproductsData
import com.example.colossustex.SpinningMillOfIndia.Viscose.ViewedHistoryAdapter
import com.example.colossustex.SpinningMillOfIndia.Viscose.ViewedHistoryData
import com.example.colossustex.SpinningMillOfIndia.allpro_list
import com.example.colossustex.databinding.FragmentFancy1Binding
import com.example.dialogcustom.SpinnerDialogAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FancyFragment1 : Fragment() {
    lateinit var binding: FragmentFancy1Binding
    lateinit var viewed_list: MutableList<ViewedHistoryData>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fancy1, container, false)
        val list = mutableListOf(
            binding.cotton,
            binding.pc,
            binding.pv,
            binding.psf,
            binding.vsf,
            binding.texturised
        )
        val list2 = mutableListOf(
            binding.slub,
            binding.modal,
            binding.excel,
            binding.tencel,
            binding.multicolor
        )
        val data = mutableListOf<Int>()
        for (i in 1..200) {
            data.add(i)
        }
        val ref = FirebaseDatabase.getInstance().getReference("AllProducts")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                Log.i("Fello", "Listupdated")
                if (p0.exists()) {
                    allpro_list = mutableListOf()
                    for (datasnap in p0.children) {
                        val data2 = datasnap.getValue(AllproductsData::class.java)
                        allpro_list.add(data2!!)
                    }
                }
            }
        })
        var first_seg = ""
        var second_seg = ""
        var third_seg = ""
        val dialog = Dialog(context!!)
        val dialog2 = Dialog(context!!)
        dialog2.setContentView(R.layout.viscose_dialog2)
        dialog.setContentView(R.layout.viscose_dialog)
        val recycler = dialog.findViewById<RecyclerView>(R.id.viscose_recycler)
        recycler.layoutManager = GridLayoutManager(context, 4)
        recycler.adapter =
            SpinnerDialogAdapter(data, context!!, dialog2, dialog, binding.spinnerViscose)
        for (i in list) {
            i.setOnClickListener {
                i.isSelected = true
                first_seg = i.text.toString()
                i.setTextColor(Color.WHITE)
                for (j in list) {
                    if (j != i) {
                        j.isSelected = false
                        j.setTextColor(Color.BLACK)
                    }
                }
            }
        }
        binding.spinnerViscose.setOnClickListener {
            dialog.show()
        }

        for (i in list2) {
            i.setOnClickListener {
                second_seg = i.text.toString()
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
        binding.regular.setOnClickListener {
            third_seg = binding.regular.text.toString()
            it.isSelected = true
            binding.regular.setTextColor(Color.WHITE)
            binding.dyed.isSelected = false
            binding.dyed.setTextColor(Color.BLACK)
        }
        binding.dyed.setOnClickListener {
            it.isSelected = true
            third_seg = binding.dyed.text.toString()
            binding.regular.isSelected = false
            binding.regular.setTextColor(Color.BLACK)
            binding.dyed.setTextColor(Color.WHITE)
        }
        val dialog_search_history = Dialog(context!!)
        dialog_search_history.setContentView(R.layout.dialog_viewed_history)
        val recycler2 =
            dialog_search_history.findViewById<RecyclerView>(R.id.recycler_search_history)
        recycler2.layoutManager = LinearLayoutManager(context)
        binding.viewedHistoryViscose.setOnClickListener {
            val ref3 =
                FirebaseDatabase.getInstance().getReference("ViscoseHistory").child("ViewedHistory")
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
        binding.searchId.setOnClickListener {
            val selec = ViewedHistoryData(first_seg, second_seg, third_seg)
            if (selec.first != "" && selec.second != "" && selec.third != "" && binding.spinnerViscose.text.toString() != "--Select Count--") {
                val intent = Intent(context, AllProducts::class.java).putExtra("f", first_seg)
                    .putExtra("s", second_seg).putExtra("t", third_seg)
                    .putExtra("c", binding.spinnerViscose.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(context, "Select All options", Toast.LENGTH_SHORT).show()
            }

        }// When Search Button is pressed
        return binding.root
    }
}
