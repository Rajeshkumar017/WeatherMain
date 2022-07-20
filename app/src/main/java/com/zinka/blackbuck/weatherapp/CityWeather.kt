package com.zinka.blackbuck.weatherapp

data class CityWeather(
    val city: String,
    val weatherCondition: String,
    val humidity: String,
    val temparature: String,
    val windSpeed: String,
    val windDirection: String
)