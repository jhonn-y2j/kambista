package com.project.kambista.data.repository

import com.project.kambista.data.entity.UserResponse
import com.project.kambista.data.raw.UserRaw

interface LoginDataSource {

    suspend fun login(userRaw: UserRaw): UserRaw?

}