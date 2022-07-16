package com.zinka.blackbuck.weatherapp

import retrofit2.Call
import retrofit2.http.GET

interface CityApiInterface {

    @GET("/locations/")
    fun getCityWeather() : Call<CityWeather>
}