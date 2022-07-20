package com.zinka.blackbuck.weatherapp

import retrofit2.Call
import retrofit2.http.GET

interface AllLocationsAPI {

    @GET("/all")
    fun getAllLocations():Call<List<CityWeather>>
}