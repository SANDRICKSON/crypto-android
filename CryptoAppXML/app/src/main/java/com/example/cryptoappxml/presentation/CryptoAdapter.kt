package com.example.cryptoappxml.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoappxml.data.Crypto
import com.example.cryptoappxml.databinding.ItemCryptoBinding

class CryptoAdapter : RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    private var cryptoList = emptyList<Crypto>()

    fun submitList(list: List<Crypto>) {
        cryptoList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CryptoViewHolder {

        val binding = ItemCryptoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CryptoViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CryptoViewHolder,
        position: Int
    ) {
        holder.bind(cryptoList[position])
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }

    class CryptoViewHolder(
        private val binding: ItemCryptoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(crypto: Crypto) = with(binding) {

            rankTextView.text = crypto.rank.toString()
            idTextView.text = crypto.name
            symbolTextView.text = crypto.symbol

            isActiveTextView.text =
                if (crypto.isActive) {
                    "Active"
                } else {
                    "Inactive"
                }
        }
    }
}