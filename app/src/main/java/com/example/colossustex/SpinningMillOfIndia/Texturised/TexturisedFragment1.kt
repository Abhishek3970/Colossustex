package com.example.colossustex.SpinningMillOfIndia.Texturised


import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.colossustex.R
import com.example.colossustex.databinding.TexturisedFragment1Binding

class TexturisedFragment1 : Fragment() {
    lateinit var binding: TexturisedFragment1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.texturised_fragment1, container, false)
        val list = mutableListOf(
            binding.brightText,
            binding.fulldull,
            binding.catonicText,
            binding.FDYText,
            binding.semidullText,
            binding.airtex,
            binding.blackdope,
            binding.stretch
        )
        val list2= mutableListOf(binding.NIM,binding.GFT,binding.LIM,binding.IM,binding.HIM)
        val list3= mutableListOf(binding.firstText,binding.PQ,binding.CLQ,binding.STD)
        for (i in list) {
            i.setOnClickListener {
                i.isSelected = true
                i.setTextColor(Color.WHITE)
                for (j in list) {
                    if (j != i) {
                        j.setTextColor(Color.BLACK)
                        j.isSelected = false
                    }
                }
            }
        }
        for (i in list2) {
            i.setOnClickListener {
                i.isSelected = true
                i.setTextColor(Color.WHITE)
                for (j in list2) {
                    if (j != i) {
                        j.isSelected = false
                        j.setTextColor(Color.BLACK)
                    }
                }
            }
        }
        for (i in list3) {
            i.setOnClickListener {
                i.isSelected = true
                i.setTextColor(Color.WHITE)
                for (j in list3) {
                    if (j != i) {
                        j.setTextColor(Color.BLACK)
                        j.isSelected = false
                    }
                }
            }
        }
        binding.regularText.setOnClickListener {
            binding.regularText.isSelected=true
            binding.regularText.setTextColor(Color.WHITE)
            binding.dyedText.isSelected=false
            binding.dyedText.setTextColor(Color.BLACK)
        }
        binding.dyedText.setOnClickListener {
            binding.dyedText.isSelected=true
            binding.dyedText.setTextColor(Color.WHITE)
            binding.regularText.isSelected=false
            binding.regularText.setTextColor(Color.BLACK)
        }
        return binding.root

    }


}
