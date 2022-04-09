package com.example.flipgrid.ui

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.flipgrid.R
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
            val firstName = user.firstName.replaceFirstChar { it.uppercase() }
            val websiteURL = SpannableString(user.website).apply {
                this.setSpan(UnderlineSpan(), 0, user.website.length, 0)
                this.setSpan(StyleSpan(Typeface.BOLD), 0, user.website.length, 0)
                val color = ContextCompat.getColor(requireContext(),R.color.blue_sky)
                this.setSpan(ForegroundColorSpan(color), 0, user.website.length, 0)
            }
            confirmationFragmentTitle.text =
                resources.getString(R.string.ui_confirmation_fragment_greeting, firstName)
            confirmationFragmentFirstName.text = firstName
            confirmationFragmentWebsite.text = websiteURL
            confirmationFragmentEmail.text = user.emailAddress
        }
    }
}