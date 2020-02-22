package com.example.colossustex.SpinningMillOfIndia.Texturised

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.colossustex.R
import com.google.android.material.tabs.TabLayout

class TexturisedActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_texturised)
        val sectionsPagerAdapter =
            SectionsPagerAdapter(
                this,
                supportFragmentManager
            )
        val viewPager: ViewPager = findViewById(R.id.view_pager2)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs2)
        tabs.setupWithViewPager(viewPager)
        tabs.setSelectedTabIndicatorColor(Color.WHITE)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_texturised)
        toolbar.inflateMenu(R.menu.viscose_menu)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }
}