package com.example.colossustex.importYarn

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView.OnScrollListener.SCROLL_STATE_IDLE
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R
import com.example.colossustex.SG.yarn_requirements
import com.example.colossustex.SpinningMillOfIndia.AppBarStateChangedListener
import com.example.colossustex.SpinningMillOfIndia.Fancy.FancyActivity
import com.example.colossustex.SpinningMillOfIndia.Texturised.TexturisedActivity
import com.example.colossustex.SpinningMillOfIndia.Viscose.ViscoseActivity
import com.example.colossustex.SpinningMillOfIndia.post
import com.example.colossustex.databinding.ImportYarnFragmentBinding
import com.google.android.material.appbar.AppBarLayout
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

        binding.postYarnRequirements.setOnClickListener {
            startActivity(Intent(it.context, yarn_requirements::class.java))
        }


        binding.toolbarImport.inflateMenu(R.menu.menu_import_yarn)
        binding.toolbarImport.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }
        binding.toolbarImport.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.home_page -> {
                    binding.toolbarImport.findNavController().navigateUp()
                }
            }
            true
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

        binding.appBarSpinningMillsInIndia.addOnOffsetChangedListener(
            object : AppBarStateChangedListener() {
                override fun onStateChanged(appBarLayout: AppBarLayout, state: State) {
//                    Toast.makeText(context,"${state.name}",Toast.LENGTH_SHORT).show()
//                    states -  EXPANDED, COLLAPSED, IDLE
                    if (state == State.COLLAPSED) {
                        binding.constraintLayoutSearch.visibility = View.VISIBLE

                        binding.filter.visibility = View.VISIBLE
                    }
                }
            }
        )
        binding.recylerViewSpinningMillsOfIndia.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)

                    if (manager.findFirstCompletelyVisibleItemPosition() == 0 && newState == SCROLL_STATE_IDLE) {
                        binding.constraintLayoutSearch.visibility = View.GONE
                        binding.editTextSearchSpinningMillsInIndia.text.clear()
                        binding.filter.visibility = View.GONE

//                            .animate().alpha(0.0f);
                    }

                }
            }
        )

        binding.editTextSearchSpinningMillsInIndia.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun afterTextChanged(p0: Editable?) {
                    if (binding.editTextSearchSpinningMillsInIndia.text.trim().isEmpty()) {
                        mDb.addListenerForSingleValueEvent(valueEventListener)    //display all
                    } else {
                        val query = mDb
                            .orderByChild("sname")
                            .startAt(binding.editTextSearchSpinningMillsInIndia.text.toString().toLowerCase())
                            .endAt("${binding.editTextSearchSpinningMillsInIndia.text.toString().toLowerCase()}\uf8ff")
                        query.addListenerForSingleValueEvent(valueEventListener)  //query selected
                    }
                }
            }                    //textWatcher to run different queries at diff situations
        )

        binding.imageButtonClearSearchSpinningMillsOfIndia.setOnClickListener {
            binding.editTextSearchSpinningMillsInIndia.text.clear()                         //Clear filter text
        }

        return binding.root

    }

    val valueEventListener = object : ValueEventListener {
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

    }   //to notify changes to adapter


}
