package com.example.colossustex.homePage

import android.app.Dialog
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R
import com.example.colossustex.SG.Textile_News
import com.example.colossustex.SG.sensex_SG
import com.example.colossustex.SG.yarn_offers
import com.example.colossustex.SG.yarn_requirements
import com.smarteist.autoimageslider.DefaultSliderView
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderLayout
import com.squareup.picasso.Picasso

class ItemAdapter(var list: MutableList<Item>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.home_page_items, parent, false)
        )
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.description.text = list[position].description
        holder.heading.text = list[position].heading
//       holder.image.setImageResource(R.drawable.yarn)
        //   val itemList : ArrayList<String> = {"Cotton", "Synthetic", "Viscose", "Texturised", "Fancy"}

        holder.constraintLayout.setOnClickListener {
            when (position) {
                0 -> holder.constraintLayout.findNavController().navigate(HomePageDirections.actionHomePageToSpinningMillOfIndia())
                1 -> holder.constraintLayout.findNavController().navigate(HomePageDirections.actionHomePageToImportYarn())
                2-> holder.constraintLayout.findNavController().navigate(HomePageDirections.actionHomePageToBuySellTextileProducts())
                3-> it.context.startActivity(Intent(it.context, yarn_offers::class.java))
                4-> {
                    var dialog = Dialog(it.context)
                    dialog.setContentView(R.layout.buy_yarn_offers_dialog1)
                    val cotton = dialog.findViewById<TextView>(R.id.dialog_cotton)
                    val synthetic = dialog.findViewById<TextView>(R.id.dialog_synthetic)
                    cotton.setOnClickListener {
                        //start an activity cotton

                    }
                    synthetic.setOnClickListener {
                        //start synthic activity
                        it.context.startActivity(Intent(it.context, yarn_offers::class.java))

                    }
                    dialog.show()
                }
//                5 -> (AlertDialog.Builder(it.context).setSingleChoiceItems(itemList, -1){dialog, which->
//                    Toast.makeText(it.context, itemList[which], Toast.LENGTH_SHORT).show()
//                }
//                val alertDialog = builder.create()
//                alertDialog.show())
                6 -> it.context.startActivity(Intent(it.context, yarn_requirements::class.java))
                7 -> it.context.startActivity(Intent(it.context, Textile_News::class.java))
                else -> Toast.makeText(it.context,list[position].description, Toast.LENGTH_SHORT).show()
            }
        }

        if (position == 9) {
            holder.view2.visibility = View.INVISIBLE
        }

        if (position == 0) {
            holder.sliderLayout.visibility = View.VISIBLE
        }                //To set the sliderLayout only for the first item
        else {
            holder.sliderLayout.visibility = View.GONE
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image: ImageView = itemView.findViewById(R.id.imageView_image)
        val heading: TextView = itemView.findViewById(R.id.textView_heading)
        val description: TextView = itemView.findViewById(R.id.textView_description)
        val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.constraintLayout1)
        val sliderLayout: SliderLayout = itemView.findViewById(R.id.imageSlider)
        val view2: View = itemView.findViewById(R.id.view2)

        init {

            Log.i("Adapter", "visible")
            sliderLayout.visibility = View.VISIBLE
            sliderLayout.setIndicatorAnimation(IndicatorAnimations.SWAP) //set indicator animation by using 	 				SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
            sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
            sliderLayout.scrollTimeInSec = 2; //set scroll delay in seconds :

            for (i in 0..3) {


                val sliderView = DefaultSliderView(constraintLayout.context)

                when (i) {
                    0 -> sliderView.setImageDrawable(R.drawable.yarn)

                    1 ->sliderView.setImageDrawable(R.drawable.yarn)

                    2 ->sliderView.setImageDrawable(R.drawable.yarn)

                    3 -> sliderView.setImageDrawable(R.drawable.yarn)

                }

                sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                sliderView.setOnSliderClickListener {
                    Toast.makeText(
                        constraintLayout.context,
                        "This is slider " + (i + 1),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                //at last add this view in your layout :
                sliderLayout.addSliderView(sliderView)
            }



        }

    }
}


