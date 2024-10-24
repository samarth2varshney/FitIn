package com.example.fitin.ui.Chat.messaging

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitin.R
import com.example.fitin.data.remote.Message
import com.example.fitin.databinding.FragmentMessagingBinding


class MessagingFragment : Fragment() {

    private var _binding:FragmentMessagingBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMessagingBinding.inflate(layoutInflater,container,false)

        val controller = MessageItemEpoxyController()

        binding.epoxyRecyclerView.setController(controller)

        val messages = listOf(
            Message("Hello!", isSent = false),
            Message("Hi, how are you?", isSent = true),
            Message("I'm doing well, thanks!", isSent = false),
            Message("Great to hear!", isSent = true),
            Message("How was you trip", isSent = true),
            Message("Great we had a lot of fun", isSent = false)
        )

        controller.setData(messages)

        return binding.root
    }

}