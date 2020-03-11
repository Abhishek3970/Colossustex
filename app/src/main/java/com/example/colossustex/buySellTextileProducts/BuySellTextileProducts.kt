package com.example.colossustex.buySellTextileProducts

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_spinning_mill_of_india.*


class BuySellTextileProducts : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mDb: DatabaseReference
    private lateinit var posts: ArrayList<ItemBuySell>
    private lateinit var adapter: ItemAdapterBuySell
    private lateinit var manager: LinearLayoutManager

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val lay = inflater.inflate(R.layout.fragment_buy_sell_textile_products, container, false)
        val toolbar = lay.findViewById<Toolbar>(R.id.toolbar_buy_sell_textile_products)
        val fiber = lay.findViewById<TextView>(R.id.buy_sell_Fibre)
        val yarn = lay.findViewById<TextView>(R.id.buy_sell_Yarn)
        val fabric = lay.findViewById<TextView>(R.id.buy_sell_Fabric)
        val garment = lay.findViewById<TextView>(R.id.buy_sell_Garments)
        val stockLots = lay.findViewById<TextView>(R.id.buy_sell_stock_lots)
        val waste = lay.findViewById<TextView>(R.id.buy_sell_waste)
        val machinery = lay.findViewById<TextView>(R.id.buy_sell_machinary)
        val filterByState = lay.findViewById<TextView>(R.id.textView_filter_buy_sell)

        var stateFiber = false
        var stateYarn = false
        var stateFabric = false
        var stateGarments = false
        var stateStockLots = false
        var stateWaste = false
        var stateMachinery = false

        var list = arrayListOf<TextView>(
            fiber,
            yarn,
            fabric,
            garment,
            stockLots,
            waste,
            machinery
        )

        for (item in list) {
            item.setOnClickListener {
                when (item) {
                    fabric -> {
                        stateFabric = !stateFabric
                        if (stateFabric) {
                            fabric.setBackgroundColor(resources.getColor(R.color.fabricBackground))
                            fabric.setTextColor(Color.WHITE)
                        } else {
                            fabric.setBackgroundResource(R.drawable.background_fabric)
                            fabric.setTextColor(resources.getColor(R.color.fabricBackground))
                        }
                    }
                    yarn -> {
                        stateYarn = !stateYarn
                        if (stateYarn) {
                            yarn.setBackgroundColor(resources.getColor(R.color.yarnBackground))
                            yarn.setTextColor(Color.WHITE)
                        } else {
                            yarn.setBackgroundResource(R.drawable.background_yarn)
                            yarn.setTextColor(resources.getColor(R.color.yarnBackground))
                        }
                    }
                    fiber -> {
                        stateFiber = !stateFiber
                        if (stateFiber) {
                            fiber.setBackgroundColor(resources.getColor(R.color.fiberBackground))
                            fiber.setTextColor(Color.WHITE)
                        } else {
                            fiber.setBackgroundResource(R.drawable.background_fibre)
                            fiber.setTextColor(resources.getColor(R.color.fiberBackground))
                        }
                    }
                    garment -> {
                        stateGarments = !stateGarments
                        if (stateGarments) {
                            garment.setBackgroundColor(resources.getColor(R.color.garmentBackground))
                            garment.setTextColor(Color.WHITE)
                        } else {
                            garment.setBackgroundResource(R.drawable.background_garments)
                            garment.setTextColor(resources.getColor(R.color.garmentBackground))
                        }
                    }
                    stockLots -> {
                        stateStockLots = !stateStockLots
                        if (stateStockLots) {
                            stockLots.setBackgroundColor(resources.getColor(R.color.stocklotsBackground))
                            stockLots.setTextColor(Color.WHITE)
                        } else {
                            stockLots.setBackgroundResource(R.drawable.background_stoch_lots)
                            stockLots.setTextColor(resources.getColor(R.color.stocklotsBackground))
                        }
                    }
                    machinery -> {
                        stateMachinery = !stateMachinery
                        if (stateMachinery) {
                            machinery.setBackgroundColor(resources.getColor(R.color.machineryBackground))
                            machinery.setTextColor(Color.WHITE)
                        }
                        else{
                            machinery.setBackgroundResource(R.drawable.background_machinery)
                            machinery.setTextColor(resources.getColor(R.color.machineryBackground))
                        }
                    }
                    waste -> {
                        stateWaste = !stateWaste
                        if (stateWaste) {
                            waste.setBackgroundColor(resources.getColor(R.color.wastesBackground))
                            waste.setTextColor(Color.WHITE)
                        }
                        else{
                            waste.setBackgroundResource(R.drawable.background_waste)
                            waste.setTextColor(resources.getColor(R.color.wastesBackground))
                        }
                    }
                }
                var tempArray = ArrayList<String>()
                if (stateFabric)
                    tempArray.add(fabric.text.toString())
                if (stateGarments)
                    tempArray.add(garment.text.toString())
                if (stateYarn)
                    tempArray.add(yarn.text.toString())
                if (stateFiber)
                    tempArray.add(fiber.text.toString())
                if (stateStockLots)
                    tempArray.add(stockLots.text.toString())
                if (stateWaste)
                    tempArray.add(waste.text.toString())
                if (stateMachinery)
                    tempArray.add(machinery.text.toString())
                if (!stateFabric && !stateFiber && !stateGarments && !stateMachinery && !stateStockLots && !stateWaste && !stateYarn) {
                    tempArray.add(fabric.text.toString())
                    tempArray.add(garment.text.toString())
                    tempArray.add(yarn.text.toString())
                    tempArray.add(fiber.text.toString())
                    tempArray.add(stockLots.text.toString())
                    tempArray.add(waste.text.toString())
                    tempArray.add(machinery.text.toString())
                }
                val newPostList = ArrayList<ItemBuySell>()
                for (i in posts) {
                    if (i.catagory in tempArray)
                        newPostList.add(i)
                }
                adapter = ItemAdapterBuySell(context!!, newPostList)
                recyclerView.adapter = adapter
            }
        }       //Filtering basis of category


        filterByState.setOnClickListener {
            val dialog = BottomSheetDialog(context!!)
            dialog.setContentView(R.layout.bottom_sheet_buy_sell)
            dialog.create()
            dialog.setCancelable(false)
            dialog.show()
            val close = dialog.findViewById<ImageView>(R.id.close_dialog_buy_sell)
            close!!.setOnClickListener{
                dialog.dismiss()
            }

        }


        toolbar.inflateMenu(R.menu.menu_buy_sell)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.home_page -> {
                    toolbar.findNavController()
                        .navigate(BuySellTextileProductsDirections.actionBuySellTextileProductsToHomePage())
                }
            }
            true
        }
        toolbar.setNavigationOnClickListener {
            toolbar.findNavController()
                .navigate(BuySellTextileProductsDirections.actionBuySellTextileProductsToHomePage())

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
