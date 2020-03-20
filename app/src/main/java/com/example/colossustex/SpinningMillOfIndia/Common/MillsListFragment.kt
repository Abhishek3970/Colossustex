package com.example.colossustex.SpinningMillOfIndia.Common

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
import com.example.colossustex.databinding.MillsListFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

lateinit var list_all_mill: MutableList<AllMillsData>

class MillsListFragment : Fragment() {
    lateinit var database: FirebaseDatabase
    lateinit var binding: MillsListFragmentBinding

    lateinit var data: AllMillsData
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        list_all_mill = mutableListOf()
        binding = DataBindingUtil.inflate(inflater, R.layout.mills_list_fragment, container, false)
        binding.viscoseRecycler2.layoutManager = LinearLayoutManager(context)
        binding.progressLayout.visibility = View.VISIBLE
        database = FirebaseDatabase.getInstance()
        val mdata = database.getReference("Viscose")
        mdata.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                list_all_mill = mutableListOf()
                for (snapshot in p0.children) {
                    val store = snapshot.getValue(AllMillsData::class.java)
                    list_all_mill.add(store!!)
                }
                binding.progressLayout.visibility = View.GONE
                binding.viscoseRecycler2.adapter =
                    MillsListAdapter(
                        list_all_mill
                    )
            }
        })
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
        val checkbox5=  dialog.findViewById<CheckBox>(R.id.checkBox5)!!
        val checkbox6 = dialog.findViewById<CheckBox>(R.id.checkBox6)!!
        val checkbox7 = dialog.findViewById<CheckBox>(R.id.checkBox7)!!
        val checkbox8 = dialog.findViewById<CheckBox>(R.id.checkBox8)!!
        val checkbox9 = dialog.findViewById<CheckBox>(R.id.checkBox9)!!
        val checkbox10 = dialog.findViewById<CheckBox>(R.id.checkBox10)!!
        val checkbox11 = dialog.findViewById<CheckBox>(R.id.checkBox11)!!
        val checkbox12 = dialog.findViewById<CheckBox>(R.id.checkBox12)!!
        val checkbox13 = dialog.findViewById<CheckBox>(R.id.checkBox13)!!
        val checkbox14 = dialog.findViewById<CheckBox>(R.id.checkBox14)!!
        val checkbox15 = dialog.findViewById<CheckBox>(R.id.checkBox15)!!
        val checkbox16 = dialog.findViewById<CheckBox>(R.id.checkBox16)!!
        val checkbox17 = dialog.findViewById<CheckBox>(R.id.checkBox17)!!
        val checkbox18 = dialog.findViewById<CheckBox>(R.id.checkBox18)!!
        val checkbox19 = dialog.findViewById<CheckBox>(R.id.checkBox19)!!
        val checkbox20 = dialog.findViewById<CheckBox>(R.id.checkBox20)!!
        val checkbox21 = dialog.findViewById<CheckBox>(R.id.checkBox21)!!
        val checkbox22 = dialog.findViewById<CheckBox>(R.id.checkBox22)!!
        val checkbox23 = dialog.findViewById<CheckBox>(R.id.checkBox23)!!
        val checkbox24 = dialog.findViewById<CheckBox>(R.id.checkBox24)!!
        val checkbox25 = dialog.findViewById<CheckBox>(R.id.checkBox25)!!
        val checkbox26 = dialog.findViewById<CheckBox>(R.id.checkBox26)!!
        val checkbox27 = dialog.findViewById<CheckBox>(R.id.checkBox27)!!
        val checkbox28 = dialog.findViewById<CheckBox>(R.id.checkBox28)!!
        val checkbox29 = dialog.findViewById<CheckBox>(R.id.checkBox29)!!
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
                if (checkbox6.isChecked) {
                    filterlist.add(checkbox6.text.toString())

                }
                if (checkbox7.isChecked) {
                    filterlist.add(checkbox7.text.toString())

                }
                if (checkbox8.isChecked) {
                    filterlist.add(checkbox8.text.toString())

                }
                if (checkbox9.isChecked) {
                    filterlist.add(checkbox9.text.toString())

                }
                if (checkbox10.isChecked) {
                    filterlist.add(checkbox10.text.toString())

                }
                if (checkbox11.isChecked) {
                    filterlist.add(checkbox11.text.toString())

                }
                if (checkbox12.isChecked) {
                    filterlist.add(checkbox12.text.toString())

                }
                if (checkbox13.isChecked) {
                    filterlist.add(checkbox13.text.toString())

                }
                if (checkbox14.isChecked) {
                    filterlist.add(checkbox14.text.toString())

                }
                if (checkbox15.isChecked) {
                    filterlist.add(checkbox15.text.toString())

                }
                if (checkbox16.isChecked) {
                    filterlist.add(checkbox16.text.toString())

                }
                if (checkbox17.isChecked) {
                    filterlist.add(checkbox17.text.toString())

                }
                if (checkbox18.isChecked) {
                    filterlist.add(checkbox18.text.toString())

                }
                if (checkbox19.isChecked) {
                    filterlist.add(checkbox19.text.toString())

                }
                if (checkbox20.isChecked) {
                    filterlist.add(checkbox20.text.toString())

                }
                if (checkbox21.isChecked) {
                    filterlist.add(checkbox21.text.toString())

                }
                if (checkbox22.isChecked) {
                    filterlist.add(checkbox22.text.toString())

                }
                if (checkbox23.isChecked) {
                    filterlist.add(checkbox23.text.toString())

                }
                if (checkbox24.isChecked) {
                    filterlist.add(checkbox24.text.toString())

                }
                if (checkbox25.isChecked) {
                    filterlist.add(checkbox25.text.toString())

                }
                if (checkbox26.isChecked) {
                    filterlist.add(checkbox26.text.toString())

                }
                if (checkbox27.isChecked) {
                    filterlist.add(checkbox27.text.toString())

                }
                if (checkbox28.isChecked) {
                    filterlist.add(checkbox28.text.toString())

                }
                if (checkbox29.isChecked) {
                    filterlist.add(checkbox29.text.toString())

                }
                if (filterlist.size==0)
                {
                    binding.viscoseRecycler2.adapter =
                        MillsListAdapter(
                            list_all_mill
                        )

                } else {
                    val newlist1 = mutableListOf<AllMillsData>()
                    for (i in list_all_mill) {
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
                for (i in list_all_mill) {
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
}
