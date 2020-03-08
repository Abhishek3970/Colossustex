package com.example.colossustex.SpinningMillOfIndia

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController

import com.example.colossustex.R

class SearchAgent : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var lay = inflater.inflate(R.layout.fragment_search_agent, container, false)
        val toolbar = lay.findViewById<Toolbar>(R.id.toolbar_spinning_mills_in_india_search_agent)
        toolbar.setNavigationOnClickListener{
            it.findNavController().navigate(SearchAgentDirections.actionSearchAgentToSpinningMillOfIndia())
        }
        toolbar.inflateMenu(R.menu.menu_spinning_mills_of_india)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.home_page -> {
                    toolbar.findNavController()
                        .navigate(SearchAgentDirections.actionSearchAgentToHomePage())
                }
            }
            true
        }

        return lay
    }

}
