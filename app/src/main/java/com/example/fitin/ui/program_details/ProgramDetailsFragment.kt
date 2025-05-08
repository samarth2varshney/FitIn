package com.example.fitin.ui.program_details

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fitin.R
import com.example.fitin.databinding.FragmentProgramDetailsBinding

class ProgramDetailsFragment : Fragment() {

    private var _binding:FragmentProgramDetailsBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ProgramDetailsFragment()
    }

    private val viewModel: ProgramDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgramDetailsBinding.inflate(inflater,container,false)

        binding.buyNow.setOnClickListener {
            findNavController().navigate(R.id.purchaseFragment)
        }

        return binding.root
    }



}