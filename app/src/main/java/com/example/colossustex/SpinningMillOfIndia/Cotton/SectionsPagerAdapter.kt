package com.example.colossustex.SpinningMillOfIndia.Cotton

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.colossustex.SpinningMillOfIndia.Common.MillsListFragment


private val TAB_TITLES = arrayOf(
  "Cotton","View All Mills","Mills1","Mills2","Mills3"
)
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        var fragment:Fragment?=null
        when(position){

            0->fragment=CottonTabFragment()
            1->fragment=MillsListFragment()
            2->{
                fragment=MillsListFragment()
            }
            3->{
                fragment=MillsListFragment()
            }
            4->fragment=MillsListFragment()
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