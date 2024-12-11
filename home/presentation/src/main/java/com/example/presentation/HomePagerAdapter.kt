package com.example.presentation

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.airbnb.epoxy.EpoxyRecyclerView

class HomePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val fragments = listOf(
        FeedFragment(),
        RankingFragment(),
        PlansFragment()
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FeedFragment()
            1 -> RankingFragment()
            2 -> PlansFragment()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }

    fun getEpoxyRecyclerView(position: Int, fragments: Fragment): EpoxyRecyclerView? {
        val fragment = fragments.childFragmentManager.findFragmentByTag("f$position")
        return if (fragment is FeedFragment) {
            fragment.getEpoxyRecyclerView()
        } else if (fragment is RankingFragment) {
            fragment.getEpoxyRecyclerView()
        } else if (fragment is PlansFragment) {
            fragment.getEpoxyRecyclerView()
        } else {
            null
        }
    }
}
