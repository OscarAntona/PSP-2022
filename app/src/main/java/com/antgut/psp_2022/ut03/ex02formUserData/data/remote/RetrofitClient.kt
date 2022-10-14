package com.antgut.psp_2022.ut03.ex02formUserData.data.remote
import com.antgut.psp_2022.ut03.ex02formUserData.data.remote.models.UserApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient  {
    private val urlEndPoints = "https://jsonplaceholder.typicode.com/"
    private var apiEndPoints: ApiEndPoint


    init{
        apiEndPoints = buildApiEndPoints()
    }

    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoints)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildApiEndPoints(): ApiEndPoint {
        return buildClient().create(ApiEndPoint::class.java)
    }

    fun getUsers(): List<UserApiModel> {
        val users = apiEndPoints.getUsers()
        val response = users.execute()
        return if(response.isSuccessful){
            response.body() ?: emptyList()
        }else{
            emptyList()
        }
    }

    fun getUser(id:Int): UserApiModel?{
        val user = apiEndPoints.getUser(id)
        val response = user.execute()
        return if(response.isSuccessful){
            response.body()
        }else{
            null
        }
    }
}
