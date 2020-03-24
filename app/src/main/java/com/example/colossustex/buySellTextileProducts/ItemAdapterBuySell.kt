package com.example.colossustex.buySellTextileProducts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso
import java.util.*


class ItemAdapterBuySell() : RecyclerView.Adapter<ItemAdapterBuySell.MyViewHolder>() {

    private lateinit var context: Context
    lateinit var posts: ArrayList<ItemBuySell>
    private val db = FirebaseDatabase.getInstance().getReference("buySell/Item")

    constructor(c: Context, p: ArrayList<ItemBuySell>) : this() {
        this.context = c
        this.posts = p
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_buy_sell,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, pos: Int) {

        val startViews = posts[pos].count

        holder.catagory.text = "Category: " + posts[pos].catagory
        holder.description.text = posts[pos].description
        holder.descriptionHeading.text = posts[pos].descriptionHeading
        holder.location.text = posts[pos].location
        holder.productName.text = posts[pos].productName
        holder.seller.text = "Seller: " + posts[pos].seller
        Picasso.get().load(posts[pos].image).into(holder.image)

        if(holder.flag == 1 && startViews == posts[pos].count ){
            var temp = (posts[pos].count?.plus(1))
            holder.countViews.text = temp.toString()+" views"
            db.child(posts[pos].itemID!!).child("count").setValue(temp)
            holder.flag = 0
        }


    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var catagory: TextView = itemView.findViewById(R.id.textView_catagory)
        var location: TextView = itemView.findViewById(R.id.textView_location)
        var productName: TextView = itemView.findViewById(R.id.textView_product_name)
        var image: ImageView = itemView.findViewById(R.id.imageView_image)
        var descriptionHeading: TextView = itemView.findViewById(R.id.textView_description_heading)
        var description: TextView = itemView.findViewById(R.id.textView_description)
        var seller: TextView = itemView.findViewById(R.id.textView_seller)
        var contactButton: ImageButton = itemView.findViewById(R.id.button_contact)
        var shareButton: ImageButton = itemView.findViewById(R.id.button_share)
        var countViews: TextView = itemView.findViewById(R.id.textView_count)
        var flag = 1
    }
}