package com.example.colossustex.SpinningMillOfIndia.Common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R
import com.example.colossustex.SpinningMillOfIndia.Viscose.ViewedHistoryData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

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
        firebaseDatabase = FirebaseDatabase.getInstance()
        mref = firebaseDatabase.getReference("ViscoseHistory").child("ViewedHistory")
        val view = LayoutInflater.from(context).inflate(R.layout.allproducts_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val key = mref.push().key
            val data = ViewedHistoryData(
                list[position].text1,
                list[position].text2,
                list[position].textround
            )
            mref.child(key!!).setValue(data)
        }
        holder.text1.text = list[position].text1
        holder.text2.text = list[position].text2
        holder.text3.text = list[position].text3
        holder.text4.text = list[position].text4
        holder.text5.text = list[position].text5
        holder.text6.text = list[position].text6
        holder.text7.text = list[position].text7
        holder.text8.text = list[position].text8
        holder.text9.text = list[position].text9
        holder.text10.text = list[position].text10
        holder.text11.text = list[position].text11
        holder.textround.text = list[position].textround


    }
}