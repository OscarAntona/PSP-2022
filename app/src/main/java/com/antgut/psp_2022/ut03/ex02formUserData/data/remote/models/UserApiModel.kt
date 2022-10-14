package com.antgut.psp_2022.ut03.ex02formUserData.data.remote.models

data class UserApiModel(val id: Int, val name: String, val username: String, val email: String, val address: AddressApiModel, val phone: String, val website: String, val company: CompanyApiModel)
