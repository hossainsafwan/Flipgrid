package com.example.flipgrid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.flipgrid.databinding.ConfirmationFragmentBinding

/**
 * This is the fragment which displays the users information
 */
class ConfirmationFragment : Fragment() {
    private var _binding: ConfirmationFragmentBinding? = null
    private val binding get() = _binding!!

    val args: ConfirmationFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ConfirmationFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = args.user
        binding.apply {
            confirmationFragmentTitle.text = "Hello, ${user.firstName.replaceFirstChar { it.uppercase() }}!"
            confirmationFragmentFirstName.text = user.firstName
            confirmationFragmentWebsite.text = user.website
            confirmationFragmentEmail.text = user.emailAddress
        }
    }
}