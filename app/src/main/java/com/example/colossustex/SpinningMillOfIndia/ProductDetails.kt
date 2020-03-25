package com.example.colossustex.SpinningMillOfIndia

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
import com.example.colossustex.MainActivity
import com.example.colossustex.R
import com.example.colossustex.SpinningMillOfIndia.Common.AllProducts
import com.example.colossustex.databinding.ProductDetailsBinding

class ProductDetails : AppCompatActivity() {
    lateinit var binding: ProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.product_details)
        binding.allProducts.setOnClickListener {
            startActivity(
                Intent(this, AllProducts::class.java).putExtra(
                    "Head",
                    binding.productname.text.toString()
                ).putExtra("Location", binding.locationTop.text.toString()).putExtra("Type","")
            )
        }
        binding.toolbarDetails.inflateMenu(R.menu.menu_spinning_mills_of_india)
        binding.toolbarDetails.setOnMenuItemClickListener {
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
        binding.toolbarDetails.setNavigationOnClickListener {
            onBackPressed()
        }
    }

}
