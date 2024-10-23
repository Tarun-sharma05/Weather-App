package com.example.weather_app.Domain.Weather

data class WeatherInfo (
    val weatherDataPerDay: Map<Int, List<WeatherData>>,
    val currentWeatherData: WeatherData?

)