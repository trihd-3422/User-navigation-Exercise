package com.example.usernavigationexercise

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


/**
 * Fragment to return the clicked tab.
 */
class PagerAdapter(fm: FragmentManager, private var mNumOfTabs: Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TabFragment1()
            1 -> TabFragment2()
            2 -> TabFragment3()
            else -> TabFragment1()
        }
    }

    override fun getCount(): Int {
        return mNumOfTabs
    }
}