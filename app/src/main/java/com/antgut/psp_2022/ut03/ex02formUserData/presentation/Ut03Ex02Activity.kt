package com.antgut.psp_2022.ut03.ex02formUserData.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.antgut.psp_2022.ut03.ex02formUserData.data.remote.RetrofitClient
import com.antgut.psp_2022.ut03.ex02formUserData.data.remote.UserRepository
import com.antgut.psp_2022.ut03.ex02formUserData.data.remote.models.UserApiModel
import com.antgut.psp_2022.R

class Ut03Ex02Activity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex02)
Thread{
    init()
}.start()

    }

    fun init(){
        val usersRepository = UserRepository(RetrofitClient())
        var users = usersRepository.getUsers()
        Log.d("@dev", "----------------------------------------------------------------------------")
        Log.d("@dev", "Lista")
        showUsers(users)
        Log.d("@dev", "----------------------------------------------------------------------------")
        Log.d("@dev", "user con id 5")
        val singleUser = usersRepository.findUserById(5)
        Log.d("@dev", singleUser.toString())
        Log.d("@dev", "----------------------------------------------------------------------------")
        Log.d("@dev", "mostrar lista")
        showUsers(users)
        Log.d("@dev", "----------------------------------------------------------------------------")

    }

    fun showUsers(lista: List<UserApiModel>?){
        lista?.forEach {
            Log.d("@dev", it.toString())
        }
    }
}