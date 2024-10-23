package com.example.weather_app.Presentation

import com.example.weather_app.Domain.Weather.WeatherInfo

data class WeatherState (
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error:String? = null
)