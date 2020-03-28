package com.sqli.weatherappmvvm.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sqli.weatherappmvvm.core.model.WeatherInformations
import java.util.ArrayList

class ForecastAdapter :
    RecyclerView.Adapter<ForecastViewHolder>() {

    private var list: ArrayList<WeatherInformations> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ForecastViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val weatherInformations: WeatherInformations = list[position]
        holder.bind(weatherInformations)
    }

    override fun getItemCount(): Int = list.size

    fun refresh(newList: ArrayList<WeatherInformations>){
        this.list.clear()
        this.list = newList
        notifyDataSetChanged()
    }

}

