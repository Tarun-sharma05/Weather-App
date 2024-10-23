package com.example.weather_app.Data.Remote

import com.squareup.moshi.Json

data class WeatherDto (
      @field:Json(name = "hourly")
     val weatherData: WeatherDataDto
)