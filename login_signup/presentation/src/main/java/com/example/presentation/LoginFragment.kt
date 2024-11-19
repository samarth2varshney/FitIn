package com.example.presentation

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.net.toUri
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.example.presentation.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        val root = binding.root

        lifecycleScope.launch {
            viewModel.toastEvent.collect { message ->
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            }
        }

        binding.apply {

            viewModel.loginSuccess.observe(viewLifecycleOwner){
                if(it){
                    val request = NavDeepLinkRequest.Builder
                        .fromUri("android-app://example.fitin.app/navigation_home".toUri())
                        .build()
                    findNavController().navigate(request)
                }
            }

            login.setOnClickListener {
                viewModel.login(binding.email.text.toString(),binding.password.text.toString())
            }

            registerUser.setOnClickListener {
                val request = NavDeepLinkRequest.Builder
                    .fromUri("android-app://example.fitin.app/signup".toUri())
                    .build()
                findNavController().navigate(request)
            }

        }

        return root
    }
}