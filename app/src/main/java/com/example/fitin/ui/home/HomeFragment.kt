package com.example.fitin.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.fitin.R
import com.example.fitin.databinding.FragmentHomeBinding
import com.example.fitin.ui.home.plans.PlanItemEpoxyControl

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homePagerAdapter: HomePagerAdapter
    private var lastScrollTime: Long = 0
    private val debounceDelay: Long = 150

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setHasOptionsMenu(true)

        val viewPager = binding.viewPager
        homePagerAdapter = HomePagerAdapter(this)
        val bottomNavigationView = binding.topAppBar

        // Set up the ViewPager with the HomePagerAdapter
        viewPager.adapter = homePagerAdapter

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

                showTopAppBar()

                attachScrollListener(position)
            }
        })

        binding.chatIcon.setOnClickListener {

            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.navigation_home,false)
                .build()

            val controller = findNavController()

            controller.navigate(R.id.action_navigation_home_to_chatFragment,null,navOptions)

        }

        return root
    }

    override fun onResume() {
        super.onResume()
        attachScrollListener(binding.viewPager.currentItem)
    }

    private fun attachScrollListener(position: Int) {

        val epoxyRecyclerView = homePagerAdapter.getEpoxyRecyclerView(position, this)

        epoxyRecyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val currentTime = System.currentTimeMillis()
                if (currentTime - lastScrollTime > debounceDelay) {
                    lastScrollTime = currentTime
                    if (dy > 0) {
                        hideTopAppBar()
                    } else if (dy < 0) {
                        showTopAppBar()
                    }
                }
            }
        })
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

    private fun hideTopAppBar() {
        binding.topAppBar.animate()
            .translationY(-(binding.topAppBar.height.toFloat() + 50))
            .setDuration(200)
            .withEndAction {
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.topAppBar.visibility = View.GONE
                }, 5)
            }
            .start()
    }

    private fun showTopAppBar() {
        binding.topAppBar.animate().translationY(0f).setDuration(200).start()
        binding.topAppBar.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
