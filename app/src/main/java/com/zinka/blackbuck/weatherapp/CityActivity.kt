package com.zinka.blackbuck.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_activity)
        val changeLocationBtn: Button = findViewById(R.id.button2);
        changeLocationBtn.setOnClickListener {
            val intent = Intent(this, WeatherDetailsActivity::class.java);
            startActivity(intent);
        }
    }
}