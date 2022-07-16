package com.zinka.blackbuck.weatherapp

import retrofit2.Call
import retrofit2.http.GET

interface LocationsAPIinterface {

    @GET("locations")
    fun getLocations():Call<Locations>
}