package com.example.noahdoperalskiweather.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noahdoperalskiweather.databinding.WeatherListItemBinding
import com.example.noahdoperalskiweather.model.RandomWeather
import com.example.noahdoperalskiweather.model.RandomWeatherResponse

class WeatherRecyclerAdapter(private val list: MutableList<RandomWeather> = mutableListOf(),
                             private val openDetails: (RandomWeather) -> Unit)
    : RecyclerView.Adapter<WeatherRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: WeatherListItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun onBind(randomWeather: RandomWeather)
        {

            //binding.tvActualTemperature.text = "randomWeather.list[0].main.temp.toString()"
            binding.tvFeelsLikeTemperature.text = "Hello World"

            binding.root.setOnClickListener {
                openDetails(randomWeather)
            }
        }
    }

    fun setWeatherList(newList: List<RandomWeather>)
    {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeatherRecyclerAdapter.ViewHolder = ViewHolder(WeatherListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: WeatherRecyclerAdapter.ViewHolder, position: Int) {
        holder.onBind(list[position])
        //TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return list.size
        //TODO("Not yet implemented")
    }
}