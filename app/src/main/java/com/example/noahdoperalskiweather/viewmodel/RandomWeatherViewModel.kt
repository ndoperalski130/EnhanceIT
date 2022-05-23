package com.example.noahdoperalskiweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.noahdoperalskiweather.model.RandomWeather
import com.example.noahdoperalskiweather.model.RandomWeatherResponse
import com.example.noahdoperalskiweather.repository.RandomWeatherRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RandomWeatherViewModel(private val repoID: RandomWeatherRepositoryImpl) : ViewModel()
{

    private val _randomWeather = MutableLiveData<RandomWeatherResponse>()

    val randomWeather: LiveData<RandomWeatherResponse> get() = _randomWeather

    fun getWeather(city: String?)
    {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repoID.getWeather(city)
            _randomWeather.postValue(response)
        }
    }

}