package com.example.colossustex.SpinningMillOfIndia.Fancy

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.colossustex.MainActivity
import com.example.colossustex.R

class FancyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fancy)
        val sectionsPagerAdapter =
            SectionsPagerAdapter(
                this,
                supportFragmentManager
            )
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val toolbar=findViewById<Toolbar>(R.id.fancy_toolbar)
        toolbar.inflateMenu(R.menu.viscose_menu)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        tabs.setSelectedTabIndicatorColor(Color.WHITE)
        toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
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