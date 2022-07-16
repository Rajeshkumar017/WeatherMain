package com.zinka.blackbuck.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class WeatherDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_detail_activity)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)


        loadloactions()
    }

    private fun loadloactions() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://spring-weathermain.herokuapp.com/")
            .build()
            .create(AllLocationsAPI::class.java)
        val retrofitData = retrofitBuilder.getAllLocations()

        retrofitData.enqueue(object : Callback<List<CityWeather>?> {
            override fun onResponse(
                call: Call<List<CityWeather>?>,
                response: Response<List<CityWeather>?>
            ) {
                val responseBody = response.body()!!
                val myAdapter = CustomAdapter(responseBody)
                myAdapter.notifyDataSetChanged()
                val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
                recyclerview.adapter=myAdapter
            }

            override fun onFailure(call: Call<List<CityWeather>?>, t: Throwable) {
                Log.d("Error","on Failure"+t.message)
            }
        })
    }


}
