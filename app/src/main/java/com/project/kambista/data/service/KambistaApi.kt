package com.project.kambista.data.service

import com.project.kambista.data.entity.UserResponse
import com.project.kambista.data.raw.UserRaw
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface KambistaApi {

    @POST("login")
    suspend fun login(@Body data: UserRaw): Response<UserRaw>

}