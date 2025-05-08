package com.example.fitin.ui.home.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.fitin.R
import com.example.fitin.databinding.FragmentFeedBinding
import com.example.fitin.ui.home.feed.comments.CommentsBottomSheet

class Feed : Fragment() {

    private var _binding: FragmentFeedBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFeedBinding.inflate(inflater,container,false)
        val root = binding.root

        val feedViewModel = ViewModelProvider(this)[FeedViewModel::class.java]

        binding.apply {

            val controller = FeedItemEpoxyController(commentsCallback = {
                CommentsBottomSheet().show(childFragmentManager,"comments")
                },
                profileCallback = {
                    findNavController().navigate(R.id.navigation_profile)
                })



            epoxyRecyclerView.post {
                epoxyRecyclerView.setController(controller)
            }

            feedViewModel.feedList.observe(viewLifecycleOwner){
                controller.setData(it)
            }

        }

        binding

        return root
    }

    fun getEpoxyRecyclerView(): EpoxyRecyclerView? {
        return _binding?.epoxyRecyclerView
    }
}