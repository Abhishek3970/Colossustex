package com.example.colossustex.SpinningMillOfIndia.Cotton


import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.colossustex.R
import com.example.colossustex.SpinningMillOfIndia.Common.AllMillsData
import com.example.colossustex.SpinningMillOfIndia.Common.MillsListAdapter
import com.example.colossustex.SpinningMillOfIndia.Common.list_all
import com.example.colossustex.databinding.MillsListFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.database.FirebaseDatabase

class KnittingYarn : Fragment() {

    lateinit var database: FirebaseDatabase
    lateinit var binding: MillsListFragmentBinding
    lateinit var data: AllMillsData
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.mills_list_fragment, container, false)
        binding.viscoseRecycler2.layoutManager = LinearLayoutManager(context)
        binding.progressLayout.visibility = View.VISIBLE
        database = FirebaseDatabase.getInstance()
        binding.allYarn.text = "Knitting Yarn"
//        val mdata = database.getReference("Viscose")
//        mdata.addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onCancelled(p0: DatabaseError) {
//
//            }
//
//            override fun onDataChange(p0: DataSnapshot) {
//                list = mutableListOf()
//                for (snapshot in p0.children) {
//                    val store = snapshot.getValue(AllMillsData::class.java)
//                    list.add(store!!)
//                }
//                binding.progressLayout.visibility = View.GONE
//            }
//        })
        val dialog = BottomSheetDialog(context!!)
        dialog.setContentView(R.layout.filter_dialog)
        dialog.create()
        dialog.setCancelable(false)
        val apply = dialog.findViewById<TextView>(R.id.apply)!!
        val close = dialog.findViewById<ImageView>(R.id.close_dialog)!!
        val checkbox1 = dialog.findViewById<CheckBox>(R.id.checkBox1)!!
        val checkbox2 = dialog.findViewById<CheckBox>(R.id.checkBox2)!!
        val checkbox3 = dialog.findViewById<CheckBox>(R.id.checkBox3)!!
        val checkbox4 = dialog.findViewById<CheckBox>(R.id.checkBox4)!!
        val checkbox5 = dialog.findViewById<CheckBox>(R.id.checkBox5)!!
        binding.filter.setOnClickListener {
            dialog.show()
            close.setOnClickListener {
                dialog.dismiss()
            }
            apply.setOnClickListener {
                val filterlist = mutableListOf<String>()
                if (checkbox1.isChecked) {
                    filterlist.add(checkbox1.text.toString())

                }
                if (checkbox2.isChecked) {
                    filterlist.add(checkbox2.text.toString())

                }
                if (checkbox3.isChecked) {
                    filterlist.add(checkbox3.text.toString())

                }
                if (checkbox4.isChecked) {
                    filterlist.add(checkbox4.text.toString())

                }
                if (checkbox5.isChecked) {
                    filterlist.add(checkbox5.text.toString())

                }
                if (!(checkbox1.isChecked or checkbox2.isChecked or checkbox3.isChecked
                            or checkbox4.isChecked or checkbox5.isChecked)
                ) {
                    binding.viscoseRecycler2.adapter =
                        MillsListAdapter(
                            list_all
                        )

                } else {
                    val newlist1 = mutableListOf<AllMillsData>()
                    for (i in list_all) {
                        for (j in filterlist) {
                            if (i.text1.toLowerCase().trim().contains(j.toLowerCase().trim())) {
                                newlist1.add(i)
                            }
                        }

                    }
                    binding.viscoseRecycler2.adapter =
                        MillsListAdapter(
                            newlist1
                        )
                }
                dialog.dismiss()
            } //Filtering is implemented here
        }
        binding.editSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            @SuppressLint("DefaultLocale")
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val newlist = mutableListOf<AllMillsData>()
                for (i in list_all) {
                    if (i.text1.toLowerCase().trim().contains(s.toString().toLowerCase().trim())) {
                        newlist.add(i)
                    }
                }
                binding.viscoseRecycler2.adapter =
                    MillsListAdapter(
                        newlist
                    )
            }

        }) //Searching feature is implemented

        return binding.root

    }

    override fun onStart() {
        super.onStart()
        val newlist = mutableListOf<AllMillsData>()
        for (i in list_all) {
            if (i.text1.toLowerCase().trim().contains("anubhav")) {
                newlist.add(i)
            }
        }
        binding.progressLayout.visibility = View.GONE
        binding.viscoseRecycler2.adapter = MillsListAdapter(newlist)
    }
}
