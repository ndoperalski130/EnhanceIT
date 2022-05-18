package com.example.mvpexample.model

import com.example.mvpexample.api.MovieService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainInteractor {

    interface onFinishedListener{
        fun onResultSuccess(movies: List<Movie>)
        fun onResultFailure(msg: String)
    }

    fun getAllMovies(listener: onFinishedListener)
    {
        val service = MovieService.getRetrofit().create(MovieService::class.java)

        service.getAllMovies().enqueue(object: Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
//                TODO("Not yet implemented")
                listener.onResultSuccess(response.body()!!)
            }
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
//                TODO("Not yet implemented")
                listener.onResultFailure("Network call failed...")
            }
        })

        // coroutine needs a scope
        // also need to establish context aka dispatchers
        // Dispatchers: Main, IO, Default, & Unconfined
        // Main -> Run on main thread
        // IO -> Runs on the input/output thread (database queries/network calls)
        // Default -> Longer computation
        // Unconfined -> Testing purposes
        //CoroutineScope(Dispatchers.Main).launch {
        //    val response = service.getAllMovies()

//            if(response.isSuccessful)
  //          {
    //            listener.onResultSuccess(response.body()!!)
     //       }
     //       else
      //      {
      //          listener.onResultFailure("Network call failed...")
      //      }
      //  }
    }
}