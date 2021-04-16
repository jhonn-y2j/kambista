package com.project.kambista.app.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.project.kambista.R
import com.project.kambista.data.raw.UserRaw

class MainActivity: AppCompatActivity() {

    companion object {

        fun startActivity(activity: Activity, userRaw: UserRaw) {
            val intent = Intent(activity.applicationContext, MainActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("user", userRaw)
            intent.putExtras(bundle)
            activity.startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intent?.let {

            val user = it.getSerializableExtra("user") as UserRaw
            val textEmail = findViewById<TextView>(R.id.text_email)
            textEmail.text = user.user

        }

    }

}