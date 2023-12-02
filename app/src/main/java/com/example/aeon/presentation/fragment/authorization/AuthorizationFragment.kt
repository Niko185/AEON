package com.example.aeon.presentation.fragment.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager.BackStackEntry
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.aeon.R
import com.example.aeon.databinding.FragmentAuthorizationBinding
import com.example.aeon.domain.models.auth.Credential
import com.example.aeon.domain.models.payment.Payment
import dagger.hilt.android.AndroidEntryPoint
import org.jetbrains.annotations.NotNull

@AndroidEntryPoint
class AuthorizationFragment : Fragment() {
    private lateinit var binding: FragmentAuthorizationBinding
    private val authorizationViewModel: AuthorizationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthorizationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickSignIn()
    }

    private fun getToken(credential: Credential) {
        if(credential.login == "demo" && credential.password == "12345") {
            authorizationViewModel.getAuthToken(credential)
        } else Toast.makeText(requireContext(), "User not found", Toast.LENGTH_SHORT).show()
    }

    private fun getList() {
        authorizationViewModel.paymentList.observe(viewLifecycleOwner) {
            navigate(it)
        }
    }

    private fun onClickSignIn() {
        binding.buttonSignIn.setOnClickListener {
            getToken(getCredential())
            getList()
        }
    }

    private fun getCredential(): Credential {
        return Credential(
            login = binding.edLogin.text.toString(),
            password = binding.edPassword.text.toString()
        )
    }

    private fun navigate(paymentList: List<Payment>) {
        val navController = findNavController()
        val bundle = bundleOf("paymentList" to paymentList)
        navController.popBackStack(R.id.authorizationFragment, true)
        navController.navigate(R.id.paymentFragment, bundle)
    }
}