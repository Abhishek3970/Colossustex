package com.example.colossustex.SpinningMillOfIndia.Cotton

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.colossustex.SpinningMillOfIndia.Common.MillsListFragment


private val TAB_TITLES = arrayOf(
    "Cotton", "" +
            "All Mills", "Weaving Yarn", "Knitting Yarn", "Open End"
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager,val type:String) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        var fragment: Fragment? = null
        when (position) {

            0 -> fragment = CottonTabFragment()
            1 -> fragment = MillsListFragment(type)
            2 -> fragment = Weaving()
            3 -> fragment = KnittingYarn()
            4 -> fragment = MillsListFragment(type)
        }
        return fragment!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return (TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 5
    }
}