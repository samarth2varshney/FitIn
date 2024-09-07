package com.example.fitin.ui.profile

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fitin.ui.profile.bookmarks.bookmarks
import com.example.fitin.ui.profile.posts.posts

class ProfilePagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> posts()
            1 -> bookmarks()
            else -> throw IllegalStateException("Invalid position")
        }
    }
}