package com.sqli.weatherappmvvm.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sqli.weatherappmvvm.R
import com.sqli.weatherappmvvm.core.model.WeatherInformations
import com.sqli.weatherappmvvm.helper.Helpers.getDateTime

class ForecastViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_day_forecast, parent, false)) {
    private var tvDateDay: TextView? = null
    private var tvTempMaxMin: TextView? = null
    private var tvMainWeather: TextView? = null

    init {
        tvDateDay = itemView.findViewById(R.id.tvDateDay)
        tvTempMaxMin = itemView.findViewById(R.id.tvTempMaxMin)
        tvMainWeather = itemView.findViewById(R.id.tvMainWeather)
    }

    fun bind(weather: WeatherInformations) {
        tvDateDay?.text = getDateTime(weather.dt)
        tvTempMaxMin?.text = "${weather.temp.min.toInt()} - ${weather.temp.max.toInt()}"
        tvMainWeather?.text = weather.weather[0].main

    }

}