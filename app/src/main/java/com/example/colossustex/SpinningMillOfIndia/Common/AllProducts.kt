package com.example.colossustex.SpinningMillOfIndia.Common

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.TextView
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

class AllProducts : AppCompatActivity() {
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var binding: FragmentAllProductsBinding
    lateinit var list: MutableList<AllproductsData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_all_products)
        binding.toolbar.inflateMenu(R.menu.viscose_menu)
        binding.progressbarAllproducts.visibility = View.VISIBLE
        binding.allProductsRecycler.layoutManager = LinearLayoutManager(this)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
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
        firebaseDatabase = FirebaseDatabase.getInstance()
        val ref = firebaseDatabase.getReference("AllProducts")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
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
    }
}


