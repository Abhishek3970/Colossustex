package com.example.colossustex.SpinningMillOfIndia.SearchAgent.Agents

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.colossustex.R

class Agents : Fragment() {

    companion object {
        fun newInstance() = Agents()
    }

    private lateinit var viewModel: AgentsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.agents_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AgentsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
