package com.project.kambista.app.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.project.kambista.R
import com.project.kambista.app.main.MainActivity
import com.project.kambista.databinding.ActivityLoginBinding
import com.project.kambista.utils.EventObserver
import com.project.kambista.utils.toast

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = LoginViewModel.Factory(application)
        viewModel = ViewModelProvider(viewModelStore, factory).get(LoginViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        initViewModel()

    }

    private fun initViewModel() {

        viewModel.apply {

            errorMessage.observe(this@LoginActivity, EventObserver {

                toast(it)

            })

            openMainActivity.observe(this@LoginActivity, EventObserver {

                MainActivity.startActivity(this@LoginActivity, it)
                this@LoginActivity.finish()

            })

        }

    }

}