package com.example.colossustex.SpinningMillOfIndia.Fancy


import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R
import com.example.colossustex.databinding.FragmentFancy1Binding
import com.example.dialogcustom.SpinnerDialogAdapter

class FancyFragment1: Fragment() {
    lateinit var binding: FragmentFancy1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fancy1, container, false)
        val list= mutableListOf(binding.cotton,binding.pc,binding.pv,binding.psf,binding.vsf,binding.texturised)
        val list2= mutableListOf(binding.slub,binding.modal,binding.excel,binding.tencel,binding.multicolor)
        val data= mutableListOf<Int>()
        for (i in 1..200){
            data.add(i)
        }
        val dialog = Dialog(context!!)
        val dialog2= Dialog(context!!)
        dialog2.setContentView(R.layout.viscose_dialog2)
        dialog.setContentView(R.layout.viscose_dialog)
        val recycler = dialog.findViewById<RecyclerView>(R.id.viscose_recycler)
        recycler.layoutManager = GridLayoutManager(context, 4)
        recycler.adapter = SpinnerDialogAdapter(data,context!!,dialog2,dialog,binding.spinnerViscose)
        for (i in list){
            i.setOnClickListener {
                i.isSelected = true
                i.setTextColor(Color.WHITE)
                for (j in list) {
                    if (j != i) {
                        j.isSelected = false
                        j.setTextColor(Color.BLACK)
                    }
                }
            }
        }
        binding.spinnerViscose.setOnClickListener {
            dialog.show()
        }

        for (i in list2){
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
        binding.regular.setOnClickListener {
            it.isSelected=true
            binding.regular.setTextColor(Color.WHITE)
            binding.dyed.isSelected=false
            binding.dyed.setTextColor(Color.BLACK)
        }
        binding.dyed.setOnClickListener {
            it.isSelected=true
            binding.regular.isSelected=false
            binding.regular.setTextColor(Color.BLACK)
            binding.dyed.setTextColor(Color.WHITE)
        }

        return binding.root
    }
}
