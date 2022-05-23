package com.example.noahdoperalskiweather.api

import com.example.noahdoperalskiweather.model.RandomWeatherResponse

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("forecast")
    suspend fun getWeather(
        @Query("q") q: String? = null,
        @Query("appid") appid: String = "5fc4ab57504f58871bcf98e074687af6"
    ) : Response<RandomWeatherResponse>

    companion object {
        private var instance: WeatherService? = null
        //const val URL = "https://api.openweathermap.org/data/2.5/"

        fun getService() : WeatherService
        {
            if(instance == null)
            {
                instance = Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org/data/2.5/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(WeatherService::class.java)

                println(instance)
            }
            return instance!!
        }
    }
}