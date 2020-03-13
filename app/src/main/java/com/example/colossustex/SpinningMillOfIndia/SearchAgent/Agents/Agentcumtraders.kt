package com.example.colossustex.SpinningMillOfIndia.SearchAgent.Agents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.colossustex.R


class Agentcumtraders(
    val type: String,
    val stateFrom: String,
    val stateTo: String
) : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agentcumtraders, container, false)
    }


}
