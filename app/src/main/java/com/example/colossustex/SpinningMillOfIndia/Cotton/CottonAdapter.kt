package com.example.colossustex.SpinningMillOfIndia.Cotton

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.colossustex.R
import com.smarteist.autoimageslider.DefaultSliderView
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderLayout

class CottonAdapter(var list: MutableList<SyntheticData>) :
    RecyclerView.Adapter<CottonAdapter.MyViewHolder>() {
    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val image = itemview.findViewById<ImageView>(R.id.cotton_image)
        val text = itemview.findViewById<TextView>(R.id.cotton_text)
        val sliderLayout = itemview.findViewById<SliderLayout>(R.id.imageSlider)

        init {
            Log.i("Adapter", "visible2")
            sliderLayout.visibility = View.VISIBLE
            sliderLayout.setIndicatorAnimation(IndicatorAnimations.SWAP) //set indicator animation by using 	 				SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
            sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
            sliderLayout.scrollTimeInSec = 2 //set scroll delay in seconds :

            for (i in 0..3) {

                val sliderView = DefaultSliderView(itemview.context)

                when (i) {
                    0 -> sliderView.imageUrl =
                        "https://images.pexels.com/photos/547114/pexels-photo-547114.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                    1 -> sliderView.imageUrl =
                        "https://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                    2 -> sliderView.imageUrl =
                        "https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
                    3 -> sliderView.imageUrl =
                        "https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                }
                sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                //at last add this view in your layout :
                sliderLayout.addSliderView(sliderView)

            }
        }      // For SliderView
    }   //ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cotton_item, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.text.text = list[position].textdesc
        Glide.with(holder.itemView)
            .load(list[position].imageurl)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.image)
        if (position == 0) {
            holder.sliderLayout.visibility = View.VISIBLE
        } else {
            holder.sliderLayout.visibility = View.GONE
        }
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Hello", Toast.LENGTH_SHORT).show()
        }
    }

}   //Adapter for RecyclerView