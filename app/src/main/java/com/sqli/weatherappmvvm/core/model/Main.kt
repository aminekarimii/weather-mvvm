package com.sqli.weatherappmvvm.core.model

data class Main(
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
    val feels_like: Double,
    val temp_max: Double,
    val temp_min: Double
)