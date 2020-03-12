package com.example.colossustex.SpinningMillOfIndia.Viscose

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R
import com.example.colossustex.SpinningMillOfIndia.Common.AllProducts
import com.example.colossustex.databinding.ViscoseFragment1Binding
import com.example.dialogcustom.SpinnerDialogAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.texturised_fragment1.*

class ViscoseFragment : Fragment() {


    lateinit var list: MutableList<Int>
    lateinit var binding: ViscoseFragment1Binding
    lateinit var dialog: Dialog
    lateinit var viewed_list: MutableList<ViewedHistoryData>
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var dialog2: Dialog
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        list = mutableListOf()
        for (i in 1..200) {
            list.add(i)
        }
        binding = DataBindingUtil.inflate(inflater, R.layout.viscose_fragment1, container, false)
        dialog = Dialog(context!!)
        dialog2 = Dialog(context!!)
        firebaseDatabase = FirebaseDatabase.getInstance()
        val ref = firebaseDatabase.getReference("Viscose")
        val history_ref = firebaseDatabase.getReference("ViscoseHistory")
        dialog2.setContentView(R.layout.viscose_dialog2)
        dialog.setContentView(R.layout.viscose_dialog)
        val dialog_search_history = Dialog(context!!)
        dialog_search_history.setContentView(R.layout.dialog_viewed_history)
        val recycler2 =
            dialog_search_history.findViewById<RecyclerView>(R.id.recycler_search_history)
        recycler2.layoutManager = LinearLayoutManager(context)
        val recycler = dialog.findViewById<RecyclerView>(R.id.viscose_recycler)
        recycler.layoutManager = GridLayoutManager(context, 4)
        recycler.adapter =
            SpinnerDialogAdapter(list, context!!, dialog2, dialog, binding.spinnerViscose)
        binding.spinnerViscose.setOnClickListener {
            showdialog()
        } //Call for dialog function
        var first_seg = ""
        var second_seg = ""
        var third_seg = ""
        binding.vortexId.setOnClickListener {
            first_seg = binding.vortexId.text.toString()
            binding.ringspunId.setBackgroundResource(R.drawable.viscose_text_middle)
            binding.ringspunId.setTextColor(Color.BLACK)
            binding.openendId.setBackgroundResource(R.drawable.viscose_text_left)
            binding.openendId.setTextColor(Color.BLACK)

            binding.vortexId.setBackgroundResource(R.drawable.viscose_clicked_right)
            binding.vortexId.setTextColor(Color.WHITE)

        }
        binding.ringspunId.setOnClickListener {
            first_seg = binding.ringspunId.text.toString()
            binding.openendId.setBackgroundResource(R.drawable.viscose_text_left)
            binding.openendId.setTextColor(Color.BLACK)
            binding.vortexId.setBackgroundResource(R.drawable.viscose_text_right)
            binding.vortexId.setTextColor(Color.BLACK)
            binding.ringspunId.setBackgroundResource(R.drawable.viscose_clicked_middle)
            binding.ringspunId.setTextColor(Color.WHITE)


        }
        binding.openendId.setOnClickListener {
            first_seg = binding.openendId.text.toString()
            binding.ringspunId.setBackgroundResource(R.drawable.viscose_text_middle)
            binding.ringspunId.setTextColor(Color.BLACK)
            binding.vortexId.setBackgroundResource(R.drawable.viscose_text_right)
            binding.vortexId.setTextColor(Color.BLACK)
            binding.openendId.setBackgroundResource(R.drawable.viscose_clicked_left)
            binding.openendId.setTextColor(Color.WHITE)

        }
        binding.warpId.setOnClickListener {
            second_seg = binding.warpId.text.toString()
            binding.weftId.setBackgroundResource(R.drawable.viscose_text_right)
            binding.weftId.setTextColor(Color.BLACK)
            binding.warpId.setBackgroundResource(R.drawable.viscose_clicked_left)
            binding.warpId.setTextColor(Color.WHITE)

        }
        binding.weftId.setOnClickListener {
            second_seg = binding.weftId.text.toString()
            binding.warpId.setBackgroundResource(R.drawable.viscose_text_left)
            binding.warpId.setTextColor(Color.BLACK)
            binding.weftId.setBackgroundResource(R.drawable.viscose_clicked_right)
            binding.weftId.setTextColor(Color.WHITE)


        }
        binding.regularId.setOnClickListener {
            third_seg = binding.regularId.text.toString()
            binding.dyedId.setBackgroundResource(R.drawable.viscose_text_middle)
            binding.dyedId.setTextColor(Color.BLACK)
            binding.spandexId.setBackgroundResource(R.drawable.viscose_text_right)
            binding.spandexId.setTextColor(Color.BLACK)
            binding.regularId.setBackgroundResource(R.drawable.viscose_clicked_left)
            binding.regularId.setTextColor(Color.WHITE)

        }
        binding.dyedId.setOnClickListener {
            third_seg = binding.dyedId.text.toString()
            binding.regularId.setBackgroundResource(R.drawable.viscose_text_left)
            binding.regularId.setTextColor(Color.BLACK)
            binding.spandexId.setBackgroundResource(R.drawable.viscose_text_middle)
            binding.spandexId.setTextColor(Color.BLACK)
            binding.dyedId.setBackgroundResource(R.drawable.viscose_clicked_middle)
            binding.dyedId.setTextColor(Color.WHITE)

        }
        binding.spandexId.setOnClickListener {
            third_seg = binding.spandexId.text.toString()
            binding.dyedId.setBackgroundResource(R.drawable.viscose_text_middle)
            binding.dyedId.setTextColor(Color.BLACK)
            binding.regularId.setBackgroundResource(R.drawable.viscose_text_left)
            binding.regularId.setTextColor(Color.BLACK)
            binding.spandexId.setBackgroundResource(R.drawable.viscose_clicked_right)
            binding.spandexId.setTextColor(Color.WHITE)

        }
        binding.searchId.setOnClickListener {
            val data = ViewedHistoryData(first_seg, second_seg, third_seg)
            if (data.first != "" && data.second != "" && data.third != "") {
                Toast.makeText(context, "Search History Updated", Toast.LENGTH_SHORT).show()
                val key = ref.push().key
                val history_ref2 = history_ref.child("Search History").child(key!!)
                history_ref2.setValue(data)
                val intent = Intent(context, AllProducts::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(context, "Select All options", Toast.LENGTH_SHORT).show()
            }

        }// When Search Button is pressed
        binding.searchHistoryViscose.setOnClickListener {
            val ref3 = history_ref.child("Search History")
            ref3.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(p0: DataSnapshot) {
                    if (p0.exists()) {
                        dialog_search_history.findViewById<androidx.appcompat.widget.Toolbar>(R.id.search_his_toolbar)
                            .title = "Search History"
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
                            binding.coordinatorLayout,
                            "NO HISTORY",
                            Snackbar.LENGTH_SHORT
                        ).setTextColor(Color.WHITE).show()
                    }
                }

            })
        }     //When Search History is pressed
        binding.viewedHistoryViscose.setOnClickListener {
            val ref3 = history_ref.child("ViewedHistory")
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
                            binding.coordinatorLayout,
                            "NO HISTORY",
                            Snackbar.LENGTH_SHORT
                        ).setTextColor(Color.WHITE).show()
                    }
                }

            })
        }
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun showdialog() {

        dialog.show()

    }   //Function to show dialog 1

}
