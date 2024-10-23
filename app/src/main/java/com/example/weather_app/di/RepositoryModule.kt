package com.example.weather_app.di

import com.example.weather_app.Data.Location.DefaultLocationTracker
import com.example.weather_app.Data.Repository.WeatherRepositoryImpl
import com.example.weather_app.Domain.Location.LocationTracker
import com.example.weather_app.Domain.Repository.Weather_Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl): Weather_Repository
}