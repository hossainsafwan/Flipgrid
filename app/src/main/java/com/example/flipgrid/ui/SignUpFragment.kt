package com.example.flipgrid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.flipgrid.databinding.SignUpFragmentBinding
import com.example.flipgrid.models.User

/**
 * This is the fragment where the user inputs all their information
 */
class SignUpFragment : Fragment() {

    private var _binding: SignUpFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SignUpFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signUpFragmentSubmitButton.setOnClickListener {
            val firstName = binding.signUpFragmentFirstNameTextInputEditText.text.toString()
            val website = binding.signUpFragmentWebsiteTextInputEditText.text.toString()
            val email = binding.signUpFragmentEmailAddressTextInputEditText.text.toString()

            val user = User(firstName, website, email)
            val action = SignUpFragmentDirections.actionSignUpFragmentToConfirmationFragment(user)
            findNavController().navigate(action)
        }

    }
}