package com.example.colossustex.SpinningMillOfIndia.Synthetic


import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.colossustex.R
import com.example.colossustex.SpinningMillOfIndia.Cotton.SyntheticData
import com.smarteist.autoimageslider.DefaultSliderView
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderLayout

class SyntheticAdapter(var list: MutableList<SyntheticData>) :
    RecyclerView.Adapter<SyntheticAdapter.MyViewHolder>() {
    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val image = itemview.findViewById<ImageView>(R.id.synthetic_image)
        val text = itemview.findViewById<TextView>(R.id.synthetic_text)
        val sliderLayout = itemview.findViewById<SliderLayout>(R.id.synthetic_imageSlider)

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
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.synthetic_item, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.text.text = list[position].textdesc
        when (position) {
            0->holder.image.setImageResource(R.drawable.yarn1)
            1->holder.image.setImageResource(R.drawable.yarn2)
            2->holder.image.setImageResource(R.drawable.yarn3)
            3->holder.image.setImageResource(R.drawable.yarn4)
            4->holder.image.setImageResource(R.drawable.yarn5)
            5->holder.image.setImageResource(R.drawable.yarn6)
            6->holder.image.setImageResource(R.drawable.yarn1)
            7->holder.image.setImageResource(R.drawable.yarn2)
            8->holder.image.setImageResource(R.drawable.yarn3)
            9->holder.image.setImageResource(R.drawable.yarn4)
            10->holder.image.setImageResource(R.drawable.yarn5)
            11->holder.image.setImageResource(R.drawable.yarn6)
            12->holder.image.setImageResource(R.drawable.yarn1)
            13->holder.image.setImageResource(R.drawable.yarn2)
            14->holder.image.setImageResource(R.drawable.yarn3)
        }
        if (position == 0) {
            holder.sliderLayout.visibility = View.VISIBLE
        } else {
            holder.sliderLayout.visibility = View.GONE
        }
        holder.itemView.setOnClickListener {
            holder.itemView.context.startActivity(
                Intent(
                    holder.itemView.context,
                    SyntheticTabbed::class.java
                ).putExtra("Position", position)
            )
        }
    }

}   //Adapter for RecyclerView