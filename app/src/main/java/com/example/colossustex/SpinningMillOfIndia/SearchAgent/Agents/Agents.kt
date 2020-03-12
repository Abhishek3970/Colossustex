package com.example.colossustex.SpinningMillOfIndia.SearchAgent.Agents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.colossustex.R

class Agents : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val lay = inflater.inflate(R.layout.agents_fragment, container, false)
        val arg = arguments?.let { AgentsArgs.fromBundle(it) }
        Toast.makeText(
            context!!,
            "type=${arg!!.type} StateFrom=${arg!!.stateFrom} StateTo=${arg!!.stateTo}",
            Toast.LENGTH_LONG
        ).show()
        return lay
    }

}
