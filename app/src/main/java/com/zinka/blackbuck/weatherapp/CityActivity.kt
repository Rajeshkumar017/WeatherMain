package com.zinka.blackbuck.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class CityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_activity)
        val changeLocationBtn: Button = findViewById(R.id.button2);
        changeLocationBtn.setOnClickListener {
            val intent = Intent(this, WeatherDetailsActivity::class.java);
            startActivity(intent);
        }
        val city = intent.getStringExtra("City")
        if (city != null) {
            loadCity(city)
        }
    }

    private fun loadCity(city:String) {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://spring-weathermain.herokuapp.com/")
            .build()
            .create(CityApiInterface::class.java)

        val retrofitData=retrofitBuilder.getCityWeather(city)

        retrofitData.enqueue(object : Callback<CityWeather?> {
            override fun onResponse(call: Call<CityWeather?>, response: Response<CityWeather?>) {
                    val responseBody = response.body()!!
                    findViewById<TextView>(R.id.cityname).text=responseBody.cityname
                    findViewById<TextView>(R.id.temperature).text=responseBody.temperature
                    findViewById<TextView>(R.id.humidity).text=responseBody.humidity
                    findViewById<TextView>(R.id.windSpeed).text=responseBody.windSpeed
                    findViewById<TextView>(R.id.windDirection).text=responseBody.winddirection
                    findViewById<TextView>(R.id.condition).text=responseBody.condition
            }

            override fun onFailure(call: Call<CityWeather?>, t: Throwable) {
                    Log.d("Error","On failure" + t.message);
            }
        })
    }
}
