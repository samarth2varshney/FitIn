package com.example.fitin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.fitin.R
import com.example.fitin.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setHasOptionsMenu(true)

        val viewPager = binding.viewPager
        val bottomNavigationView = binding.topAppBar

        // Set up the ViewPager with the HomePagerAdapter
        viewPager.adapter = HomePagerAdapter(this)

        // Listen for tab selection in BottomNavigationView and change ViewPager page
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_feed -> viewPager.setCurrentItem(0, true)
                R.id.navigation_rankings -> viewPager.setCurrentItem(1, true)
                R.id.navigation_plans -> viewPager.setCurrentItem(2, true)
            }
            true
        }

        // Link ViewPager changes with BottomNavigationView
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> bottomNavigationView.selectedItemId = R.id.navigation_feed
                    1 -> bottomNavigationView.selectedItemId = R.id.navigation_rankings
                    2 -> bottomNavigationView.selectedItemId = R.id.navigation_plans
                }
            }
        })

        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_app_bar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.navigation_rankings -> {
                binding.viewPager.setCurrentItem(1, true)
                true
            }
            R.id.navigation_feed -> {
                binding.viewPager.setCurrentItem(0, true)
                true
            }
            R.id.navigation_plans -> {
                binding.viewPager.setCurrentItem(2, true)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
