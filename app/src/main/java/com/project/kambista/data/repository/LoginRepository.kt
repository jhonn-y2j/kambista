package com.project.kambista.data.repository

import com.project.kambista.data.raw.UserRaw
import com.project.kambista.data.service.ApiClient

class LoginRepository : LoginDataSource {

    companion object {
        private var INSTANCE: LoginRepository? = null
        @JvmStatic fun getInstance() = INSTANCE ?: LoginRepository().apply { INSTANCE = this }
    }

    override suspend fun login(userRaw: UserRaw): UserRaw? {
        val response = ApiClient.getKambistaApi().login(userRaw)
        if (!response.isSuccessful) {

            if (response.code() == 404) {

                if (userRaw.user == "prueba@kambista.com" && userRaw.password == "123456") {
                    return userRaw
                } else {
                    return null
                }

            }

            return null

        }
        return response.body()
    }

}