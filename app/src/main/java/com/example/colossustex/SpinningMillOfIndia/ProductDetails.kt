package com.example.colossustex.SpinningMillOfIndia

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
import com.example.colossustex.MainActivity
import com.example.colossustex.R
import com.example.colossustex.SpinningMillOfIndia.Common.AllProducts
import com.example.colossustex.SpinningMillOfIndia.Common.AllproductsData
import com.example.colossustex.databinding.ProductDetailsBinding
import com.google.gson.Gson

class ProductDetails : AppCompatActivity() {
    lateinit var binding: ProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.product_details)
//        binding.allProducts.setOnClickListener {
//            startActivity(
//                Intent(this, AllProducts::class.java).putExtra(
//                    "Head",
//                    binding.companyName.text.toString()
//                ).putExtra("Location", binding.locationTop.text.toString()).putExtra("Type","")
//            )
//        }
        val gson=Gson()
        val data=gson.fromJson(intent.getStringExtra("details"),AllproductsData::class.java)
        binding.companyName.text=data.company_name
        binding.locationTop.text=data.location
        binding.actualCount.text=data.actual_count
        binding.cones.text=data.cones
        binding.csp.text=data.csp
        binding.deliveryPeriod.text=data.delivery_period
        binding.count.text=data.count
        binding.nature.text=data.nature
        binding.quality.text=data.quality
        binding.purpose.text=data.purpose
        binding.yarnType.text=data.yarn_type
        binding.updated.text=data.updated
        binding.textRoundDetails.text=data.textround
        binding.weight.text=data.weight+" kgs"
        binding.type.text=data.type
        binding.priceTop.text=data.price+".00/kg"
        binding.minQuantity.text=data.min_quantity
        binding.priceDown.text=data.price+".00/kg"
        binding.totalImperfections.text=data.total_imperfections
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
