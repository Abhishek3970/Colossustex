package com.example.colossustex.SpinningMillOfIndia

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.colossustex.R

class SearchAgent : Fragment() {

    private lateinit var dialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var lay = inflater.inflate(R.layout.fragment_search_agent, container, false)
        val toolbar = lay.findViewById<Toolbar>(R.id.toolbar_spinning_mills_in_india_search_agent)
        toolbar.setNavigationOnClickListener {
            it.findNavController()
                .navigate(SearchAgentDirections.actionSearchAgentToSpinningMillOfIndia())
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
        dialog = Dialog(context!!)

        val catagories = lay.findViewById<TextView>(R.id.textView_yarn_catagory)
        val yarnType = lay.findViewById<TextView>(R.id.textView_yarn_type)
        val stateTo = lay.findViewById<TextView>(R.id.textView_state_to)
        val stateFrom = lay.findViewById<TextView>(R.id.textView_state_from)

        catagories.setOnClickListener {
            dialog.setContentView(R.layout.fragment_search_agent_yarn_catagory_dialog)
            var cotton = dialog.findViewById<TextView>(R.id.catagory_cotton)
            var polyester = dialog.findViewById<TextView>(R.id.catagory_polyester)
            var viscose = dialog.findViewById<TextView>(R.id.catagory_viscose)
            var texturized = dialog.findViewById<TextView>(R.id.catagory_texturized)
            var blended = dialog.findViewById<TextView>(R.id.catagory_blended)
            var specialized = dialog.findViewById<TextView>(R.id.catagory_specialized)
            val list = mutableListOf<TextView>(
                cotton,
                polyester,
                viscose,
                texturized,
                blended,
                specialized
            )
            for(item in list){
                item.setOnClickListener {
                    catagories.text = item.text
                    dialog.dismiss()
                }
            }

            dialog.show()
        }


        return lay
    }

}
