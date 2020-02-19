package com.sqli.weatherappmvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class Data(
    @ColumnInfo(name = "base") val base: String,
    @ColumnInfo(name = "clouds") val clouds: Clouds,
    @ColumnInfo(name = "cod") val cod: Int,
    @ColumnInfo(name = "coord") val coord: Coord,
    @ColumnInfo(name = "dt") val dt: Int,
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "main") val main: Main,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "sys") val sys: Sys,
    @ColumnInfo(name = "visibility") val visibility: Int,
    @ColumnInfo(name = "weather") val weather: List<Weather>,
    @ColumnInfo(name = "wind") val wind: Wind
)