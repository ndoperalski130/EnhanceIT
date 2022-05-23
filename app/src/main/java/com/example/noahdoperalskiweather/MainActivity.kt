package com.example.noahdoperalskiweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.noahdoperalskiweather.databinding.ActivityMainBinding
import com.example.noahdoperalskiweather.view.HomeFragment

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fcvContainer, HomeFragment())
            .addToBackStack(null)
            .commit()

        setContentView(binding.root)
    }
}