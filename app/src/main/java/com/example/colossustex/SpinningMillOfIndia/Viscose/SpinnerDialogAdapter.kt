package com.example.dialogcustom

import android.app.Dialog
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R

class SpinnerDialogAdapter(val list: MutableList<Int>) :
    RecyclerView.Adapter<SpinnerDialogAdapter.MyViewHolder>() {

    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val text = itemview.findViewById<TextView>(R.id.viscose_recycler_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viscose_dialog_recycler, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.text.text = list[position].toString()
        val dialog2 = Dialog(holder.itemView.context)
        dialog2.setContentView(R.layout.viscose_dialog2)
        dialog2.create()
        holder.itemView.setOnClickListener {
            dialog2.show()
            dialog2.findViewById<TextView>(R.id.single).setOnClickListener {
                Toast.makeText(
                    holder.itemView.context,
                    "${list[position]} Single",
                    Toast.LENGTH_SHORT
                ).show()
                dialog2.dismiss()
            }
            dialog2.findViewById<TextView>(R.id.double_text).setOnClickListener {
                Toast.makeText(
                    holder.itemView.context,
                    "${list[position]} Double",
                    Toast.LENGTH_SHORT
                ).show()
                dialog2.dismiss()
            }
        }   //Show dialog2

    }
}       //Adapter for the recyclerview in dialog