package com.example.fitin.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.fitin.ui.home.feed.Feed
import com.example.fitin.ui.home.plans.Plans
import com.example.fitin.ui.home.rankings.Rankings

class HomePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val fragments = listOf(
        Feed(),
        Rankings(),
        Plans()
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun getEpoxyRecyclerView(position: Int): EpoxyRecyclerView? {
        return when (position) {
            0 -> (fragments[0] as Feed).getEpoxyRecyclerView()
            1 -> (fragments[1] as Rankings).getEpoxyRecyclerView()
            2 -> (fragments[2] as Plans).getEpoxyRecyclerView()
            else -> null
        }
    }
}
