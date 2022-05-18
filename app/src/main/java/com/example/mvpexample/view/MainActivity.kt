package com.example.mvpexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpexample.R
import com.example.mvpexample.model.Movie
import com.example.mvpexample.presenter.MoviePresenter

class MainActivity : AppCompatActivity() , MainView{

    private lateinit var moviePresenter: MoviePresenter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showProgress() {

        //TODO("Not yet implemented")
    }

    override fun hideProgress() {

        //TODO("Not yet implemented")
    }

    override fun setData(movies: List<Movie>) {

        //TODO("Not yet implemented")
    }

    override fun setError(msg: String) {

    }
}

// interfaces
// contract between the view layer and presenter layer
interface MainView {
    fun showProgress()
    fun hideProgress()
    fun setData(movies: List<Movie>)
    fun setError(msg: String)

}