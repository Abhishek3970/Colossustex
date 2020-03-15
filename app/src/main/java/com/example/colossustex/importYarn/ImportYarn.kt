package com.example.colossustex.importYarn

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R
import com.example.colossustex.SpinningMillOfIndia.Fancy.FancyActivity
import com.example.colossustex.SpinningMillOfIndia.Texturised.TexturisedActivity
import com.example.colossustex.SpinningMillOfIndia.Viscose.ViscoseActivity
import com.example.colossustex.SpinningMillOfIndia.post
import com.example.colossustex.databinding.ImportYarnFragmentBinding
import com.google.firebase.database.*

class ImportYarn : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mDb: DatabaseReference
    private lateinit var posts: ArrayList<post>
    private lateinit var adapter: PostAdapterImport
    private lateinit var manager: LinearLayoutManager

    private lateinit var viewModel: ImportYarnViewModel
    private lateinit var binding: ImportYarnFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.import_yarn_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(ImportYarnViewModel::class.java)

        binding.importYarnViewModel = viewModel

        binding.lifecycleOwner = this

        viewModel.cotton?.observe(this, Observer { to ->
            if (to == true) {
                viewModel.doneNavigation()
                binding.toolbarImport.findNavController()
                    .navigate(ImportYarnDirections.actionImportYarnToCottonFragment())
            }
        })
        viewModel.viscose?.observe(this, Observer { to ->
            if (to == true) {
                viewModel.doneNavigation()
                startActivity(
                    Intent(
                        context,
                        ViscoseActivity::class.java
                    )
                )
            }
        })
        viewModel.texturized?.observe(this, Observer { to ->
            if (to == true) {
                viewModel.doneNavigation()
                startActivity(Intent(context, TexturisedActivity::class.java))
            }
        })
        viewModel.fancy?.observe(this, Observer { to ->
            if (to == true) {
                viewModel.doneNavigation()
                startActivity(Intent(context, FancyActivity::class.java))
            }
        })
        viewModel.synthetic?.observe(this, Observer { to ->
            if (to == true) {
                viewModel.doneNavigation()
                binding.toolbarImport.findNavController()
                    .navigate(ImportYarnDirections.actionImportYarnToSyntheticFragment())
            }
        })


        binding.toolbarImport.inflateMenu(R.menu.menu_import_yarn)
        binding.toolbarImport.setNavigationOnClickListener {
            it.findNavController().navigate(ImportYarnDirections.actionImportYarnToHomePage())
        }

        posts = ArrayList()

        manager = LinearLayoutManager(context)
        binding.recylerViewSpinningMillsOfIndia.layoutManager = manager
        adapter = PostAdapterImport(context!!, posts)
        binding.recylerViewSpinningMillsOfIndia.adapter = adapter

        mDb = FirebaseDatabase.getInstance().reference.child("postsSpinningMillsOfIndia")


        mDb.addValueEventListener(
            object : ValueEventListener {

                override fun onCancelled(p0: DatabaseError) {}

                override fun onDataChange(data: DataSnapshot) {
                    posts.clear()
                    for (dataSnapshot in data.children) {
                        val p = dataSnapshot.getValue(post::class.java)
                        posts.add(p!!)
                    }
                    posts.reverse()
                    adapter.notifyDataSetChanged()
                }
            })     //for first time loading.

        return binding.root

    }


}
