package com.sqli.weatherappmvvm.core.network

import WeatherModel
import com.sqli.weatherappmvvm.core.model.forecast
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city_name: String,
        @Query("appid") apikey: String,
        @Query("units") units: String
    ): WeatherModel

    @GET("forecast/daily")
    suspend fun getForecast(
        @Query("q") city_name: String,
        @Query("cnt") cnt: Int,
        @Query("appid") apikey: String,
        @Query("units") units: String
    ): forecast
}