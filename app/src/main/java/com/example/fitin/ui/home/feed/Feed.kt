package com.example.fitin.ui.home.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.fitin.databinding.FragmentFeedBinding

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

        return root
    }
}