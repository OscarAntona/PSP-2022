package com.antgut.psp_2022.ut03.ex02formUserData.data.remote
import com.antgut.psp_2022.ut03.ex02formUserData.data.remote.models.UserApiModel

class UserRepository(val remoteSource: RetrofitClient) {

    fun getUsers(): List<UserApiModel> {
        return remoteSource.getUsers()
    }

    fun findUserById(userId: Int): UserApiModel? {
        return remoteSource.getUser(userId)
    }
}




