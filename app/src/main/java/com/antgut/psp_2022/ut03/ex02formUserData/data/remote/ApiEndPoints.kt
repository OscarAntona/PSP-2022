package com.antgut.psp_2022.ut03.ex02formUserData.data.remote


import com.antgut.psp_2022.ut03.ex02formUserData.data.remote.models.UserApiModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoint {

    @GET("users")
    fun getUsers(): retrofit2.Call<List<UserApiModel>>

    @GET("users/{id}")
    fun getUser(@Path("id")id:Int): retrofit2.Call<UserApiModel>

}