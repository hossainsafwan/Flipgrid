package com.example.flipgrid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.flipgrid.R
import com.example.flipgrid.databinding.SignUpFragmentBinding
import com.example.flipgrid.models.User
import com.google.android.material.textfield.TextInputLayout

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
            // Retrieve the data set by the user
            val firstName = binding.signUpFragmentFirstNameTextInputEditText.text.toString()
            val website = binding.signUpFragmentWebsiteTextInputEditText.text.toString()
            val email = binding.signUpFragmentEmailAddressTextInputEditText.text.toString()
            val password = binding.signUpFragmentPasswordTextInputEditText.text.toString()

            // Check if email or password are set or not and response appropriately
            if (email.isEmpty() || password.isEmpty()) {
                if (email.isEmpty()) {
                    setError(
                        binding.signUpFragmentEmailAddressTextInputLayout,
                        resources.getString(R.string.ui_sign_up_fragment_error_description)
                    )
                }
                if (password.isEmpty()) {
                    setError(
                        binding.signUpFragmentPasswordTextInputLayout,
                        resources.getString(R.string.ui_sign_up_fragment_error_description)
                    )
                }
            } else {
                val user = User(firstName, website, email)
                val action =
                    SignUpFragmentDirections.actionSignUpFragmentToConfirmationFragment(user)
                findNavController().navigate(action)
            }
        }

        //Add text change listener to ensure the errors are removed if the user starts typing
        binding.signUpFragmentEmailAddressTextInputEditText.addTextChangedListener {
            setError(binding.signUpFragmentEmailAddressTextInputLayout, null)

        }

        binding.signUpFragmentPasswordTextInputEditText.addTextChangedListener {
            setError(binding.signUpFragmentPasswordTextInputLayout, null)
        }

    }

    /**
     * Set the error with the appropriate error message to the text input layouts if the error is enabled
     */
    private fun setError(layout: TextInputLayout, errorMessage: String?) {
        layout.apply {
            isErrorEnabled = errorMessage!=null
            error = errorMessage
        }
    }
}