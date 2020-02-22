package com.example.colossustex.SpinningMillOfIndia.Viscose

import android.app.Dialog
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R
import com.example.colossustex.databinding.ViscoseFragment1Binding
import com.example.dialogcustom.SpinnerDialogAdapter

lateinit var dialog: Dialog

class ViscoseFragment : Fragment() {
    lateinit var list: MutableList<Int>
    lateinit var binding: ViscoseFragment1Binding
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        list = mutableListOf()
        for (i in 1..200) {
            list.add(i)
        }
        binding = DataBindingUtil.inflate(inflater, R.layout.viscose_fragment1, container, false)
        dialog = Dialog(context!!)
        dialog.setContentView(R.layout.viscose_dialog)
        val recycler = dialog.findViewById<RecyclerView>(R.id.viscose_recycler)
        recycler.layoutManager = GridLayoutManager(context, 4)
        recycler.adapter = SpinnerDialogAdapter(list)
        dialog.create()
        binding.spinnerViscose.setOnClickListener {
            showdialog()
        } //Call for dialog function

        binding.vortexId.setOnClickListener {
            binding.ringspunId.setBackgroundResource(R.drawable.viscose_text_middle)
            binding.ringspunId.setTextColor(Color.BLACK)
            binding.openendId.setBackgroundResource(R.drawable.viscose_text_left)
            binding.openendId.setTextColor(Color.BLACK)
            Toast.makeText(context, binding.vortexId.text, Toast.LENGTH_SHORT).show()
            binding.vortexId.setBackgroundResource(R.drawable.viscose_clicked_right)
            binding.vortexId.setTextColor(Color.WHITE)

        }
        binding.ringspunId.setOnClickListener {
            binding.openendId.setBackgroundResource(R.drawable.viscose_text_left)
            binding.openendId.setTextColor(Color.BLACK)
            binding.vortexId.setBackgroundResource(R.drawable.viscose_text_right)
            binding.vortexId.setTextColor(Color.BLACK)
            binding.ringspunId.setBackgroundResource(R.drawable.viscose_clicked_middle)
            binding.ringspunId.setTextColor(Color.WHITE)
            Toast.makeText(context, binding.ringspunId.text, Toast.LENGTH_SHORT).show()

        }
        binding.openendId.setOnClickListener {
            binding.ringspunId.setBackgroundResource(R.drawable.viscose_text_middle)
            binding.ringspunId.setTextColor(Color.BLACK)
            binding.vortexId.setBackgroundResource(R.drawable.viscose_text_right)
            binding.vortexId.setTextColor(Color.BLACK)
            binding.openendId.setBackgroundResource(R.drawable.viscose_clicked_left)
            binding.openendId.setTextColor(Color.WHITE)
            Toast.makeText(context, binding.openendId.text, Toast.LENGTH_SHORT).show()
        }
        binding.warpId.setOnClickListener {
            binding.weftId.setBackgroundResource(R.drawable.viscose_text_right)
            binding.weftId.setTextColor(Color.BLACK)
            binding.warpId.setBackgroundResource(R.drawable.viscose_clicked_left)
            binding.warpId.setTextColor(Color.WHITE)
            Toast.makeText(context, binding.warpId.text, Toast.LENGTH_SHORT).show()
        }
        binding.weftId.setOnClickListener {
            binding.warpId.setBackgroundResource(R.drawable.viscose_text_left)
            binding.warpId.setTextColor(Color.BLACK)
            binding.weftId.setBackgroundResource(R.drawable.viscose_clicked_right)
            binding.weftId.setTextColor(Color.WHITE)
            Toast.makeText(context, binding.weftId.text, Toast.LENGTH_SHORT).show()

        }
        binding.regularId.setOnClickListener {
            binding.dyedId.setBackgroundResource(R.drawable.viscose_text_middle)
            binding.dyedId.setTextColor(Color.BLACK)
            binding.spandexId.setBackgroundResource(R.drawable.viscose_text_right)
            binding.spandexId.setTextColor(Color.BLACK)
            binding.regularId.setBackgroundResource(R.drawable.viscose_clicked_left)
            binding.regularId.setTextColor(Color.WHITE)
            Toast.makeText(context, binding.regularId.text, Toast.LENGTH_SHORT).show()
        }
        binding.dyedId.setOnClickListener {
            binding.regularId.setBackgroundResource(R.drawable.viscose_text_left)
            binding.regularId.setTextColor(Color.BLACK)
            binding.spandexId.setBackgroundResource(R.drawable.viscose_text_middle)
            binding.spandexId.setTextColor(Color.BLACK)
            binding.dyedId.setBackgroundResource(R.drawable.viscose_clicked_middle)
            binding.dyedId.setTextColor(Color.WHITE)
            Toast.makeText(context, binding.dyedId.text, Toast.LENGTH_SHORT).show()
        }
        binding.spandexId.setOnClickListener {
            binding.dyedId.setBackgroundResource(R.drawable.viscose_text_middle)
            binding.dyedId.setTextColor(Color.BLACK)
            binding.regularId.setBackgroundResource(R.drawable.viscose_text_left)
            binding.regularId.setTextColor(Color.BLACK)
            binding.spandexId.setBackgroundResource(R.drawable.viscose_clicked_right)
            binding.spandexId.setTextColor(Color.WHITE)
            Toast.makeText(context, binding.spandexId.text, Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun showdialog() {

        dialog.show()

    }   //Function to show dialog 1

}
