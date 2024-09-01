package com.example.fitin.ui.home.plans

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.fitin.databinding.FragmentPlansBinding

class Plans : Fragment() {

    private var _binding: FragmentPlansBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPlansBinding.inflate(inflater, container, false)
        val root = binding.root

        val PlanViewModel = ViewModelProvider(this)[PlansViewModel::class.java]

        binding.apply {

            val controller = PlanItemEpoxyControl()

            epoxyRecyclerView.setController(controller)

            PlanViewModel.planList.observe(viewLifecycleOwner){
                controller.setData(it)
            }

        }

        return root
    }

    fun getEpoxyRecyclerView(): EpoxyRecyclerView {
        return binding.epoxyRecyclerView
    }
}