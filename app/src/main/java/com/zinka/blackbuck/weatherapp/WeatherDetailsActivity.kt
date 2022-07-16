package com.zinka.blackbuck.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class WeatherDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_detail_activity)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)

        val adapter = CustomAdapter(resources.getStringArray(R.array.cities))
        recyclerview.adapter = adapter
        loadloactions()
    }

    private fun loadloactions() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://spring-weathermain.herokuapp.com/")
            .build()
            .create(LocationsAPIinterface::class.java)

        val retrofitData = retrofitBuilder.getLocations()

        retrofitData.enqueue(object : Callback<Locations?> {
            override fun onResponse(call: Call<Locations?>, response: Response<Locations?>) {
                val responseBody = response.body()!!
                for(myData in responseBody){
                    Log.d("Success",myData)
                }
            }

            override fun onFailure(call: Call<Locations?>, t: Throwable) {
                Log.d("Error","on Failure"+t.message)
            }
        })
    }


}
