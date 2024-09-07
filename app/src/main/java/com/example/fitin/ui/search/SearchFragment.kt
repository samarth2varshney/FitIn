package com.example.fitin.ui.search

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.fitin.R
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

            controller.setOnLongPressListener { isActive ->

                if (isActive) {
                    val contentToBlur = view?.findViewById<View>(R.id.epoxy_recycler_view)
                    if (contentToBlur != null) {
                        applyBlur(contentToBlur, 50f)
                    }
                } else {
                    val contentToBlur = view?.findViewById<View>(R.id.epoxy_recycler_view)
                    if (contentToBlur != null) {
                        removeBlur(contentToBlur)
                    }
                }

                epoxyRecyclerView.setOnTouchListener { _, event ->
                    if (isActive && event.action == MotionEvent.ACTION_MOVE) {
                        true
                    } else {
                        false
                    }
                }
            }

            searchViewModel.searchList.observe(viewLifecycleOwner) {
                controller.setData(it)
            }

            return root
        }

        fun getEpoxyRecyclerView(): EpoxyRecyclerView? {
            return _binding?.epoxyRecyclerView
        }
    }

    private fun applyBlur(view: View, radius: Float) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val blurEffect = RenderEffect.createBlurEffect(radius, radius, Shader.TileMode.CLAMP)
            view.setRenderEffect(blurEffect)
        }
    }

    private fun removeBlur(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            view.setRenderEffect(null)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}