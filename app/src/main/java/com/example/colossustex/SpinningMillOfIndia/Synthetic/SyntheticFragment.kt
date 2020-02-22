package com.example.colossustex.SpinningMillOfIndia.Cotton

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.colossustex.R
import com.example.colossustex.SpinningMillOfIndia.Synthetic.SyntheticAdapter
import com.example.colossustex.databinding.FragmentCottonBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SyntheticFragment : Fragment() {
    lateinit var datalist: MutableList<SyntheticData>
    lateinit var binding: FragmentCottonBinding
    lateinit var search: SearchView
    lateinit var datalist1: MutableList<SyntheticData>
    lateinit var firebaseDatabase: FirebaseDatabase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cotton, container, false)
        binding.recyclerId.layoutManager = LinearLayoutManager(context)
        firebaseDatabase = FirebaseDatabase.getInstance()
        datalist = mutableListOf()
        binding.toolbar.inflateMenu(R.menu.cotton_menu)
        binding.toolbar.setTitle("Synthetic")
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.home_id -> findNavController().navigate(R.id.action_syntheticFragment_to_homePage)

            }
            true
        }
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        val mref = firebaseDatabase.getReference("Cotton")
        mref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()) {
                    datalist.clear()
                    for (datasnap in p0.children) {
                        val data = datasnap.getValue(SyntheticData::class.java)
                        datalist.add(data!!)
                    }
                }
                binding.recyclerId.adapter = SyntheticAdapter(datalist)
            }

        })
        val menuitem = binding.toolbar.menu.findItem(R.id.search)
        val searchView = menuitem.actionView as androidx.appcompat.widget.SearchView
        searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            @SuppressLint("DefaultLocale")
            override fun onQueryTextChange(newText: String?): Boolean {
                val userinput = newText?.toLowerCase()?.trim()

                val newlist = mutableListOf<SyntheticData>()
                for (data in datalist) {
                    if (data.textdesc.toLowerCase().trim().contains(userinput!!)) {
                        newlist.add(data)
                    }
                }
                if (newlist.isEmpty()) {
                    binding.recyclerId.visibility = View.GONE
                    binding.resultsId.visibility = View.VISIBLE
                } else {
                    binding.resultsId.visibility = View.GONE
                    binding.recyclerId.visibility = View.VISIBLE
                    binding.recyclerId.adapter = CottonAdapter(newlist)
                }
                return true
            }
        })
        return binding.root
    }

}
