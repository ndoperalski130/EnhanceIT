package com.example.noahdoperalskiweather.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.noahdoperalskiweather.databinding.FragmentDetailsBinding
import com.example.noahdoperalskiweather.model.RandomWeather
import com.example.noahdoperalskiweather.model.RandomWeatherResponse

class DetailsFragment : Fragment() {

    private var _binding : FragmentDetailsBinding? = null
    private val binding : FragmentDetailsBinding get() = _binding!!

    companion object{
        private val FRAGKEY = "DetailsFragment"

        fun newInstance(randomWeather: RandomWeather): DetailsFragment {
            val frag = DetailsFragment()
            val bundle = Bundle()
            bundle.putParcelable(FRAGKEY, randomWeather)
            frag.arguments = bundle
            return frag
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        val randomWeather: RandomWeather? = arguments?.getParcelable(FRAGKEY)

        if (randomWeather != null) {
            binding.tvActualTemperature.text = randomWeather.list[0].main.temp.toString()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}