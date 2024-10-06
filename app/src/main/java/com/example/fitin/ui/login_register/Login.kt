package com.example.fitin.ui.login_register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.fitin.R
import com.example.fitin.databinding.FragmentLoginBinding

class Login : Fragment() {

    private var _binding:FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        val root = binding.root

        binding.apply {

            val controller = findNavController()

            login.setOnClickListener {

                val navOptions = NavOptions.Builder()
                    .setPopUpTo(R.id.login, true) // `true` makes it inclusive, removing the login fragment from the back stack
                    .build()

                controller.navigate(R.id.action_login_to_navigation_home, null, navOptions)

            }

            registerUser.setOnClickListener {
                controller.navigate(R.id.action_login_to_register)
            }

        }

        return root
    }
}