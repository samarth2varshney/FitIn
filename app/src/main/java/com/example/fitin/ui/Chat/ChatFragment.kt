package com.example.fitin.ui.Chat

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.fitin.R
import com.example.fitin.data.Data.img1
import com.example.fitin.data.Data.img2
import com.example.fitin.data.Data.img3
import com.example.fitin.data.Data.img4
import com.example.fitin.data.remote.ChatItem
import com.example.fitin.databinding.FragmentChat1Binding

class ChatFragment : Fragment() {

    private var _binding:FragmentChat1Binding? = null
    private val binding get() = _binding!!

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

        _binding = FragmentChat1Binding.inflate(layoutInflater,container,false)

        val controller = ChatItemEpoxyController(callback = {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.chatFragment,false)
                .build()

            val controller = findNavController()

            controller.navigate(R.id.action_chatFragment_to_messagingFragment,null,navOptions)
        })

        binding.epoxyRecyclerView.post {
            binding.epoxyRecyclerView.setController(controller)
        }

        controller.setData(listOf(
            ChatItem(img1,"samarth"),
            ChatItem(img2,"Kartik"),
            ChatItem(img3,"suraj"),
            ChatItem(img4,"srishti"),
            ChatItem(img1,"shreya"),
            ChatItem(img2,"Vaibhav"),
        ))

        return binding.root
    }
}