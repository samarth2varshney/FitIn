package com.example.fitin.ui.login_register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.fitin.R
import com.example.fitin.databinding.FragmentLogin1Binding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Login : Fragment() {

    private var _binding:FragmentLogin1Binding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLogin1Binding.inflate(inflater,container,false)
        val root = binding.root

        lifecycleScope.launch {
            viewModel.toastEvent.collect { message ->
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            }
        }

        val navOptions = NavOptions.Builder()
            .setPopUpTo(R.id.login, true)
            .build()

        findNavController().navigate(R.id.action_login_to_navigation_home, null, navOptions)


        binding.apply {

            val controller = findNavController()

            viewModel.loginSuccess.observe(viewLifecycleOwner){
                if(it){
                    val navOptions = NavOptions.Builder()
                        .setPopUpTo(R.id.login, true)
                        .build()

                    controller.navigate(R.id.action_login_to_navigation_home, null, navOptions)
                }
            }

            login.setOnClickListener {

//                viewModel.login(binding.email.text.toString(),binding.password.text.toString())
                val navOptions = NavOptions.Builder()
                    .setPopUpTo(R.id.login, true)
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