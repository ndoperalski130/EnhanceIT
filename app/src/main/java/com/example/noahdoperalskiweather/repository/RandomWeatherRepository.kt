package com.example.noahdoperalskiweather.repository

import com.example.noahdoperalskiweather.api.WeatherService
import com.example.noahdoperalskiweather.model.RandomWeatherResponse
import com.example.noahdoperalskiweather.model.list

interface RandomWeatherRepository {

    suspend fun getWeather(q: String?) : RandomWeatherResponse
}

class RandomWeatherRepositoryImpl(private val service: WeatherService = WeatherService.getService()) : RandomWeatherRepository
{
    override suspend fun getWeather(q: String?): RandomWeatherResponse
    {
        val API_KEY = "5fc4ab57504f58871bcf98e074687af6"
        val response = service.getWeather(q = q)

        return if(response.isSuccessful)
        {
            response.body()!!
        } else {
            RandomWeatherResponse(emptyList())
        }
        //TODO("Not yet implemented")
    }

}