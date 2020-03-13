package com.example.colossustex.SpinningMillOfIndia.Common

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.MainActivity
import com.example.colossustex.R
import com.example.colossustex.SpinningMillOfIndia.Viscose.ViewedHistoryData
import com.example.colossustex.SpinningMillOfIndia.Viscose.allpro_list
import com.example.colossustex.databinding.FragmentAllProductsBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class AllProducts : AppCompatActivity() {
    lateinit var newlist: MutableList<AllproductsData>
    lateinit var list2: MutableList<ViewedHistoryData>
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var binding: FragmentAllProductsBinding
    lateinit var selectedlist: MutableList<AllproductsData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_all_products)
        binding.toolbar.inflateMenu(R.menu.viscose_menu)
        binding.progressbarAllproducts.visibility = View.VISIBLE
        binding.allProductsRecycler.layoutManager = LinearLayoutManager(this)
        val f = intent.getStringExtra("f")
        val s = intent.getStringExtra("s")
        val t = intent.getStringExtra("t")
        val c = intent.getStringExtra("c")
        val head = intent.getStringExtra("Head")
        val type = intent.getStringExtra("Type")
        val loc = intent.getStringExtra("Location")
        if (f != null && s != null && t != null && c != null) {
            selectedlist = mutableListOf()
            for (i in allpro_list) {
                if (i.text2.toLowerCase().trim().contains(f.toLowerCase().trim()) || i.text2.toLowerCase().trim().contains(
                        s.toLowerCase().trim()
                    )
                ) {
                    selectedlist.add(i)
                }
            }
            binding.resultsAllpro.visibility=View.VISIBLE
            binding.constraint.visibility=View.GONE
            binding.progressbarAllproducts.visibility = View.GONE
            if (selectedlist.isNotEmpty()) {
                binding.nores.text="Showing results for:"
                binding.nores.setTextColor(Color.BLACK)
                binding.first.text = c
                binding.second.text = f
                binding.third.text=s
                binding.fourth.text=t
                binding.allProductsRecycler.adapter = AllProductAdapter(this, selectedlist)
            } else {
                binding.nores.text="NO RESULTS"
                binding.nores.setTextColor(Color.RED)
                binding.first.text = c
                binding.second.text = f
                binding.third.text=s
                binding.fourth.text=t

            }
        } else {
            val ref = FirebaseDatabase.getInstance().getReference("AllProducts")
            ref.addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(p0: DataSnapshot) {
                    if (p0.exists()) {
                        selectedlist = mutableListOf()
                        for (datasnap in p0.children) {
                            val data = datasnap.getValue(AllproductsData::class.java)
                            selectedlist.add(data!!)
                        }
                        binding.progressbarAllproducts.visibility = View.GONE
                        binding.allProductsRecycler.adapter =
                            AllProductAdapter(this@AllProducts, selectedlist)
                    }
                }
            })
        }
        if (head != null && type != null && loc != null) {
            binding.resultsAllpro.visibility=View.GONE
            binding.constraint.visibility=View.VISIBLE
            binding.mainhead.text = head
            binding.type.text = type
            binding.location.text = loc
        }
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        val mref = FirebaseDatabase.getInstance().getReference("Search History")
        mref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()) {
                    list2 = mutableListOf()
                    for (datasnap in p0.children) {
                        val data = datasnap.getValue(ViewedHistoryData::class.java)
                        list2.add(data!!)
                    }
                    list2.reverse()
                }
            }

        })
        binding.allProductsRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    binding.filterAllproducts.visibility = View.VISIBLE
                }
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    binding.filterAllproducts.visibility = View.INVISIBLE
                }
            }
        })
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.home_id -> {
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    overridePendingTransition(
                        R.anim.nav_default_enter_anim,
                        R.anim.nav_default_exit_anim
                    )
                }
            }
            true
        }
        val dal = BottomSheetDialog(this)
        dal.setContentView(R.layout.sort_dialog)
        val rg1 = dal.findViewById<RadioGroup>(R.id.radiogroup1)
        val rg2 = dal.findViewById<RadioGroup>(R.id.radiogroup2)
        val button = dal.findViewById<TextView>(R.id.go)
        binding.sort.setOnClickListener {
            dal.show()
            button!!.setOnClickListener {
                val id1 = rg1?.checkedRadioButtonId
                val id2 = rg2?.checkedRadioButtonId
                when (id1) {
                    R.id.price -> {
                        when (id2) {
                            R.id.lth -> {
                                for (i in 0 until selectedlist.size) {
                                    for (j in i until selectedlist.size) {
                                        val s1 = selectedlist[i].text6.replace(".00/kg", "")
                                        val s2 = selectedlist[j].text6.replace(".00/kg", "")
                                        if (s1.toInt() > s2.toInt()) {
                                            val t = selectedlist[i]
                                            selectedlist[i] = selectedlist[j]
                                            selectedlist[j] = t
                                        }
                                    }
                                }
                                binding.allProductsRecycler.adapter?.notifyDataSetChanged()


                            } //Sorting of Price low to high Algorithm implemented here
                            R.id.htl -> {
                                for (i in 0 until selectedlist.size) {
                                    for (j in i until selectedlist.size) {
                                        val s1 = selectedlist[i].text6.replace(".00/kg", "")
                                        val s2 = selectedlist[j].text6.replace(".00/kg", "")
                                        if (s1.toInt() < s2.toInt()) {
                                            val t = selectedlist[i]
                                            selectedlist[i] = selectedlist[j]
                                            selectedlist[j] = t
                                        }
                                    }
                                }
                                binding.allProductsRecycler.adapter?.notifyDataSetChanged()


                            } //Soring of Price high to low implemented here
                        }   //Taking id of second checked checkbox
                    }
                    R.id.count -> {
                        when (id2) {
                            R.id.lth -> {
                                for (i in 0 until selectedlist.size) {
                                    for (j in i until selectedlist.size) {
                                        if (selectedlist[i].text10.toInt() > selectedlist[j].text10.toInt()) {
                                            val t = selectedlist[i]
                                            selectedlist[i] = selectedlist[j]
                                            selectedlist[j] = t
                                        }
                                    }
                                }
                                binding.allProductsRecycler.adapter?.notifyDataSetChanged()

                            } //Sorting of count low to high
                            R.id.htl -> {
                                for (i in 0 until selectedlist.size) {
                                    for (j in i until selectedlist.size) {
                                        if (selectedlist[i].text10.toInt() < selectedlist[j].text10.toInt()) {
                                            val t = selectedlist[i]
                                            selectedlist[i] = selectedlist[j]
                                            selectedlist[j] = t
                                        }
                                    }
                                }
                                binding.allProductsRecycler.adapter?.notifyDataSetChanged()

                            }   //Sorting of count high to low
                        }
                    }
                }   //Taking id of the first checked Checkbox

                dal.dismiss()       //Dialog dismissed
            } //Sorting Go button clicked
        }
        val d = BottomSheetDialog(this)
        d.setContentView(R.layout.allproducts_filter_dialog)
        val a = mutableListOf("Select", "10", "7", "4-5", "1 week", "10+ days")
        binding.filterAllproducts.setOnClickListener {
            d.show()
            val spinner = d.findViewById<Spinner>(R.id.allproducts_spinner)
            val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, a)
            aa.setDropDownViewResource(android.R.layout.simple_spinner_item)
            spinner?.adapter = aa
            val rg = d.findViewById<RadioGroup>(R.id.rg_filter)
            spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    newlist = mutableListOf()
                    for (i in selectedlist) {
                        val s = i.text11.replace(" days", "")
                        if (s == a[position]) {
                            newlist.add(i)
                        }
                    }

                }

            }
            d.findViewById<TextView>(R.id.go_filter)?.setOnClickListener {
                val id = rg?.checkedRadioButtonId
                val newlist2 = mutableListOf<AllproductsData>()
                when (id) {
                    R.id.weft -> {
                        for (i in newlist) {
                            if (i.text2.trim().toLowerCase().contains("weft")) {
                                newlist2.add(i)
                            }
                        }
                    }
                    R.id.warp -> {
                        for (i in newlist) {
                            if (i.text2.trim().toLowerCase().contains("warp")) {
                                newlist2.add(i)
                            }
                        }
                    }

                }
                if (newlist2.isNotEmpty()) {
                    binding.allProductsRecycler.adapter =
                        AllProductAdapter(this, newlist2)
                } else {
                    binding.allProductsRecycler.adapter = AllProductAdapter(this, selectedlist)
                    Toast.makeText(this, "NO RESULTS", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}



