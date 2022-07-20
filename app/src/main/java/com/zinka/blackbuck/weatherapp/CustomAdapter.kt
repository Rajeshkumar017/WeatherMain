package com.zinka.blackbuck.weatherapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
// todo - pass click callback in contructor. and then use it when user clicks on particular location.

class CustomAdapter(val allLocationslist : List<CityWeather>, val onClickCallback :  (CityWeather) -> Unit) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.city_cardview_activity,parent,false)
        return  ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cityName.text=allLocationslist[position].city
        holder.itemView.setOnClickListener { v ->
            onClickCallback.invoke(allLocationslist[position])
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
