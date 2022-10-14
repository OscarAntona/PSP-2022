package com.antgut.psp_2022.ut03.ex02formUserData.data.remote.models


data class AddressApiModel(val street: String, val suite: String, val city: String, val zipcode: String, val geo: GeoApiModel)
