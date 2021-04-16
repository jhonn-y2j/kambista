package com.project.kambista.data.service

import com.project.kambista.utils.RetrofitUtil
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    const val url = "https://api-qa.kambista.com"

    @JvmStatic fun getKambistaApi() : KambistaApi =
        Retrofit.Builder()
            .baseUrl(url)
            .client(RetrofitUtil.getBasicClientInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(KambistaApi::class.java)

}