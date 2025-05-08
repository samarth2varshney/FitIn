package com.example.fitin.ui.profile

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.fitin.databinding.FragmentProfileBinding
import com.example.fitin.ui.search.SearchItemEpoxyController
import com.example.fitin.ui.search.SearchViewModel

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val viewPager: ViewPager2 = binding.fragmentContainer
//        viewPager.adapter = ProfilePagerAdapter(this)

        highlightIcon(0)

//        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                highlightIcon(position)
//            }
//        })
//
//        binding.iconPosts.setOnClickListener {
//            viewPager.setCurrentItem(0, true)
//        }
//
//        binding.iconBookmarks.setOnClickListener {
//            viewPager.setCurrentItem(1, true)
//        }

        binding.apply {
            val controller = SearchItemEpoxyController()

            posts.post {
                posts.setController(controller)
            }

            searchViewModel.searchList.observe(viewLifecycleOwner) {
                controller.setData(it)
            }

        }

        return root
    }

    private fun highlightIcon(position: Int) {
        binding.iconPosts.setColorFilter(Color.GRAY)
        binding.iconBookmarks.setColorFilter(Color.GRAY)

        when (position) {
            0 -> binding.iconPosts.setColorFilter(Color.BLUE)
            1 -> binding.iconBookmarks.setColorFilter(Color.BLUE)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}