package com.example.colossustex.SpinningMillOfIndia.SearchAgent.Agents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R

class Agentadapter() : RecyclerView.Adapter<Agentadapter.MyViewHolder>() {

    private lateinit var context: Context
    private lateinit var agents: ArrayList<AgentData>

    constructor(c: Context, p: ArrayList<AgentData>) : this() {
        this.context = c
        this.agents = p
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_agent_tab,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return agents.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, pos: Int) {
        holder.name.text = agents[pos].name
        holder.location.text = agents[pos].location
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.textView_name_agents)
        val location = itemView.findViewById<TextView>(R.id.textView_location_agents)

    }
}