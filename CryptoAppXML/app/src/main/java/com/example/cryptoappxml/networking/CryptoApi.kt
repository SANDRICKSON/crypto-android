package com.example.cryptoappxml.data.remote

import com.example.cryptoappxml.data.Crypto
import retrofit2.http.GET

interface CryptoApi {

    @GET("v1/coins")
    suspend fun getCoins(): List<Crypto>
}