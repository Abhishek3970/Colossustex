package com.example.colossustex.SpinningMillOfIndia.Common

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.colossustex.MainActivity
import com.example.colossustex.R
import com.example.colossustex.databinding.FragmentAllProductsBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.zip.Inflater

class AllProducts : AppCompatActivity() {
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var binding: FragmentAllProductsBinding
    lateinit var list:MutableList<AllproductsData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.fragment_all_products)
        binding.toolbar.inflateMenu(R.menu.viscose_menu)
        binding.progressbarAllproducts.visibility= View.VISIBLE
        binding.allProductsRecycler.layoutManager=LinearLayoutManager(this)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        firebaseDatabase=FirebaseDatabase.getInstance()
        val ref=firebaseDatabase.getReference("AllProducts")
        ref.addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    list= mutableListOf()
                    for(datasnap in p0.children){
                        val data=datasnap.getValue(AllproductsData::class.java)
                        for(i in 1..7)
                            list.add(data!!)
                    }
                    binding.progressbarAllproducts.visibility=View.GONE
                    binding.allProductsRecycler.adapter=AllProductAdapter(this@AllProducts,list)
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

    }
}
