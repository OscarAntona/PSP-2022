package com.antgut.psp_2022.ut02.ex01.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.antgut.psp_2022.ut02.ex01.data.remote.RetroFitApiClient

class Ut02Ex01Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread{
            val client = RetroFitApiClient()
            val users = client.getUsers()
            Log.d("@dev", "Users: $users")
        }.start()
    }

}