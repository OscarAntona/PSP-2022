package com.antgut.psp_2022.ut02.ex01.data.remote

import com.antgut.psp_2022.ut02.ex01.data.remote.models.UsersApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroFitApiClient {

    private val urlEndPoint = "https://jsonplaceholder.typicode.com/"
    private var apiEndPoints: ApiEndPoint

    init {
        apiEndPoints = buildApiEndPoints()
    }

    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildApiEndPoints(): ApiEndPoint {
        return buildClient().create(ApiEndPoint::class.java)
    }

    fun getUsers(): List<UsersApiModel>?{
        val callUsers = apiEndPoints.getUsers()
        val response = callUsers.execute()
        return if(response.isSuccessful){
            val users = response.body()
            users ?: emptyList()
        }else{
            emptyList()
        }
    }

    fun getUser(userId:Int): UsersApiModel?{
        val callUser = apiEndPoints.getUser(userId)
        val response = callUser.execute()
        return if(response.isSuccessful){
            response.body()
        }else{
            null
        }
    }

}