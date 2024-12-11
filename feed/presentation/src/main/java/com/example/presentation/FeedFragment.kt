package com.example.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.presentation.comments.CommentsBottomSheet
import com.example.presentation.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

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

            val controller = FeedItemEpoxyController(callback = {
                CommentsBottomSheet().show(childFragmentManager,"comments")
            })

            epoxyRecyclerView.post {
                epoxyRecyclerView.setController(controller)
            }

            feedViewModel.feedList.observe(viewLifecycleOwner){
                controller.setData(it)
            }

        }

        return root
    }

    fun getEpoxyRecyclerView(): EpoxyRecyclerView? {
        return _binding?.epoxyRecyclerView
    }
}