package com.example.weather_app.Presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather_app.Domain.Location.LocationTracker
import com.example.weather_app.Domain.Repository.Weather_Repository
import com.example.weather_app.Domain.Util.Resource
import com.example.weather_app.di.RepositoryModule
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: Weather_Repository,
    private val locationTracker: LocationTracker
): ViewModel() {
      var state  by mutableStateOf(WeatherState())
          private set

    fun loadWeatherInfo(){
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            locationTracker.getCurrentLocation()?.let { location ->
                when(val result = repository.getWeatherData(location.latitude, location.longitude)) {
                    is Resource.Success -> {
                        state = state.copy(
                            weatherInfo = result.data,
                            isLoading = false,
                            error = null
                        )
                    }

                    is Resource.Error -> {
                        state = state.copy(
                            weatherInfo = null,
                            isLoading = false,
                            error = result.message
                        )
                     }
                  }
                } ?: kotlin.run {
                    state = state.copy(
                        isLoading = false,
                        error = "Couldn't retrieve to location. Make sure to grant permission and enable GPS."
                    )
            }
        }
    }

}