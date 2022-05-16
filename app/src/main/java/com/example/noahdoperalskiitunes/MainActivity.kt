package com.example.noahdoperalskiitunes

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.noahdoperalskiitunes.api.apiService
import com.example.noahdoperalskiitunes.controller.MusicTabAdapter
import com.example.noahdoperalskiitunes.controller.MusicViewAdapter
import com.example.noahdoperalskiitunes.model.RandomSongResponse
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val TAB_TITLES = arrayOf("Rock", "Classics", "Pop")



    lateinit var musicAdapter: MusicViewAdapter
    lateinit var musicAdapter2: MusicViewAdapter
    lateinit var musicAdapter3: MusicViewAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerView2: RecyclerView
    lateinit var recyclerView3: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById<ViewPager2>(R.id.vpPager)
        val tl = findViewById<TabLayout>(R.id.tabLayout)

        pager.adapter = MusicTabAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tl, pager) {
            tab, position -> tab.text = TAB_TITLES[position]
        }.attach()

        // TODO: figure out why returning null
        //startRetrofit()

    }

    private fun startRetrofit()
    {
        apiService.createRetrofit().create(apiService::class.java).getRockSongs().enqueue(object :
            Callback<RandomSongResponse>{
            override fun onResponse(
                call: Call<RandomSongResponse>,
                response: Response<RandomSongResponse>
            ) {
                if(response.isSuccessful)
                {
                    musicAdapter = MusicViewAdapter(response.body()!!.results)
                    //var bundle: Bundle = Bundle()
                    //val string = Gson().toJson(response.body())
                    //bundle.putString("DATA",string)
                    recyclerView = findViewById(R.id.rv_songs)
                    recyclerView.adapter = musicAdapter
                    println("Ran OK")
                }
            }

            override fun onFailure(call: Call<RandomSongResponse>, t: Throwable) {
                println("Fail oK")
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun startRetrofit2()
    {
        apiService.createRetrofit().create(apiService::class.java).getClassicSongs().enqueue(object :
            Callback<RandomSongResponse>{
            override fun onResponse(
                call: Call<RandomSongResponse>,
                response: Response<RandomSongResponse>
            ) {

                musicAdapter2 = MusicViewAdapter(response.body()!!.results)
                recyclerView2 = findViewById(R.id.rv_songs)
                recyclerView2.adapter = musicAdapter2

            }

            override fun onFailure(call: Call<RandomSongResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun startRetrofit3()
    {
        apiService.createRetrofit().create(apiService::class.java).getPopSongs().enqueue(object :
            Callback<RandomSongResponse>{
            override fun onResponse(
                call: Call<RandomSongResponse>,
                response: Response<RandomSongResponse>
            ) {
                musicAdapter3 = MusicViewAdapter(response.body()!!.results)
                recyclerView3 = findViewById(R.id.rv_songs)
                recyclerView3.adapter = musicAdapter3

            }

            override fun onFailure(call: Call<RandomSongResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }


}