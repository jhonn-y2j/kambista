package com.project.kambista.app.login

import android.app.Application
import androidx.lifecycle.*
import com.project.kambista.app.Injection
import com.project.kambista.data.raw.UserRaw
import com.project.kambista.utils.Event
import kotlinx.coroutines.launch

class LoginViewModel(
        application: Application
): AndroidViewModel(application) {

    private val repository = Injection.provideLoginRepository()
    val input = MutableLiveData<String>()
    val pass = MutableLiveData<String>()
    val errorMessage = MutableLiveData<Event<String>>()
    val openMainActivity = MutableLiveData<Event<UserRaw>>()

    fun login() {

        viewModelScope.launch {

            try {

                val email = input.value ?: ""
                val password = pass.value ?: ""

                if (email.isEmpty()) {
                    errorMessage.value = Event("Ingrese su correo.")
                    return@launch
                }

                if (password.isEmpty()) {
                    errorMessage.value = Event("Ingrese su contraseña")
                    return@launch
                }

                val credential = UserRaw(email, password)
                val data = repository.login(credential)

                if (data != null) {
                    errorMessage.value = Event("Inicio sesión correctamente.")
                    openMainActivity.value = Event(data)
                } else {
                    errorMessage.value = Event("Correo o contraseña inválida.")
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

    }

    class Factory(
            private val application: Application
    ) : ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                with(modelClass) {
                    when {
                        isAssignableFrom(LoginViewModel::class.java) ->
                            LoginViewModel(
                                    application,
                            )
                        else -> throw IllegalArgumentException("Unknown ViewModel")
                    }
                } as T
    }

}