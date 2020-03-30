package com.example.colossustex.SpinningMillOfIndia.Synthetic

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.colossustex.SpinningMillOfIndia.Common.MillsListFragment

private val TAB_TITLES = arrayOf(
    "Synthetic", "View All Mills", "PSF Mills"
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager,val type:String) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var frag: Fragment? = null
        when (position) {
            0 -> frag = SyntheticTab()
            1 -> frag = MillsListFragment(type)
            2 -> frag = PSFYarn()
        }
        return frag!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return (TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 3
    }
}