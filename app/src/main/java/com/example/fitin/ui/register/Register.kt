package com.example.fitin.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.fitin.R
import com.example.fitin.databinding.FragmentRegisterBinding

class Register : Fragment() {

    private var _binding:FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRegisterBinding.inflate(inflater,container,false)
        val root = binding.root

        binding.apply {

            val controller = findNavController()

            loginUser.setOnClickListener {
                controller.navigate(R.id.action_register_to_login)
            }

            register.setOnClickListener {

                val navOptions = NavOptions.Builder()
                    .setPopUpTo(R.id.register, true) // `true` makes it inclusive, removing the login fragment from the back stack
                    .build()

                controller.navigate(R.id.action_register_to_navigation_home, null, navOptions)

            }

        }

        return root
    }
}