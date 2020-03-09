package com.example.colossustex.buySellTextileProducts

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.text.format.DateUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.colossustex.R


class BuySellTextileProducts : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val lay = inflater.inflate(R.layout.fragment_buy_sell_textile_products, container, false)

        return lay
    }

}
