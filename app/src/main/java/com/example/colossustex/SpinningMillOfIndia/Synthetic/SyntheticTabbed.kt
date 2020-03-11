package com.example.colossustex.SpinningMillOfIndia.Synthetic

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.example.colossustex.MainActivity
import com.example.colossustex.R

class SyntheticTabbed : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_synthetic_tabbed)
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