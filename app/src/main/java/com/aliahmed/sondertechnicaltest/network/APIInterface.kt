package com.aliahmed.sondertechnicaltest.network

import com.aliahmed.sondertechnicaltest.model.PassengerBaseResponse
import com.aliahmed.sondertechnicaltest.model.Passenger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface APIInterface {

    @GET(URL.passenger)
    suspend fun getPassengerList(
        @Query("page") page: Int,
        @Query("size") size: Int = 10
    ): PassengerBaseResponse


    companion object {

        private const val BASE_URL = URL.BASE_URL

        operator fun invoke(): APIInterface = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().also { client ->
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                client.addInterceptor(logging)
            }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIInterface::class.java)
    }

}