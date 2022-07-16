package com.zinka.blackbuck.weatherapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val allLocationslist : List<CityWeather>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.city_cardview_activity,parent,false)
        return  ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cityName.text=allLocationslist[position].cityname
        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, CityActivity::class.java)
            intent.putExtra("City",holder.cityName.text)
            intent.putExtra("Temperature",allLocationslist[position].temperature)
            intent.putExtra("Humidity",allLocationslist[position].humidity)
            intent.putExtra("WindSpeed",allLocationslist[position].windSpeed)
            intent.putExtra("WindDirection",allLocationslist[position].winddirection)
            intent.putExtra("Condition",allLocationslist[position].condition)
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return allLocationslist.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var cityName : TextView
        init {
            cityName=itemView.findViewById(R.id.city)

        }
    }
}
