package com.veen.baseproject.service.api

import com.veen.baseproject.utils.CommonUtils.BaseUrl
import com.veen.baseproject.utils.CommonUtils.CONNECT_TIMEOUT
import com.veen.baseproject.utils.CommonUtils.READ_TIMEOUT
import com.veen.baseproject.utils.CommonUtils.WRITE_TIMEOUT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {
    var token = ""
    val instance: ApiInterface? = getapi()?.create(ApiInterface::class.java)

    /*Retrofit private function*/
    private fun getapi(): Retrofit? {
        return Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkhttpClientBuilder().build())
            .build()
    }

    private fun getOkhttpClientBuilder(): OkHttpClient.Builder {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
        okHttpClientBuilder.writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
        okHttpClientBuilder.addInterceptor(loggingInterceptor)
        /* okHttpClientBuilder.addInterceptor { chain ->
             val request = chain.request().newBuilder().addHeader("Authorization", "Bearer $token").build()
             chain.proceed(request)
         }*/

        return okHttpClientBuilder
    }
}