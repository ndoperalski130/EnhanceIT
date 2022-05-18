package com.example.mvpexample.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvpexample.R
import com.example.mvpexample.databinding.MovieListItemBinding
import com.example.mvpexample.model.Movie

class MovieAdapter(private val movies: MutableList<Movie> = mutableListOf()) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    fun setMovieList(list: List<Movie>)
    {
        movies.addAll(list)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(private val binding: MovieListItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun onBind(movie: Movie)
        {
            binding.tvMovieTitle.text = movie.name


            Glide.with(binding.ivPoster)
                .load(movie.imageUrl)
                .into(binding.ivPoster)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        return MovieViewHolder(
            MovieListItemBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false)
        )
        //TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(movies[position])
        //TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return movies.size
        //TODO("Not yet implemented")
    }
}