package com.example.fitin.ui.home.plans

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.fitin.R
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

            val controller = PlanItemEpoxyControl(callback = {

                val navOptions = NavOptions.Builder()
                    .setPopUpTo(R.id.navigation_home,true)
                    .build()

                val controller = findNavController()

                controller.navigate(R.id.action_navigation_home_to_programDetailsFragment,null,navOptions)

            })

            epoxyRecyclerView.post {
                epoxyRecyclerView.setController(controller)
            }

            PlanViewModel.planList.observe(viewLifecycleOwner){
                controller.setData(it)
            }

        }

        return root
    }

    fun getEpoxyRecyclerView(): EpoxyRecyclerView? {
        return _binding?.epoxyRecyclerView
    }
}