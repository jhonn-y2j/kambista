package com.project.kambista.utils

import com.project.kambista.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

private const val TAG = "Retrofit"

object RetrofitUtil {

    @Suppress("ConstantConditionIf")
    @JvmStatic
    fun getBasicClientInterceptor(): OkHttpClient {

        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            builder.interceptors().add(logging)
        }
        return builder.build()

    }

}