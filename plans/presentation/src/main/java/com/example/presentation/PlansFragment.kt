package com.example.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.presentation.databinding.FragmentPlansBinding

class PlansFragment : Fragment() {

    private var _binding: FragmentPlansBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPlansBinding.inflate(inflater, container, false)
        val root = binding.root

        val planViewModel = ViewModelProvider(this)[PlansViewModel::class.java]

        binding.apply {

            val controller = PlanItemEpoxyControl(callback = {



            })

            epoxyRecyclerView.post {
                epoxyRecyclerView.setController(controller)
            }

            planViewModel.planList.observe(viewLifecycleOwner){
                controller.setData(it)
            }

        }

        return root
    }

    fun getEpoxyRecyclerView(): EpoxyRecyclerView? {
        return _binding?.epoxyRecyclerView
    }
}