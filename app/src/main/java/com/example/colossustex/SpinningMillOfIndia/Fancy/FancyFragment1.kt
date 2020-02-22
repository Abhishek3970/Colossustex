package com.example.colossustex.SpinningMillOfIndia.Fancy


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.colossustex.R
import com.example.colossustex.databinding.FragmentFancy1Binding

class FancyFragment1: Fragment() {
    lateinit var binding: FragmentFancy1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fancy1, container, false)
        return binding.root

    }
}
