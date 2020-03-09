package com.example.colossustex.SpinningMillOfIndia.Viscose

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R

class ViewedHistoryAdapter(val list:MutableList<ViewedHistoryData>): RecyclerView.Adapter<ViewedHistoryAdapter.MyViewHolder>() {

    class MyViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        val text1=itemview.findViewById<TextView>(R.id.textView17)
        val text2=itemview.findViewById<TextView>(R.id.textView18)
        val text3=itemview.findViewById<TextView>(R.id.textView19)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.search_history_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.text1.text=list[position].first
        holder.text2.text=list[position].second
        holder.text3.text=list[position].third
    }
}