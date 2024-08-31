package com.example.fitin.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fitin.R
import com.example.fitin.databinding.FragmentHomeBinding
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setHasOptionsMenu(true)

        findNavController().navigate(R.id.action_navigation_home_to_rankings)


        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_app_bar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.navigation_rankings -> {
                Log.i("samarth","chala")
                findNavController().navigate(R.id.action_navigation_home_to_rankings)
                true
            }
            R.id.navigation_feed -> {
                findNavController().navigate(R.id.action_navigation_home_to_feed)
                true
            }
            R.id.navigation_plans -> {
                Log.i("samarth","chala")
                findNavController().navigate(R.id.action_navigation_home_to_plans)
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