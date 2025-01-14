package com.example.weather_app.Domain.Weather

import java.time.LocalDateTime

data class WeatherData (
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: WeatherType
    )
