package com.example.colossustex.buySellTextileProducts

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.text.format.DateUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.colossustex.R
import com.google.firebase.database.*


class BuySellTextileProducts : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mDb: DatabaseReference
    private lateinit var posts: ArrayList<ItemBuySell>
    private lateinit var adapter: ItemAdapterBuySell
    private lateinit var manager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val lay = inflater.inflate(R.layout.fragment_buy_sell_textile_products, container, false)
        val toolbar = lay.findViewById<Toolbar>(R.id.toolbar_buy_sell_textile_products)
        toolbar.inflateMenu(R.menu.menu_buy_sell)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.home_page -> {

                }
            }
            true
        }
        toolbar.setNavigationOnClickListener {

        }



        posts = ArrayList()

        manager = LinearLayoutManager(context)
        recyclerView = lay.findViewById(R.id.recyclerView_buy_sell)
        recyclerView.layoutManager = manager
        adapter = ItemAdapterBuySell(context!!, posts)
        recyclerView.adapter = adapter
        mDb = FirebaseDatabase.getInstance().reference.child("buySell/Item")


        mDb.addValueEventListener(
            object : ValueEventListener {

                override fun onCancelled(p0: DatabaseError) {}

                override fun onDataChange(data: DataSnapshot) {
                    posts.clear()
                    for (dataSnapshot in data.children) {
                        val p = dataSnapshot.getValue(ItemBuySell::class.java)
                        posts.add(p!!)
                    }
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
                val p = dataSnapshot.getValue(ItemBuySell::class.java)
                posts.add(p!!)
            }
            posts.reverse()
            adapter.notifyDataSetChanged()
        }

    }   //to notify changes to adapter
}
