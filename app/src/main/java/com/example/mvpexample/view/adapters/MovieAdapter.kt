package com.example.mvpexample.view.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.mvpexample.databinding.MovieListItemBinding
import com.example.mvpexample.model.Movie

class MovieAdapter(private val movies: MutableList<Movie> = mutableListOf()) {

    fun setMovieList(list: List<Movie>)
    {
        movies.addAll(list)
    }

    inner class MovieViewHolder(private val binding: MovieListItemBinding) : RecyclerView.ViewHolder(binding.root)
    {

    }
}