package com.example.noahdoperalskiitunes.api

import android.util.Log
import com.example.noahdoperalskiitunes.model.RandomSongResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface apiService {

    @GET("search?term=rock&amp;media=music&entity=song&limit=50")
    fun getRockSongs(): Call<RandomSongResponse>


    @GET("search?term=classic&amp;media=music&entity=song&limit=50")
    fun getClassicSongs(): Call<RandomSongResponse>

    @GET("search?term=pop&amp;media=music&entity=song&limit=50")
    fun getPopSongs(): Call<RandomSongResponse>


    companion object {
        private var instance: Retrofit? = null

        fun createRetrofit(): Retrofit {
            if(instance == null)
            {
                instance = Retrofit.Builder()
                    .baseUrl("https://itunes.apple.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return instance!!
        }
    }
}