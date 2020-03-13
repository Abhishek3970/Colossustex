package com.example.colossustex.SpinningMillOfIndia.SearchAgent.Agents

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R
import com.google.firebase.database.*


class Agentstab(
    val type: String,
    val stateFrom: String,
    val stateTo: String
) : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mDb: DatabaseReference
    private lateinit var agents: ArrayList<AgentData>
    private lateinit var adapter: Agentadapter
    private lateinit var manager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val lay = inflater.inflate(R.layout.fragment_agentstab, container, false)

        mDb = FirebaseDatabase.getInstance().reference.child("agents")
        agents = ArrayList()
        mDb.addValueEventListener(
            object : ValueEventListener {

                override fun onCancelled(p0: DatabaseError) {}

                override fun onDataChange(data: DataSnapshot) {
                    agents.clear()
                    for (dataSnapshot in data.children) {
                        val p = dataSnapshot.getValue(AgentData::class.java)
                        val typeList = p!!.type!!.split(",")
                        val stateFromList = p.stateFrom!!.split(",")
                        val stateToList = p.stateTo!!.split(",")
                        if(type in typeList && stateFrom in stateFromList && stateTo in stateToList)
                                agents.add(p)
                    }
                    adapter.notifyDataSetChanged()
                }
            }       //for first time loading.
        )

        recyclerView = lay.findViewById(R.id.recyclerView_agenttab)

        manager = LinearLayoutManager(context)
        recyclerView.layoutManager = manager
        adapter = Agentadapter(context!!, agents)
        recyclerView.adapter = adapter

        return lay
    }

    val valueEventListener = object : ValueEventListener {
        override fun onCancelled(p0: DatabaseError) {}

        override fun onDataChange(data: DataSnapshot) {
            agents.clear()
            for (dataSnapshot in data.children) {
                val p = dataSnapshot.getValue(AgentData::class.java)
                agents.add(p!!)
            }
            adapter.notifyDataSetChanged()
        }

    }   //to notify changes to adapter

}
