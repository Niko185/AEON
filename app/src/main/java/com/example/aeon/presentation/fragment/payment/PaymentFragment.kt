package com.example.aeon.presentation.fragment.payment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aeon.databinding.FragmentPaymentBinding
import com.example.aeon.domain.models.payment.Payment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaymentFragment : Fragment() {
    private lateinit var binding: FragmentPaymentBinding
    private lateinit var paymentAdapter: PaymentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPaymentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        getList()
    }

    private fun initRecyclerView() = with(binding)  {
        paymentAdapter = PaymentAdapter()
        rcViewPayments.adapter = paymentAdapter
    }

   private fun getList() {
       arguments?.getSerializable("paymentList")?.let {
            val list = it as List<Payment>
            paymentAdapter.submitList(list)
        }
    }
}