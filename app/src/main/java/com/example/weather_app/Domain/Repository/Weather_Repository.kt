package com.example.weather_app.Domain.Repository

import com.example.weather_app.Domain.Util.Resource
import com.example.weather_app.Domain.Weather.WeatherInfo

interface Weather_Repository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>

}