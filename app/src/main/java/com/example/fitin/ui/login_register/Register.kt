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
import com.example.fitin.databinding.FragmentRegisterBinding
import com.example.fitin.domain.data.UserSignUpResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Register : Fragment() {

    private var _binding:FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RegisterViewModel by viewModels()

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
                    val navOptions = NavOptions.Builder()
                    .setPopUpTo(R.id.register, true)
                    .build()
                    controller.navigate(R.id.action_register_to_navigation_home, null, navOptions)
                }
            }

        }

        return root
    }
}