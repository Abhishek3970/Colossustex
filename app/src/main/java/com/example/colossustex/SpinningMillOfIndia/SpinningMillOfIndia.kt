package com.example.colossustex.SpinningMillOfIndia

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE
import com.example.colossustex.R
import com.example.colossustex.SpinningMillOfIndia.Fancy.FancyActivity
import com.example.colossustex.SpinningMillOfIndia.Texturised.TexturisedActivity
import com.example.colossustex.SpinningMillOfIndia.Viscose.ViscoseActivity
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_spinning_mill_of_india.*

class SpinningMillOfIndia : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mDb: DatabaseReference
    private lateinit var posts: ArrayList<post>
    private lateinit var adapter: PostAdapter
    private lateinit var manager: LinearLayoutManager
    private var done = false


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var lay = inflater.inflate(R.layout.fragment_spinning_mill_of_india, container, false)
        val toolbar =
            lay.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_spinning_mills_in_india)
        val cotton = lay.findViewById<TextView>(R.id.textView_cotton)
        cotton.setOnClickListener {
            it.findNavController().navigate(R.id.action_spinningMillOfIndia_to_cottonFragment)
        }
        val synthetic = lay.findViewById<TextView>(R.id.textView_Synthetic)
        synthetic.setOnClickListener {
            it.findNavController().navigate(R.id.action_spinningMillOfIndia_to_syntheticFragment)
        }
        val viscose = lay.findViewById<TextView>(R.id.textView_viscose)
        viscose.setOnClickListener {
            startActivity(
                Intent(
                    context,
                    ViscoseActivity::class.java
                )
            )
        }
        val texturised = lay.findViewById<TextView>(R.id.textView_texturised)
        texturised.setOnClickListener {
            startActivity(Intent(context, TexturisedActivity::class.java))
        }
        val fancy = lay.findViewById<TextView>(R.id.textView_fancy)
        fancy.setOnClickListener {
            startActivity(Intent(context, FancyActivity::class.java))
        }
        val postYarnRequirement = lay.findViewById<CardView>(R.id.cardView_post_yarn_requirement)
        val directMillAgentsandTraders =
            lay.findViewById<CardView>(R.id.cardView_direct_mill_agent_and_traders)
        val filterByName = lay.findViewById<EditText>(R.id.editText_search_spinning_mills_in_india)
        val clearFilter =
            lay.findViewById<ImageButton>(R.id.imageButton_clear_search_spinning_mills_of_india)
        val appBarLayout = lay.findViewById<AppBarLayout>(R.id.app_bar_spinning_mills_in_india)
        val searchLayout = lay.findViewById<ConstraintLayout>(R.id.constraintLayout_search)

        val searchAgentOption =
            lay.findViewById<ConstraintLayout>(R.id.constraint_layout_direct_mill_agent_and_traders)

        searchAgentOption.setOnClickListener {
            it.findNavController()
                .navigate(SpinningMillOfIndiaDirections.actionSpinningMillOfIndiaToSearchAgent())
        }

        toolbar.inflateMenu(R.menu.menu_spinning_mills_of_india)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.home_page -> {
                    toolbar.findNavController().navigateUp()
                }
            }
            true
        }
        toolbar.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }

        posts = ArrayList()

        manager = LinearLayoutManager(context)
        recyclerView = lay.findViewById(R.id.recylerView_spinning_mills_of_india)
        recyclerView.layoutManager = manager
        adapter = PostAdapter(context!!, posts)
        recyclerView.adapter = adapter

        recyclerView.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)

                    if (manager.findFirstCompletelyVisibleItemPosition() == 0 && newState == SCROLL_STATE_IDLE) {
                        searchLayout.visibility = View.GONE
                        filterByName.text.clear()
                        filter.visibility = View.GONE

//                            .animate().alpha(0.0f);
                    }

                }
            }
        )

        appBarLayout.addOnOffsetChangedListener(
            object : AppBarStateChangedListener() {
                override fun onStateChanged(appBarLayout: AppBarLayout, state: State) {
//                    Toast.makeText(context,"${state.name}",Toast.LENGTH_SHORT).show()
//                    states -  EXPANDED, COLLAPSED, IDLE
                    if (state == State.COLLAPSED) {
                        searchLayout.visibility = View.VISIBLE

                        filter.visibility = View.VISIBLE
                    }
                }
            }
        )



        mDb = FirebaseDatabase.getInstance().reference.child("postsSpinningMillsOfIndia")



        filterByName.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun afterTextChanged(p0: Editable?) {
                    if (filterByName.text.trim().isEmpty()) {
                        mDb.addListenerForSingleValueEvent(valueEventListener)    //display all
                    } else {
                        val query = mDb
                            .orderByChild("sname")
                            .startAt(filterByName.text.toString().toLowerCase())
                            .endAt("${filterByName.text.toString().toLowerCase()}\uf8ff")
                        query.addListenerForSingleValueEvent(valueEventListener)  //query selected
                    }
                }
            }                    //textWatcher to run different queries at diff situations
        )

        clearFilter.setOnClickListener {
            filterByName.text.clear()                         //Clear filter text
        }


        var cottonState = true
        var syntheticState = true
        var viscoseState = true
        var texturizedState = true
        var fancyState = true

        val filterOption = lay.findViewById<TextView>(R.id.textView_filter)
        filterOption.setOnClickListener {
            // creating dialog
            val dialog = BottomSheetDialog(context!!)
            dialog.setContentView(R.layout.bottom_sheet_dialog_spinning_mills_of_india)
            dialog.create()
            dialog.setCancelable(false)
            dialog.show()
            val close =
                dialog.findViewById<ImageView>(R.id.close_dialog_filter_spinning_mills_of_india)
            close!!.setOnClickListener {
                dialog.dismiss()
            }
            val checkboxCotton = dialog.findViewById<CheckBox>(R.id.checkbox_cotton)
            val checkboxSynthetic = dialog.findViewById<CheckBox>(R.id.checkbox_synthetic)
            val checkboxViscose = dialog.findViewById<CheckBox>(R.id.checkbox_viscose)
            val checkboxTexturized = dialog.findViewById<CheckBox>(R.id.checkbox_texturized)
            val checkboxFancy = dialog.findViewById<CheckBox>(R.id.checkbox_fancy)
            checkboxCotton!!.isChecked = cottonState
            checkboxSynthetic!!.isChecked = syntheticState
            checkboxViscose!!.isChecked = viscoseState
            checkboxTexturized!!.isChecked = texturizedState
            checkboxFancy!!.isChecked = fancyState
            val list = mutableListOf(
                checkboxCotton,
                checkboxFancy,
                checkboxSynthetic,
                checkboxTexturized,
                checkboxViscose
            )
            for (item in list) {
                item.setOnClickListener {
                    when (item) {
                        checkboxCotton -> cottonState = checkboxCotton.isChecked
                        checkboxSynthetic -> syntheticState = checkboxSynthetic.isChecked
                        checkboxViscose -> viscoseState = checkboxViscose.isChecked
                        checkboxTexturized -> texturizedState = checkboxTexturized.isChecked
                        checkboxFancy -> fancyState = checkboxFancy.isChecked

                    }
                    if (!cottonState && !syntheticState && !viscoseState && !texturizedState && !fancyState) {
                        checkboxCotton.isChecked = true
                        checkboxSynthetic.isChecked = true
                        checkboxViscose.isChecked = true
                        checkboxTexturized.isChecked = true
                        checkboxFancy.isChecked = true
                    }
                    // continue by adding filters here.....
                    var tempList = ArrayList<String>()
                    if (checkboxCotton.isChecked)
                        tempList.add("Cotton")
                    if (checkboxFancy.isChecked)
                        tempList.add("Fancy")
                    if (checkboxSynthetic.isChecked)
                        tempList.add("Synthetic")
                    if (checkboxViscose.isChecked)
                        tempList.add("Viscose")
                    if (checkboxTexturized.isChecked)
                        tempList.add("Texturized")

                    val newPostList = ArrayList<post>()
                    for (i in posts) {
                        if (i.productType in tempList)
                            newPostList.add(i)
                    }

                    adapter = PostAdapter(context!!, newPostList)
                    recyclerView.adapter = adapter


                }
            }

        }





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
            }       //for first time loading.
        )


        return lay
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
