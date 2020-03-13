package com.example.colossustex.SpinningMillOfIndia.Cotton


import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
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
import com.example.colossustex.SpinningMillOfIndia.Viscose.allpro_list
import com.example.colossustex.databinding.FragmentCottonTabbedBinding
import com.example.dialogcustom.SpinnerDialogAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CottonTabFragment : Fragment() {
    lateinit var binding: FragmentCottonTabbedBinding
    lateinit var viewed_list: MutableList<ViewedHistoryData>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_cotton_tabbed, container, false)
        val list1 = mutableListOf(binding.weaving, binding.hosiery)
        val list2 = mutableListOf(binding.openend, binding.ringspun, binding.vortex)
        val list3 = mutableListOf(
            binding.combed,
            binding.carded,
            binding.virgin,
            binding.giza,
            binding.combedcompact,
            binding.cardedcompact
        )
        val list4 = mutableListOf(
            binding.regular,
            binding.dyed,
            binding.spandex,
            binding.bci,
            binding.importedcotton,
            binding.organic
        )
        val list = mutableListOf<Int>()
        for (i in 1..200) {
            list.add(i)
        }
        val ref = FirebaseDatabase.getInstance().getReference("AllProducts")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
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
        var fourth_seg = ""
        val dialog = Dialog(context!!)
        val dialog2 = Dialog(context!!)
        dialog.setContentView(R.layout.viscose_dialog)
        dialog2.setContentView(R.layout.viscose_dialog2)
        val recycler = dialog.findViewById<RecyclerView>(R.id.viscose_recycler)
        recycler.layoutManager = GridLayoutManager(context, 4)
        recycler.adapter =
            SpinnerDialogAdapter(list, context!!, dialog2, dialog, binding.spinnerViscose)
        binding.spinnerViscose.setOnClickListener {
            dialog.show()
        }
        for (i in list1) {
            i.setOnClickListener {
                i.isSelected = true
                first_seg = i.text.toString()
                i.setTextColor(Color.WHITE)
                for (j in list1) {
                    if (j != i) {
                        j.isSelected = false
                        j.setTextColor(Color.BLACK)
                    }
                }
            }
        }
        for (i in list2) {
            second_seg = i.text.toString()
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
                third_seg = i.text.toString()
                i.setTextColor(Color.WHITE)
                for (j in list3) {
                    if (j != i) {
                        j.isSelected = false
                        j.setTextColor(Color.BLACK)
                    }
                }
            }
        }
        for (i in list4) {
            i.setOnClickListener {
                i.isSelected = true
                fourth_seg = i.text.toString()
                i.setTextColor(Color.WHITE)
                for (j in list4) {
                    if (j != i) {
                        j.isSelected = false
                        j.setTextColor(Color.BLACK)
                    }
                }
            }
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
                            val data = datasnap.getValue(ViewedHistoryData::class.java)
                            viewed_list.add(data!!)
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
            if (first_seg != "" && second_seg != "" && third_seg != "" && fourth_seg != "" && binding.spinnerViscose.text.toString() != "--Select Count--") {
                Toast.makeText(context, "Search History Updated", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, AllProducts::class.java).putExtra("f", first_seg)
                    .putExtra("s", second_seg).putExtra("t", third_seg).putExtra("f", fourth_seg)
                    .putExtra("c", binding.spinnerViscose.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(context, "Select All options", Toast.LENGTH_SHORT).show()
            }
        }
        // When Search Button is pressed
        return binding.root
    }


}
