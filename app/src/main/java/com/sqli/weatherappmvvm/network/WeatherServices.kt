package com.sqli.weatherappmvvm.network

import com.sqli.weatherappmvvm.model.Data
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherServices {
    @GET("/weather?id={id}/&appid={apikey}")
    suspend fun getData(@Path("id") id: Int, @Path("apikey") apikey: String): List<Data>
}