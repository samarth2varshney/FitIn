package com.example.fitin.ui.login_register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fitin.R
import com.example.fitin.databinding.FragmentRegisterBinding
import com.example.fitin.domain.data.UserSignUpResponse
import dagger.hilt.android.AndroidEntryPoint

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

//                val navOptions = NavOptions.Builder()
//                    .setPopUpTo(R.id.register, true) // `true` makes it inclusive, removing the login fragment from the back stack
//                    .build()
//
//                controller.navigate(R.id.action_register_to_navigation_home, null, navOptions)

            }

        }

        return root
    }
}