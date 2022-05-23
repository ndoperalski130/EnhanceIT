package com.example.noahdoperalskiweather.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class RandomWeatherResponse(
    val results: List<RandomWeather>
)

@Parcelize
data class RandomWeather(
    val cod: String,
    val message: String,
    val cnt: String,
    val list: List<list>,
    val city: city
) : Parcelable

@Parcelize
data class city(
    val id: String,
    val name: String,
    val coord: coord,
    val country: String,
    val population: Int,
    val timezone: Int,
    val sunrise: Long,
    val sunset: Long
) : Parcelable

 @Parcelize
data class coord(
    val lat: Double,
    val lon: Double
) : Parcelable

@Parcelize
data class list(
    val dt: String,
    val main: main,
    val weather: List<weather>,
    val clouds: clouds,
    val wind: wind,
    val visibility: Int,
    val dt_text: String
) : Parcelable

@Parcelize
data class main(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Double,
    val sea_level: Double,
    val grnd_level: Double,
    val humidity: Double,
    val temp_kf: Double
) : Parcelable

@Parcelize
data class weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
) : Parcelable

@Parcelize
data class clouds(
    val all: Int
) : Parcelable

@Parcelize
data class wind(
    val speed: Double,
    val deg: Double,
    val gust: Double
) : Parcelable