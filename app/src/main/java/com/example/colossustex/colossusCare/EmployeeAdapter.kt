package com.example.colossustex.colossusCare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R

class EmployeeAdapter(val list: MutableList<String>) :
    RecyclerView.Adapter<EmployeeAdapter.mViewHoder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHoder {
        return mViewHoder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.text_adapter_resume,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: mViewHoder, pos: Int) {
        holder.text.text = list[pos];
        holder.close.setOnClickListener {
            list.removeAt(pos)
            notifyDataSetChanged()
        }
    }

    class mViewHoder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.text)
        val close: ImageView = itemView.findViewById(R.id.imageViewClose)

    }

}