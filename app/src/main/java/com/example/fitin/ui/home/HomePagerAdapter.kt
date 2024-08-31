package com.example.fitin.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fitin.ui.home.feed.Feed
import com.example.fitin.ui.home.plans.Plans
import com.example.fitin.ui.home.rankings.Rankings

class HomePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Feed()
            1 -> Rankings()
            2 -> Plans()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}