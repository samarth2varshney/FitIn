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
        return when (position) {
            0 -> Feed()
            1 -> Rankings()
            2 -> Plans()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }

    fun getEpoxyRecyclerView(position: Int, fragments: Fragment): EpoxyRecyclerView? {
        val fragment = fragments.childFragmentManager.findFragmentByTag("f$position")
        return if (fragment is Feed) {
            fragment.getEpoxyRecyclerView()
        } else if (fragment is Rankings) {
            fragment.getEpoxyRecyclerView()
        } else if (fragment is Plans) {
            fragment.getEpoxyRecyclerView()
        } else {
            null
        }
    }
}
