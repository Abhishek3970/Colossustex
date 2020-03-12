package com.example.colossustex.SpinningMillOfIndia.Cotton

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.colossustex.MainActivity
import com.example.colossustex.R
import com.example.colossustex.SpinningMillOfIndia.Common.AllMillsData
import com.example.colossustex.SpinningMillOfIndia.Common.MillsListAdapter
import com.example.colossustex.SpinningMillOfIndia.Common.MillsListFragment
import com.example.colossustex.SpinningMillOfIndia.Common.list_all
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.Tab
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CottonTabbed : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cotton_tabbed)
        val sectionsPagerAdapter =
            SectionsPagerAdapter(
                this,
                supportFragmentManager
            )
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        tabs.setSelectedTabIndicatorColor(Color.WHITE)
        tabs.setTabTextColors(getColor(R.color.tabunselected), Color.WHITE)
        tabs.setupWithViewPager(viewPager)
        toolbar.inflateMenu(R.menu.viscose_menu)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        val database = FirebaseDatabase.getInstance()
        val mdata = database.getReference("Viscose")
        mdata.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                list_all = mutableListOf()
                for (snapshot in p0.children) {
                    val store = snapshot.getValue(AllMillsData::class.java)
                    list_all.add(store!!)
                }
            }
        })
        toolbar.setOnMenuItemClickListener {
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