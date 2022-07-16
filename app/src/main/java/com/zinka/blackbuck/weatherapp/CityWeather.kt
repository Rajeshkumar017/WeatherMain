package com.zinka.blackbuck.weatherapp

data class CityWeather(
    val cityname: String,
    val condition: String,
    val humidity: String,
    val temperature: String,
    val windSpeed: String,
    val winddirection: String
)