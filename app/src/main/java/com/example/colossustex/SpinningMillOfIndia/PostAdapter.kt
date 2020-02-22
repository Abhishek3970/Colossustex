package com.example.colossustex.SpinningMillOfIndia

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R
import java.text.SimpleDateFormat
import java.util.*


class PostAdapter() : RecyclerView.Adapter<PostAdapter.MyViewHolder>() {

    private lateinit var context: Context
    private lateinit var posts: ArrayList<post>

    constructor(c: Context, p: ArrayList<post>) : this() {
        this.context = c
        this.posts = p
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.fragment_spinning_mill_in_india_recyler_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, pos: Int) {

        var postTime = posts[pos].date + " " + posts[pos].time + ":00"
        val calender = Calendar.getInstance()
        var format = SimpleDateFormat("dd/M/yyyy HH:mm:ss")
        val currentTime = format.format(calender.time)
//        Log.i("date","curr:$currentTime post$postTime")

        val datePost = format.parse(postTime)
        val dateCurrent = format.parse(currentTime)

//        Log.i("date","postTime:$postTime year:${date1.year} hour:${date1.hours} min:${date1.minutes} sec:${date1.seconds}")

        if (dateCurrent.year == datePost.year && dateCurrent.month == datePost.month && dateCurrent.date == datePost.date) {
            when {
                datePost.hours != dateCurrent.hours -> holder.date.text =
                    (dateCurrent.hours - datePost.hours).toString() + " hour ago,"
                datePost.minutes != dateCurrent.minutes -> holder.date.text =
                    (dateCurrent.minutes - datePost.minutes).toString() + " minute ago,"
                else -> holder.date.text = "1 minute ago,"
            }
        } else {
            holder.date.text = posts[pos].date + ","
        }
        holder.time.text = posts[pos].time
        holder.call.text = posts[pos].name.toString().slice(IntRange(0, 11)) + "..."



        when {
            posts[pos].type == "increase" -> {
                holder.description.text =
                    posts[pos].name.toString() + " has increased price of " + posts[pos].product + " by Rs. " + posts[pos].oldPrice + " to Rs. " + posts[pos].newPrice + " per kg(Ex-Mill)"
                holder.image.setImageResource(R.drawable.ic_arrow_upward)
            }
            posts[pos].type == "decrease" -> {
                holder.description.text =
                    posts[pos].name.toString() + " has decreased price of " + posts[pos].product + " by Rs. " + posts[pos].priceReduced + " to Rs. " + posts[pos].newPrice + " per kg(Ex-Mill)"
                holder.image.setImageResource(R.drawable.ic_arrow_downward)
            }
            else -> holder.description.text =
                posts[pos].name.toString() + " has added a new product " + posts[pos].product + " at " + posts[pos].newProductPrice + " per kg(Ex-Mill)"
        }

        holder.call.setOnClickListener {
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.fragment_spinning_mills_in_india_call_dialog)
            dialog.window!!.attributes.windowAnimations = R.style.DialogScale
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.attributes.dimAmount = 0.9f

            val call =
                dialog.findViewById<LinearLayout>(R.id.constraintLayout_call_spinning_mills_in_india)
            val callText =
                dialog.findViewById<TextView>(R.id.textView_call_spinning_mills_in_india_dialog)
            callText.text = "Call the ${posts[pos].nameOnly}"

            val mail =
                dialog.findViewById<LinearLayout>(R.id.constraintLayout_mail_spinning_mills_in_india)
            val mailText =
                dialog.findViewById<TextView>(R.id.textView_mail_spinning_mills_in_india_dialog)
            mailText.text = "Email the ${posts[pos].nameOnly}"

            dialog.show()
        }


    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val date = itemView.findViewById<TextView>(R.id.textView_date)
        val time = itemView.findViewById<TextView>(R.id.textView_time)
        val description = itemView.findViewById<TextView>(R.id.textView_description)
        val call = itemView.findViewById<TextView>(R.id.textView_call)
        val image = itemView.findViewById<ImageView>(R.id.imageView_status)

    }
}