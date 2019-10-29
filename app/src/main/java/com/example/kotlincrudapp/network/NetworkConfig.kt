package com.example.kotlincrudapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {

    fun receivedInterceptor(): OkHttpClient{
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return okHttpClient
    }

    fun useRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://192.168.10.65/serverforkotlin/index.php/ServerApi/")
            .client(receivedInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun useServiceApi() = useRetrofit().create(APIService::class.java)

}