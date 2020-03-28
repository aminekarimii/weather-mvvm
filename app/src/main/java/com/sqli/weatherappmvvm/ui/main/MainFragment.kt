package com.sqli.weatherappmvvm.ui.main

import WeatherModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.sqli.weatherappmvvm.R
import com.sqli.weatherappmvvm.helper.Helpers.getFlag
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var forecastAdapter: ForecastAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        forecastAdapter = ForecastAdapter()
        val layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvForecastList.layoutManager = layoutManager
        rvForecastList.adapter = forecastAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java).apply {
            posts.observe(viewLifecycleOwner, Observer {
                showWeather(it)
            })
            forecast.observe(viewLifecycleOwner, Observer {
                forecastAdapter.refresh(it.list)
            })
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showWeather(data: WeatherModel) {
        //City
        city_textview.text = data.name
        tem_textview.text = data.main.temp.toInt().toString() + "˚"
        weather_main_textview.text = data.weather[0].main

        //min max temp
        max_tem_textview.text = data.main.temp_max.toInt().toString() + "˚"
        min_tem_textview.text = data.main.temp_min.toInt().toString() + "˚"

        //Feels Like
        feels_like_textview.text = data.main.feels_like.toInt().toString() + "˚"

        //Wind
        wind_textview.text = data.wind.speed.toString() + " mph"
        humidity_textview.text = data.main.humidity.toString() + "%"

        //Pressure
        pressure_textview.text = data.main.pressure.toString() + " hPa"

        //Clouds
        cloud_textview.text = data.clouds.all.toString() + " %"

        //Country flag
        Glide.with(this).load(getFlag(data.sys.country)).into(flag_imageview)
        //Temp icon
        Glide.with(this).load(R.drawable.ic_01d).into(icon_imageView)
    }

}
