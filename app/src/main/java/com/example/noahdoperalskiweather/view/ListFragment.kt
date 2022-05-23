package com.example.noahdoperalskiweather.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noahdoperalskiweather.R
import com.example.noahdoperalskiweather.api.WeatherService
import com.example.noahdoperalskiweather.databinding.FragmentListBinding
import com.example.noahdoperalskiweather.model.RandomWeather
import com.example.noahdoperalskiweather.model.RandomWeatherResponse
import com.example.noahdoperalskiweather.repository.RandomWeatherRepositoryImpl
import com.example.noahdoperalskiweather.viewmodel.RandomWeatherViewModel

class ListFragment() : Fragment() {


    private var _binding : FragmentListBinding? = null
    private val binding : FragmentListBinding get() = _binding!!

    private val viewModel: RandomWeatherViewModel by lazy {
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return RandomWeatherViewModel(RandomWeatherRepositoryImpl()) as T
                //TODO("Not yet implemented")
            }
        }.create(RandomWeatherViewModel::class.java)
    }

    private lateinit var recyclerViewAdapter: WeatherRecyclerAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(layoutInflater, container, false)

        //val bundle = Bundle().getBundle("CITY")
        val thecity = arguments?.getString("CITY")
        println("City is: $thecity")
        viewModel.getWeather(thecity)

        configureObserver()
        Thread.sleep(1000)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun configureObserver()
    {

        viewModel.randomWeather.observe(viewLifecycleOwner) { response ->
            if(response.list.isNullOrEmpty())
            {
                println("Response is null or empty $response")
                //binding!!.tvErrorText.text = "Network Error"
            }
            else
            {
                recyclerViewAdapter = WeatherRecyclerAdapter(openDetails = ::openDetails)
                recyclerViewAdapter.setWeatherList(response.list)
                binding.rvWeatherList.layoutManager = LinearLayoutManager(requireActivity().applicationContext)
                binding.rvWeatherList.adapter = recyclerViewAdapter
            }
        }
    }

    private fun openDetails(randomWeather: RandomWeather)
    {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fcvContainer, DetailsFragment.newInstance(randomWeather))
            .addToBackStack(null)
            .commit()
    }

}