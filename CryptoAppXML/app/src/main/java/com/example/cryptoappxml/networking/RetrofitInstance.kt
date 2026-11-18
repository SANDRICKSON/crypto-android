package com.example.cryptoappxml.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.jvm.java

object RetrofitInstance {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.coinpaprika.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: CryptoApi = retrofit.create(CryptoApi::class.java)
}