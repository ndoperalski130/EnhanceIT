package com.example.noahdoperalskiweather.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.noahdoperalskiweather.R
import com.example.noahdoperalskiweather.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        binding.btnLoadData.setOnClickListener{

            if(binding.etCityName.text.isNotBlank())
            {
                println(binding.etCityName.text.toString())
                val city = binding.etCityName.text.toString()

                val frag = ListFragment()
//                val bundle = Bundle()
//                bundle.putString("CITY", city)
//                frag.arguments = bundle

                parentFragmentManager.beginTransaction().replace(R.id.fcvContainer, frag)
                    .commit()
            }
        }

        return binding.root
    }

}