package com.example.mvpexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpexample.R
import com.example.mvpexample.databinding.ActivityMainBinding
import com.example.mvpexample.databinding.MovieShmovieLayoutBinding
import com.example.mvpexample.model.Movie
import com.example.mvpexample.presenter.MoviePresenter

class MainActivity : AppCompatActivity() , MainView{

    private lateinit var moviePresenter: MoviePresenter
    private lateinit var recyclerView: RecyclerView

    // viewBinding
    // pattern to prevent memory leaks, LeakCanary
    private var _binding : ActivityMainBinding? = null
    private val binding : ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        _binding = ActivityMainBinding.inflate(layoutInflater)
        
        setContentView(binding.root)


        
    }

    override fun showProgress() {
        binding.pbLoading.visibility = View.VISIBLE
        binding.rvMovies.visibility = GONE
        binding.tvErrorText.visibility = GONE
        //TODO("Not yet implemented")
    }

    override fun hideProgress() {
        binding.pbLoading.visibility = GONE
        //TODO("Not yet implemented")
    }

    override fun setData(movies: List<Movie>) {

        //TODO("Not yet implemented")
    }

    override fun setError(msg: String) {
//        binding.tvErrorText.text = msg
//        binding.tvErrorText.visibility = VISIBLE
//        binding.root.visibility = INVISIBLE
        binding.tvErrorText.apply {
            text = msg
            visibility = VISIBLE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
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