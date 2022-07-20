package com.zinka.blackbuck.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LocationWeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.location_weather_activity)
        val changeLocationBtn: Button = findViewById(R.id.button2);
        changeLocationBtn.setOnClickListener {
            val intent = Intent(this, SelectLocationActivity::class.java);
            startActivity(intent);
        }
        findViewById<TextView>(R.id.cityname).text = intent.getStringExtra("City")
        findViewById<TextView>(R.id.temperature).text = intent.getStringExtra("Temperature")
        findViewById<TextView>(R.id.humidity).text = intent.getStringExtra("Humidity")
        findViewById<TextView>(R.id.windSpeed).text = intent.getStringExtra("WindSpeed")
        findViewById<TextView>(R.id.windDirection).text = intent.getStringExtra("WindDirection")
        findViewById<TextView>(R.id.condition).text = intent.getStringExtra("Condition")
    }
}


