package com.example.mvpexample.presenter

import com.example.mvpexample.model.MainInteractor
import com.example.mvpexample.model.Movie
import com.example.mvpexample.view.MainView

class MoviePresenter(private var mainView: MainView,
                    private var interactor: MainInteractor) : MainInteractor.onFinishedListener {
    override fun onResultSuccess(movies: List<Movie>) {
        mainView.hideProgress()
        mainView.setData(movies)
    }

    override fun onResultFailure(msg: String) {
        mainView.hideProgress()
        mainView.setError(msg)
        //TODO("Not yet implemented")
    }

    fun getAllMovies()
    {
        interactor.getAllMovies(this)
    }

    fun onDestroy()
    {

    }

}