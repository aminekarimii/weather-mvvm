package com.sqli.weatherappmvvm.ui.main

import WeatherModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sqli.weatherappmvvm.core.DataManager
import com.sqli.weatherappmvvm.core.model.forecast
import com.sqli.weatherappmvvm.helper.CITY_NAME
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val dataManager: DataManager =
        DataManager()

    private val _posts: MutableLiveData<WeatherModel> = MutableLiveData<WeatherModel>()

    val posts: LiveData<WeatherModel> get() = _posts

    private val _forecast: MutableLiveData<forecast> = MutableLiveData<forecast>()

    val forecast: LiveData<forecast> get() = _forecast

    init {
        viewModelScope.launch {
            getWeather()
            getForecastWeather()
        }
    }

    private suspend fun getWeather() {
        val pts: WeatherModel = dataManager.getWeather(CITY_NAME, "metric")
        _posts.postValue(pts)
    }

    private suspend fun getForecastWeather() {
        val data: forecast = dataManager.getForecastWeather(CITY_NAME, 6)
        _forecast.postValue(data)
    }
}
