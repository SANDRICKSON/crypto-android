package com.example.cryptoappxml.data.repository

import com.example.cryptoappxml.data.Crypto
import com.example.cryptoappxml.data.remote.RetrofitInstance

class CryptoRepository {

    suspend fun getCoins(): List<Crypto> {
        return RetrofitInstance.api.getCoins()
    }
}