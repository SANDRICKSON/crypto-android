package com.example.cryptoappxml.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoappxml.databinding.ActivityCryptoBinding
import kotlinx.coroutines.launch

class CryptoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCryptoBinding.inflate(layoutInflater)
    }

    private val cryptoAdapter = CryptoAdapter()

    private val viewModel: CryptoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(binding.root)

        setupRecyclerView()
        observeCrypto()

        viewModel.getCrypto()
    }

    private fun setupRecyclerView() {

        binding.cryptoRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@CryptoActivity)
            adapter = cryptoAdapter
        }
    }

    private fun observeCrypto() {

        lifecycleScope.launch {

            viewModel.cryptoFlow.collect { cryptoList ->

                cryptoAdapter.submitList(cryptoList)
            }
        }
    }
}