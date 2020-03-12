package com.example.colossustex.SpinningMillOfIndia.Common

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.MainActivity
import com.example.colossustex.R
import com.example.colossustex.databinding.FragmentAllProductsBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class AllProducts : AppCompatActivity() {
    lateinit var newlist: MutableList<AllproductsData>
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var binding: FragmentAllProductsBinding
    lateinit var list: MutableList<AllproductsData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Hello", "First")
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_all_products)
        binding.toolbar.inflateMenu(R.menu.viscose_menu)
        binding.progressbarAllproducts.visibility = View.VISIBLE
        binding.allProductsRecycler.layoutManager = LinearLayoutManager(this)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        firebaseDatabase = FirebaseDatabase.getInstance()
        val ref = firebaseDatabase.getReference("AllProducts")
        Log.i("Hello", "Oncreatebeforelist")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                Log.i("Hello", "Listupdated")
                if (p0.exists()) {
                    list = mutableListOf()
                    for (datasnap in p0.children) {
                        val data = datasnap.getValue(AllproductsData::class.java)
                        list.add(data!!)
                    }
                    binding.progressbarAllproducts.visibility = View.GONE
                    binding.allProductsRecycler.adapter = AllProductAdapter(this@AllProducts, list)
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
                                for (i in 0 until list.size) {
                                    for (j in i until list.size) {
                                        val s1 = list[i].text6.replace(".00/kg", "")
                                        val s2 = list[j].text6.replace(".00/kg", "")
                                        if (s1.toInt() > s2.toInt()) {
                                            val t = list[i]
                                            list[i] = list[j]
                                            list[j] = t
                                        }
                                    }
                                }
                                binding.allProductsRecycler.adapter?.notifyDataSetChanged()


                            } //Sorting of Price low to high Algorithm implemented here
                            R.id.htl -> {
                                for (i in 0 until list.size) {
                                    for (j in i until list.size) {
                                        val s1 = list[i].text6.replace(".00/kg", "")
                                        val s2 = list[j].text6.replace(".00/kg", "")
                                        if (s1.toInt() < s2.toInt()) {
                                            val t = list[i]
                                            list[i] = list[j]
                                            list[j] = t
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
                                for (i in 0 until list.size) {
                                    for (j in i until list.size) {
                                        if (list[i].text10.toInt() > list[j].text10.toInt()) {
                                            val t = list[i]
                                            list[i] = list[j]
                                            list[j] = t
                                        }
                                    }
                                }
                                binding.allProductsRecycler.adapter?.notifyDataSetChanged()

                            } //Sorting of count low to high
                            R.id.htl -> {
                                for (i in 0 until list.size) {
                                    for (j in i until list.size) {
                                        if (list[i].text10.toInt() < list[j].text10.toInt()) {
                                            val t = list[i]
                                            list[i] = list[j]
                                            list[j] = t
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
                    for (i in list) {
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
                    binding.allProductsRecycler.adapter = AllProductAdapter(this, list)
                    Toast.makeText(this, "NO RESULTS", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
//        if (intent.getStringExtra("First") != null && intent.getStringExtra("Second") != null && intent.getStringExtra(
//                "Third"
//            ) != null
//        ) {
//            Log.i("Hello", "Now")
//            val f = intent.getStringExtra("First")
//            val s = intent.getStringExtra("Second")
//            val t = intent.getStringExtra("Third")
//            val newlist = mutableListOf<AllproductsData>()
//            for (i in list) {
//                if (i.text2.toLowerCase().trim().contains(f) && i.text2.toLowerCase().trim().contains(
//                        s
//                    )
//                ) {
//                    newlist.add(i)
//                }
//            }
//            binding.allProductsRecycler.adapter = AllProductAdapter(this, newlist)
//
//        }
//    }

    }
}


