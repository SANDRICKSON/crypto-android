package com.example.cryptoappxml.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoappxml.data.Crypto
import com.example.cryptoappxml.data.repository.CryptoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CryptoViewModel : ViewModel() {

    private val cryptoRepository = CryptoRepository()

    private val _cryptoFlow =
        MutableStateFlow<List<Crypto>>(emptyList())

    val cryptoFlow: StateFlow<List<Crypto>> = _cryptoFlow

    fun getCrypto() {

        viewModelScope.launch {

            try {

                val cryptoList = cryptoRepository.getCoins()

                _cryptoFlow.value = cryptoList

            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
    }
}