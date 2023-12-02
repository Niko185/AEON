package com.example.aeon.presentation.fragment.payment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.aeon.R
import com.example.aeon.databinding.ItemPaymentBinding
import com.example.aeon.domain.models.payment.Payment

class PaymentAdapter : ListAdapter<Payment, PaymentAdapter.ItemHolder>(ItemComparator()) {

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemPaymentBinding.bind(view)

        fun setData(payment: Payment) = with(binding) {
            tvId.text = "id: ${payment.id}"
            tvTitle.text = "title: ${payment.title}"

            if (payment.amount.isNullOrEmpty()) {
                tvAmount.visibility = View.GONE
            } else {
                tvAmount.text = "amount: ${payment.amount}"
                tvAmount.visibility = View.VISIBLE
            }

            if (payment.created.isNullOrEmpty() || payment.created == "null") {
                tvCreated.visibility = View.GONE
            } else {
                tvCreated.text = "created: ${payment.created}"
                tvCreated.visibility = View.VISIBLE
            }
        }


        companion object {
            fun create(parent: ViewGroup): ItemHolder {
                return ItemHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_payment, parent, false)
                )
            }
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<Payment>() {
        override fun areItemsTheSame(oldItem: Payment, newItem: Payment): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Payment, newItem: Payment): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        return holder.setData(getItem(position))
    }
}