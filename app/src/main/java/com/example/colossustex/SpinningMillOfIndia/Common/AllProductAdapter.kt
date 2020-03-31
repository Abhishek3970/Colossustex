package com.example.colossustex.SpinningMillOfIndia.Common

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R
import com.example.colossustex.SpinningMillOfIndia.ProductDetails
import com.example.colossustex.SpinningMillOfIndia.Viscose.ViewedHistoryData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson

class AllProductAdapter(val context: Context, val list: MutableList<AllproductsData>) :
    RecyclerView.Adapter<AllProductAdapter.MyViewHolder>() {
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var mref: DatabaseReference

    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val text1 = itemview.findViewById<TextView>(R.id.text1)
        val text2 = itemview.findViewById<TextView>(R.id.text2)
        val text3 = itemview.findViewById<TextView>(R.id.text3)
        val text4 = itemview.findViewById<TextView>(R.id.text4)
        val text5 = itemview.findViewById<TextView>(R.id.text5)
        val textround = itemview.findViewById<TextView>(R.id.textround)
        val text6 = itemview.findViewById<TextView>(R.id.text6)
        val text7 = itemview.findViewById<TextView>(R.id.text7)
        val text8 = itemview.findViewById<TextView>(R.id.text8)
        val text9 = itemview.findViewById<TextView>(R.id.text9)
        val text11 = itemview.findViewById<TextView>(R.id.text11)
        val text10 = itemview.findViewById<TextView>(R.id.text10)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val user=FirebaseAuth.getInstance().currentUser
        firebaseDatabase = FirebaseDatabase.getInstance()
        mref = firebaseDatabase.getReference("User").child(user?.uid.toString()).child("Viewed History")
        val view = LayoutInflater.from(context).inflate(R.layout.allproducts_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val key = mref.push().key
            val data = ViewedHistoryData(
                list[position].company_name,
                list[position].nature+","+list[position].type,
                list[position].textround
            )
            mref.child(key!!).setValue(data)
        }
        holder.text1.text = list[position].company_name
        holder.text2.text = list[position].nature+","+list[position].type
        holder.text3.text = "CSP:"+list[position].csp
        holder.text4.text = "Actual Count:"+list[position].actual_count
        holder.text5.text = "Ex-Mill "
        holder.text6.text = list[position].price+".00/kg"
        holder.text7.text = "Updated:"+list[position].updated
        holder.text8.text = "Immediate Payment Price"
        holder.text9.text = list[position].weight
        holder.text10.text = list[position].cones
        holder.text11.text = list[position].delivery_period
        holder.textround.text = list[position].textround
        holder.itemView.setOnClickListener {
            val gson=Gson()
            val details=gson.toJson(list[position])
           context.startActivity(Intent(context,ProductDetails::class.java).putExtra("details",details))
        }


    }
}