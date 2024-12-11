package com.example.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.presentation.databinding.FragmentRankingBinding

class RankingFragment : Fragment() {

    private var _binding: FragmentRankingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRankingBinding.inflate(inflater,container,false)
        val root = binding.root

        val rankingViewModel = ViewModelProvider(this)[RankingViewModel::class.java]

        binding.apply {

            val controller = RankingEpoxyControl()

            epoxyRecyclerView.post {
                epoxyRecyclerView.setController(controller)
            }

            rankingViewModel.rankingList.observe(viewLifecycleOwner){
                controller.setData(it)
            }

        }

        return root
    }

    fun getEpoxyRecyclerView(): EpoxyRecyclerView? {
        return _binding?.epoxyRecyclerView
    }
}