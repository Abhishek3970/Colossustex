package com.example.colossustex.SpinningMillOfIndia.SearchAgent

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.colossustex.R
import com.example.colossustex.SpinningMillOfIndia.SearchAgentDirections

class SearchAgent : Fragment() {


    private val states = arrayOf(
        "Andhra Pradesh",
        "Arunachal Pradesh",
        "Assam",
        "Bihar",
        "Chhattisgarh",
        "Goa",
        "Gujarat",
        "Haryana",
        "Himachal Pradesh",
        "Jammu and Kashmir",
        "Jharkhand",
        "Karnataka",
        "Kerala",
        "Madhya Pradesh",
        "Maharashtra",
        "Manipur",
        "Meghalaya",
        "Mizoram",
        "Nagaland",
        "Odisha",
        "Punjab",
        "Rajasthan",
        "Sikkim",
        "Tamil Nadu",
        "Telangana",
        "Tripura",
        "Uttarakhand",
        "Uttar Pradesh",
        "West Bengal",
        "Andaman and Nicobar Islands",
        "Chandigarh",
        "Dadra and Nagar Haveli",
        "Daman and Diu",
        "Delhi",
        "Lakshadweep",
        "Puducherry"
    )
    private val category = arrayOf(
        "Cotton Yarn",
        "Polyester Yarn",
        "Viscose Yarn",
        "Texturised Yarn",
        "Blended Yarn",
        "Specialized Yarn"
    )
    private val cottonType = arrayOf(
        "Cotton Weaving Spun Yarn",
        "Cotton knitting Spun Yarn",
        "Cotton Open End Yarn",
        "Organic Cotton Yarn",
        "BCI Yarn",
        "Austrailia Cotton Yarn"
    )
    private val polyesterType = arrayOf(
        "Polyester Weaving Yarn",
        "Polyester Knitting Yarn"
    )
    private val viscoseType = arrayOf(
        "Viscose Yarn",
        "Viscose Open End Yarn"
    )
    private val texturizedType = arrayOf(
        "DTY",
        "POY",
        "SDF",
        "FDY"
    )
    private val blendedType = arrayOf(
        "Polyester-Cotton PC Blend",
        "Polyester-Cotton CP Blend",
        "Polyester-Viscose PV Blend",
        "Cotton-Viscose Blend",
        "Cotton-Polyester-viscose Blend",
        "PC Open End Yarn"
    )
    private val specializedType = arrayOf(
        "Supima Yarn",
        "Pima Yarn",
        "Nylon Yarn",
        "Bamboo Yarn",
        "Banana Yarn",
        "Flax Yarn",
        "Cotton-Flax Yarn",
        "Woollen Yarn",
        "Acrylic Yarn",
        "Suvin Yarn",
        "Egypt Yarn",
        "Jute Yarn",
        "Embroidary Yarn",
        "Baby Soft Yarn",
        "Industrial Yarn",
        "Sewing Yarn",
        "Dyed Yarn",
        "Indigo Dyed Yarn",
        "Gassed Yarn",
        "Mercerised Yarn",
        "Gassed Mercerised Yarn",
        "Melange Yarn",
        "Double-Plu Yarn",
        "Multiple-Ply Yarn",
        "SHPR / SHCR Yarn",
        "DHCR / DHPR / HFCR / FHPR Yarn",
        "Hank Yarn",
        "Cheese Yarn",
        "Ring Double Yarn"
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var lay = inflater.inflate(R.layout.fragment_search_agent, container, false)
        val toolbar = lay.findViewById<Toolbar>(R.id.toolbar_spinning_mills_in_india_search_agent)
        toolbar.setNavigationOnClickListener {
            it.findNavController()
                .navigate(SearchAgentDirections.actionSearchAgentToSpinningMillOfIndia())
        }
        toolbar.inflateMenu(R.menu.menu_spinning_mills_of_india)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.home_page -> {
                    toolbar.findNavController()
                        .navigate(SearchAgentDirections.actionSearchAgentToHomePage())
                }
            }
            true
        }

        val categories = lay.findViewById<TextView>(R.id.textView_yarn_category)
        val yarnType = lay.findViewById<TextView>(R.id.textView_yarn_type)
        val stateTo = lay.findViewById<TextView>(R.id.textView_state_to)
        val stateFrom = lay.findViewById<TextView>(R.id.textView_state_from)
        val search = lay.findViewById<Button>(R.id.button_search)


        yarnType.setOnClickListener {
            it.setBackgroundResource(R.drawable.background_spinner_in_search_agent)
            if (categories.text == "-- Select Yarn Category --") {
                Toast.makeText(context!!, "First enter Yarn Category", Toast.LENGTH_SHORT).show()
            } else {
                when (categories.text) {
                    "Cotton Yarn" -> {
                        val builder = AlertDialog.Builder(context!!)
                        builder.setItems(cottonType) { dialog, which ->
                            yarnType.text = cottonType[which]
                        }
                        val dialog = builder.create()
                        dialog.show()
                    }
                    "Polyester Yarn" -> {
                        val builder = AlertDialog.Builder(context!!)
                        builder.setItems(polyesterType) { dialog, which ->
                            yarnType.text = polyesterType[which]
                        }
                        val dialog = builder.create()
                        dialog.show()
                    }
                    "Viscose Yarn" -> {
                        val builder = AlertDialog.Builder(context!!)
                        builder.setItems(viscoseType) { dialog, which ->
                            yarnType.text = viscoseType[which]
                        }
                        val dialog = builder.create()
                        dialog.show()
                    }
                    "Texturised Yarn" -> {
                        val builder = AlertDialog.Builder(context!!)
                        builder.setItems(texturizedType) { dialog, which ->
                            yarnType.text = texturizedType[which]
                        }
                        val dialog = builder.create()
                        dialog.show()
                    }
                    "Blended Yarn" -> {
                        val builder = AlertDialog.Builder(context!!)
                        builder.setItems(blendedType) { dialog, which ->
                            yarnType.text = blendedType[which]
                        }
                        val dialog = builder.create()
                        dialog.show()
                    }
                    "Specialized Yarn" -> {
                        val builder = AlertDialog.Builder(context!!)
                        builder.setItems(specializedType) { dialog, which ->
                            yarnType.text = specializedType[which]
                        }
                        val dialog = builder.create()
                        dialog.show()
                    }
                }

            }
        }

        categories.setOnClickListener {
            it.setBackgroundResource(R.drawable.background_spinner_in_search_agent)
            val builder = AlertDialog.Builder(context!!)
            builder.setItems(category) { dialog, which ->
                categories.text = category[which]
                yarnType.text = "-- Select Yarn Type --"
            }
            val dialog = builder.create()
            dialog.show()
        }

        stateTo.setOnClickListener {
            it.setBackgroundResource(R.drawable.background_spinner_in_search_agent)
            val builder = AlertDialog.Builder(context!!)
            builder.setItems(states) { dialog, which ->
                stateTo.text = states[which]
            }
            val dialog = builder.create()
            dialog.show()
        }
        stateFrom.setOnClickListener {
            it.setBackgroundResource(R.drawable.background_spinner_in_search_agent)
            val builder = AlertDialog.Builder(context!!)
            builder.setItems(states) { dialog, which ->
                stateFrom.text = states[which]
            }
            val dialog = builder.create()
            dialog.show()
        }

        search.setOnClickListener {
            var ct = 0
            if (categories.text == "-- Select Yarn Category --") {
                ct++
                categories.setBackgroundResource(R.drawable.error_background)
            }
            if (yarnType.text == "-- Select Yarn Type --") {
                ct++
                yarnType.setBackgroundResource(R.drawable.error_background)
            }
            if (stateTo.text == "-- Select State --") {
                ct++
                stateTo.setBackgroundResource(R.drawable.error_background)
            }
            if (stateFrom.text == "-- Select State --") {
                ct++
                stateFrom.setBackgroundResource(R.drawable.error_background)
            }
            if (ct != 0) {
                Toast.makeText(context!!, "Please enter all highlighted fields", Toast.LENGTH_SHORT)
                    .show()
            }else{

            }
        }


        return lay

    }
}
