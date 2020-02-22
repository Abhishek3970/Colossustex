package com.example.colossustex.SpinningMillOfIndia.Viscose

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R
import com.google.firebase.database.FirebaseDatabase

class RecyclerAdapter2(val list: MutableList<AllMillsData>) :
    RecyclerView.Adapter<RecyclerAdapter2.ViscoseHolder>() {
    var database = FirebaseDatabase.getInstance()
    var mdata = database.getReference("Viscose")

    class ViscoseHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val text1 = itemview.findViewById<TextView>(R.id.text1)
        val text2 = itemview.findViewById<TextView>(R.id.text2)
        val text3 = itemview.findViewById<TextView>(R.id.text3)
        val views = itemview.findViewById<TextView>(R.id.views)
        val text4 = itemview.findViewById<TextView>(R.id.text4)
        val text5 = itemview.findViewById<TextView>(R.id.text5)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViscoseHolder {
        return ViscoseHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.viscose_recycler2_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViscoseHolder, position: Int) {
        mdata.child(list[position].id.toString()).child("views").setValue(list[position].views + 1)
        holder.text1.text = list[position].text1
        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                list[position].id.toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
        holder.text2.text = list[position].text2
        holder.text3.text = list[position].text3
        holder.views.text = ("${list[position].views} Views").toString()
        holder.text4.text = list[position].text4
        holder.text5.text = list[position].text5

    }
    /* fun filter( data:MutableList<AllMillsData> ){
         this.list=data
         notifyDataSetChanged()

     }*/
}