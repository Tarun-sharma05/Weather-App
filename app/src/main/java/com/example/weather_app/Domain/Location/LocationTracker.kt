package com.example.weather_app.Domain.Location

import android.location.Location

interface LocationTracker {
      suspend fun getCurrentLocation(): Location?

}