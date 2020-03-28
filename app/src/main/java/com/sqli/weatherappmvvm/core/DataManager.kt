package com.sqli.weatherappmvvm.core

import WeatherModel
import com.sqli.weatherappmvvm.core.model.forecast
import com.sqli.weatherappmvvm.core.network.RetrofitInstance
import com.sqli.weatherappmvvm.core.network.ApiService
import com.sqli.weatherappmvvm.helper.API_KEY

class DataManager {

    var weatherModel: WeatherModel? = null
    var forecast: forecast? = null

    suspend fun getWeather(city:String, metric:String): WeatherModel {
        if (weatherModel == null) {
            val service = RetrofitInstance.retrofit.create(ApiService::class.java)
            weatherModel = service.getWeather(city, API_KEY, metric)
        }
        return weatherModel!!
    }

    suspend fun getForecastWeather(city:String, cnt:Int): forecast {
        if (forecast == null) {
            val service = RetrofitInstance.retrofit.create(ApiService::class.java)
            forecast = service.getForecast(city, cnt, API_KEY, "metric")
        }
        return forecast!!
    }

}