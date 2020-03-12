package com.example.colossustex.SpinningMillOfIndia.Synthetic

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.colossustex.SpinningMillOfIndia.Common.MillsListFragment
import com.example.colossustex.SpinningMillOfIndia.Cotton.SyntheticFragment

private val TAB_TITLES = arrayOf(
   "Synthetic","View All Mills","Mills1"
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var frag:Fragment?=null
        when(position){
            0->frag=SyntheticTab()
            1->frag=MillsListFragment()
            2->frag=MillsListFragment()
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