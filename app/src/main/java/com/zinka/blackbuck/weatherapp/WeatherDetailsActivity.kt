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


class WeatherDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_detail_activity)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)

        val adapter = CustomAdapter(resources.getStringArray(R.array.cities))
        recyclerview.adapter = adapter
//        loadloactions()
    }
//
//    private fun loadloactions(){
//        val queue = Volley.newRequestQueue(this)
//        val url = "http://10.0.2.2:8080/locations"

// Request a string response from the provided URL.
//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            { response ->
//                // Display the first 500 characters of the response string.
//                Log.d("Success", response.substring(0, 500))
//            },
//            {
//                Log.d("error", it.localizedMessage)
//            },
//        )
//        val jsonArrayRequest = JsonArrayRequest(
//            Request.Method.GET, url,null,
//            { response ->
//                // Display the first 500 characters of the response string.
//               Log.d("Success",response.toString());
//            },
//            {
//                Log.d("error", it.localizedMessage)
//            },
//        )
//        queue.add(jsonArrayRequest)
    }

}