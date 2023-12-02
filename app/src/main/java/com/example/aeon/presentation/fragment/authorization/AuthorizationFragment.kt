package com.example.aeon.presentation.fragment.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.aeon.databinding.FragmentAuthorizationBinding
import com.example.aeon.domain.models.auth.Credential
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorizationFragment : Fragment() {
    private lateinit var binding: FragmentAuthorizationBinding
    private val authorizationViewModel: AuthorizationViewModel by viewModels()
    private val user = Credential(login = "demo", password = "12345")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthorizationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getToken()
        observerToken()
        getListPay()
    }

    private fun getToken(){
        binding.button.setOnClickListener {
            authorizationViewModel.getAuthToken(user)
        }
    }

    private fun getListPay(){
        binding.button2.setOnClickListener {
            authorizationViewModel.getPaymentList()
        }
    }

    private fun observerToken() {
        authorizationViewModel.token.observe(viewLifecycleOwner) {
            println(it)
        }
    }


}