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
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.login_signup_domain.UserSignUpResponse
import com.example.presentation.databinding.FragmentSignupBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignupFragment : Fragment() {

    private var _binding:FragmentSignupBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SignupViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSignupBinding.inflate(inflater,container,false)

        binding.apply {

            loginUser.setOnClickListener {
                val request = NavDeepLinkRequest.Builder
                    .fromUri("android-app://example.fitin.app/login".toUri())
                    .build()
                findNavController().navigate(request)
            }

            lifecycleScope.launch {
                viewModel.toastEvent.collect { message ->
                    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
                }
            }

            register.setOnClickListener {

                viewModel.signUp(
                    UserSignUpResponse.User(
                        "",
                        username = name.text.toString(),
                        email = email.text.toString(),
                        password = password.text.toString(),
                        "",
                        "user",
                        mobilenumber = number.text.toString(),
                        gender = gender.text.toString(),
                        dob = dob.text.toString()
                    ))

            }

            viewModel.signUpSuccess.observe(viewLifecycleOwner){
                if(it){
                    val request = NavDeepLinkRequest.Builder
                        .fromUri("android-app://example.fitin.app/navigation_home".toUri())
                        .build()
                    findNavController().navigate(request)
                }
            }

        }

        return binding.root
    }
}