package com.project.kambista.app

import com.project.kambista.data.repository.LoginRepository

object Injection {

    fun provideLoginRepository(): LoginRepository = LoginRepository.getInstance()

}