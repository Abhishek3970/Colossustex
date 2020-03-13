package com.example.colossustex.SpinningMillOfIndia.SearchAgent.Agents

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


private val TAB_TITLES = arrayOf(
    "AGENTS",
    "AGENTS CUM TRADERS"
)


class PagerAdapter(
    context: Context,
    fm: FragmentManager,
    val type: String,
    val stateFrom: String,
    val stateTo: String
) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {

        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = Agentstab(type,stateFrom,stateTo )
            1 -> fragment = Agentcumtraders(type,stateFrom,stateTo)
        }
        return fragment!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TAB_TITLES[position]
    }

    override fun getCount(): Int {
        return 2
    }
}
