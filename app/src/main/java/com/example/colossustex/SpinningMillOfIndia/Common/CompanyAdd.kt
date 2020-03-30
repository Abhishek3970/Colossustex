package com.example.colossustex.SpinningMillOfIndia.Common

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.colossustex.R
import com.example.colossustex.databinding.ActivityCompanyAddBinding
import com.example.colossustex.homePage.list_all_mill
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CompanyAdd : AppCompatActivity() {
    lateinit var binding: ActivityCompanyAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_company_add)
        val ref = FirebaseDatabase.getInstance().getReference("AllProducts")
        val refmills = FirebaseDatabase.getInstance().getReference("AllMills")
        binding.toolbarDetails.setNavigationOnClickListener {
            onBackPressed()
        }
        binding.addNow.setOnClickListener {
            val data = AllproductsData(
                "",
                binding.count.text.toString(),
                binding.companyName.text.toString(),
                binding.locationTop.text.toString(),
                binding.priceTop.text.toString(),
                binding.updated.text.toString(),
                binding.yarnType.text.toString(),
                binding.purpose.text.toString(),
                binding.variety.text.toString(),
                binding.nature.text.toString(),
                binding.count.text.toString(),
                binding.type.text.toString(),
                binding.quality.text.toString(),
                binding.actualCount.text.toString(),
                binding.csp.text.toString(),
                binding.totalImperfections.text.toString(),
                binding.weight.text.toString(),
                binding.cones.text.toString(),
                binding.deliveryPeriod.text.toString(),
                binding.minQuantity.text.toString()
            )
            val key = ref.push().key
            ref.child(key!!).setValue(data)
            refmills.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(p0: DataSnapshot) {
                    list_all_mill = mutableListOf()
                    for (snapshot in p0.children) {
                        val store = snapshot.getValue(AllMillsData::class.java)
                        list_all_mill.add(store!!)
                    }
                }
            })
            var j = 0
            for (i in list_all_mill) {
                if (i.type.toLowerCase() == binding.yarnType.text.toString()
                        .toLowerCase() && i.text1.toLowerCase() == binding.companyName.text.toString()
                        .toLowerCase()
                ) {
                    Log.i("all", "inside")
                    i.count = (i.count.toInt() + 1).toString()
                    i.text4 = i.text4 + "," + binding.count.text.toString()
                    refmills.child(i.id).setValue(i)
                    j = 1
                    break
                }
            }
            Log.i("all", j.toString())
            if (j == 0) {
                val id = refmills.push().key
                val newmilldata = AllMillsData(
                    id!!,
                    binding.companyName.text.toString(),
                    binding.locationTop.text.toString(),
                    "1",
                    binding.yarnType.text.toString(),
                    0,
                    binding.count.text.toString(),
                    binding.updated.text.toString(),
                    binding.variety.text.toString(),
                    binding.purpose.text.toString()
                )
                Toast.makeText(this, "New Added", Toast.LENGTH_SHORT).show()
                refmills.child(id).setValue(newmilldata)
            } else {
                Toast.makeText(this, "Added in earlier", Toast.LENGTH_SHORT).show()
            }
            binding.count.setText("")
            binding.priceTop.setText("")
            binding.updated.setText("")
            binding.yarnType.setText("")
            binding.purpose.setText("")
            binding.variety.setText("")
            binding.nature.setText("")
            binding.count.setText("")
            binding.type.setText("")
            binding.quality.setText("")
            binding.actualCount.setText("")
            binding.csp.setText("")
            binding.totalImperfections.setText("")
            binding.deliveryPeriod.setText("")
            binding.cones.setText("")
            binding.deliveryPeriod.setText("")
            binding.minQuantity.setText("")
        }
    }
}

