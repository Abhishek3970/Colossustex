package com.example.colossustex.SpinningMillOfIndia.Viscose

import android.annotation.TargetApi
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.colossustex.MainActivity
import com.example.colossustex.R
import com.example.colossustex.SpinningMillOfIndia.Common.CompanyAdd
import com.google.android.material.tabs.TabLayout

class ViscoseActivity : AppCompatActivity() {
    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viscose_activity)
        val tabs: TabLayout = findViewById(R.id.tabs)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        val sectionsPagerAdapter =
            SectionsPagerAdapter(
                this,
                supportFragmentManager,"Viscose"
            )
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter

        tabs.setSelectedTabIndicatorColor(Color.WHITE)
        tabs.setTabTextColors(getColor(R.color.tabunselected), Color.WHITE)
        tabs.setupWithViewPager(viewPager)
        //val fab: FloatingActionButton = findViewById(R.id.fab)
        toolbar.inflateMenu(R.menu.viscose_menu)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.home_id -> {
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                    overridePendingTransition(
                        R.anim.slide_in_left,R.anim.slide_out_right
                    )
                }

            }
            true
        }

    }
}