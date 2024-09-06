package com.example.fitin.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.fitin.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]

        binding.apply {

            val controller = SearchItemEpoxyController()

            epoxyRecyclerView.post {
                epoxyRecyclerView.setController(controller)
            }

            searchViewModel.searchList.observe(viewLifecycleOwner){
                controller.setData(it)
            }
        }

        return root
    }

    fun getEpoxyRecyclerView(): EpoxyRecyclerView? {
        return _binding?.epoxyRecyclerView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}