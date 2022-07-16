package com.zinka.blackbuck.weatherapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CityApiInterface {

    @GET("/locations/{city}")
    fun getCityWeather(@Path("city") city: String) : Call<CityWeather>
}