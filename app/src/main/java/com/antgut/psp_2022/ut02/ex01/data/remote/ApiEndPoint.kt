package com.antgut.psp_2022.ut02.ex01.data.remote

import com.antgut.psp_2022.ut02.ex01.data.remote.models.UsersApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoint {
    @GET("users")
    fun getUsers(): Call<List<UsersApiModel>>

    @GET("users/{userId}")
    fun getUser(@Path("userId") userId:Int): Call<UsersApiModel>

}