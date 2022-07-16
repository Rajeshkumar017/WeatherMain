package com.zinka.blackbuck.weatherapp

import retrofit2.Call
import retrofit2.http.GET

interface AllLocationsAPI {

    @GET("/locationsweather")
    fun getAllLocations():Call<List<CityWeather>>
}