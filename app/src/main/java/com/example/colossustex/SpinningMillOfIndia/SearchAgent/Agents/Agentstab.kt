package com.example.colossustex.SpinningMillOfIndia.SearchAgent.Agents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R
import com.example.colossustex.databinding.AgentsFragmentBinding


class Agentstab(
    val type: String,
    val stateFrom: String,
    val stateTo: String
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val lay= inflater.inflate(R.layout.fragment_agentstab, container, false)
        val recyclerView = lay.findViewById<RecyclerView>(R.id.recyclerView_agenttab)

        return lay
    }

}
