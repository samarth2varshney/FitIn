package com.example.fitin.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.fitin.R
import com.example.fitin.databinding.FragmentHomeBinding
import com.example.fitin.ui.home.feed.Feed
import com.example.fitin.ui.home.plans.plansFragment
import com.example.fitin.ui.home.rankings.rankingsFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        Log.d("HomeFragment", "onCreateView started")
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        Log.d("HomeFragment", "Binding inflated")

        if (_binding == null || binding.topAppBar == null) {
            Log.e("HomeFragment", "Binding or views are null")
        }

        // Set up BottomNavigationView
        binding.topAppBar.setOnNavigationItemSelectedListener { item ->
            handleMenuItemClick(item)
        }

        if (savedInstanceState == null) {
            Log.d("HomeFragment", "Navigating to Feed Fragment")
            findNavController().navigate(R.id.navigation_feed)
        }

        return root
    }

    private fun handleMenuItemClick(item: MenuItem): Boolean {
        val navController = findNavController() // Replace with your NavController reference
        return when (item.itemId) {
            R.id.navigation_feed -> {
                navController.navigate(R.id.navigation_feed)
                true
            }
            R.id.navigation_ranking -> {
                navController.navigate(R.id.navigation_ranking)
                true
            }
            R.id.navigation_plan -> {
                navController.navigate(R.id.navigation_plan)
                true
            }
            else -> false
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
