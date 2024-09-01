package com.example.fitin.ui.home.rankings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.fitin.databinding.FragmentRankingsBinding

class Rankings : Fragment() {

    private var _binding: FragmentRankingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRankingsBinding.inflate(inflater,container,false)
        val root = binding.root

        val rankingViewModel = ViewModelProvider(this)[RankingsViewModel::class.java]

        binding.apply {

            val controller = RankingEpoxyControl()

            epoxyRecyclerView.setController(controller)

            rankingViewModel.rankingList.observe(viewLifecycleOwner){
                controller.setData(it)
            }

        }

        return root
    }

    fun getEpoxyRecyclerView(): EpoxyRecyclerView {
        return binding.epoxyRecyclerView
    }
}