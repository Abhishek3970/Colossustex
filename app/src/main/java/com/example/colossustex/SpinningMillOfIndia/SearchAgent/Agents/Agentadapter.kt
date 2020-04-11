package com.example.colossustex.SpinningMillOfIndia.SearchAgent.Agents

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
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
        holder.nameDetails.text = agents[pos].name
        holder.locationDetails.text = agents[pos].location
        holder.company.text = "Company: ${agents[pos].company}"
        holder.agentFor.text = agents[pos].agentFor
        holder.businessSince.text = agents[pos].inBusinessSince
        holder.descriptionAgent.text = agents[pos].description


        val statesTo = agents[pos].stateTo!!.split(",")
        val statesFrom = agents[pos].stateFrom!!.split(",")
        val products = agents[pos].type!!.split(",")

        holder.supplyTo.text = "${statesTo.size} States      "
        holder.supplyFrom.text = "${statesFrom.size} States      "
        holder.types.text = "${products.size} Types of Yarn"

        val arrStatesTo = statesTo.toTypedArray()
        val arrStatesFrom = statesFrom.toTypedArray()
        val arrProducts = products.toTypedArray()

        holder.supplyTo.setOnClickListener {
            val builder = AlertDialog.Builder(context!!)
            builder.setItems(arrStatesTo) { dialog, which ->
            }
            val dialog = builder.create()
            dialog.show()
        }
        holder.supplyFrom.setOnClickListener {
            val builder = AlertDialog.Builder(context!!)
            builder.setItems(arrStatesFrom) { dialog, which ->
            }
            val dialog = builder.create()
            dialog.show()
        }
        holder.types.setOnClickListener {
            val builder = AlertDialog.Builder(context!!)
            builder.setItems(arrProducts) { dialog, which ->
            }
            val dialog = builder.create()
            dialog.show()
        }

        holder.basicDetails.setOnClickListener {
            holder.basicDetails.visibility = View.GONE
            holder.allDetails.visibility = View.VISIBLE
        }


    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.textView_name_agents)
        val location = itemView.findViewById<TextView>(R.id.textView_location_agents)
        val nameDetails: TextView = itemView.findViewById(R.id.name_agent)
        val locationDetails: TextView = itemView.findViewById(R.id.location_agent)
        val company: TextView = itemView.findViewById(R.id.company_name_agents)
        val supplyTo: TextView = itemView.findViewById(R.id.no_supply_to)
        val supplyFrom: TextView = itemView.findViewById(R.id.no_supply_from)
        val types: TextView = itemView.findViewById(R.id.types_of_yarn_agents)
        val agentFor: TextView = itemView.findViewById(R.id.agent_for_agents)
        val businessSince: TextView = itemView.findViewById(R.id.in_buisness_since)
        val descriptionAgent: TextView = itemView.findViewById(R.id.description_agents)

        val basicDetails: ConstraintLayout = itemView.findViewById(R.id.constratint_layout_agents)
        val allDetails: ConstraintLayout =
            itemView.findViewById(R.id.constraintLayout_details_agents)

        val arrow = itemView.findViewById<ImageView>(R.id.arrow_agents)

    }
}