package com.example.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.chat.data.remote.ChatItem
import com.example.chat.presentation.ChatItemEpoxyController
import com.example.chat.presentation.ChatViewModel
import com.example.presentation.R
import com.example.presentation.messaging.MessagingFragment
import com.example.util.Data.img1
import com.example.util.Data.img2
import com.example.util.Data.img3
import com.example.util.Data.img4

class ChatFragment : Fragment() {

    companion object {
        fun newInstance() = ChatFragment()
    }

    private val viewModel: ChatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_chat, container, false)

        val epoxyRecyclerView = rootView.findViewById<EpoxyRecyclerView>(R.id.epoxy_recycler_view)

        val controller = ChatItemEpoxyController(callback = {
             openMessagingFragment()
        })

        epoxyRecyclerView.post {
            epoxyRecyclerView.setController(controller)
        }

        controller.setData(
            listOf(
                ChatItem(img1, "samarth"),
                ChatItem(img2, "Kartik"),
                ChatItem(img3, "suraj"),
                ChatItem(img4, "srishti"),
                ChatItem(img1, "shreya"),
                ChatItem(img2, "Vaibhav"),
            )
        )

        return rootView
    }

    private fun openMessagingFragment() {
        val childFragment = MessagingFragment()
        val fragmentContainer = view?.findViewById<View>(R.id.fragment_container)
        fragmentContainer?.visibility = View.VISIBLE
        childFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, childFragment)
            .addToBackStack(null)
            .commit()
    }
}