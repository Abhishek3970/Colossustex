package com.example.colossustex.colossusCare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R

class AllresumesAdapter(val list: MutableList<AllresumesData>) :
    RecyclerView.Adapter<AllresumesAdapter.MyViewHolder>() {
    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val category = itemview.findViewById<TextView>(R.id.category_txt)
        val name = itemview.findViewById<TextView>(R.id.name)
        val location = itemview.findViewById<TextView>(R.id.location)
        val view=itemView.findViewById<TextView>(R.id.view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.all_resumes_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.category.text=list[position].category
        holder.name.text=list[position].name
        holder.location.text=list[position].location
        holder.view.setOnClickListener {
            holder.itemView.findNavController().navigate(R.id.action_allresumeFrag_to_resumeDetails)
        }
    }
}