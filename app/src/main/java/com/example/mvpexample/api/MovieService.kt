package com.example.mvpexample.api

import com.example.mvpexample.model.Movie
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MovieService {

    @GET("movielist.json")
    fun getAllMovies(): Call<List<Movie>>



    companion object {
        private var instance: Retrofit? = null

        fun getRetrofit(): Retrofit
        {
            if(instance == null)
            {
                instance = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return instance!!
        }

    }
}