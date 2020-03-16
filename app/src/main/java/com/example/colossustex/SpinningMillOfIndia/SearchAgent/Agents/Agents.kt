package com.example.colossustex.SpinningMillOfIndia.SearchAgent.Agents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.colossustex.R
import com.example.colossustex.databinding.AgentsFragmentBinding


class Agents : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: AgentsFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.agents_fragment, container, false)
        val arg = arguments?.let { AgentsArgs.fromBundle(it) }

        binding.yarnType.text = arg!!.type
        binding.stateFrom.text = arg.stateFrom
        binding.stateTo.text = arg.stateTo

        binding.toolbarAgents.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }

        binding.toolbarAgents.inflateMenu(R.menu.menu_spinning_mills_of_india)
        binding.toolbarAgents.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.home_page -> {
                    binding.toolbarAgents.findNavController()
                        .navigate(AgentsDirections.actionAgentsToHomePage())
                }
            }
            true
        }


        val pagerAdapter =
            PagerAdapter(
                context!!,
                childFragmentManager,
                arg.type,
                arg.stateFrom,
                arg.stateTo
            )

        binding.viewPager.adapter = pagerAdapter
        binding.tabView.setupWithViewPager(binding.viewPager)
//        binding.tabView.setTabTextColors(getColor(context!!,R.color.tabunselected), Color.BLACK)


        return binding.root
    }

}
