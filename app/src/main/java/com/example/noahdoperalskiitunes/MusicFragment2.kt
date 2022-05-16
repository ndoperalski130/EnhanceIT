package com.example.noahdoperalskiitunes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noahdoperalskiitunes.MusicFragment.Companion.newInstance
import com.example.noahdoperalskiitunes.api.apiService
import com.example.noahdoperalskiitunes.controller.MusicViewAdapter
import com.example.noahdoperalskiitunes.model.RandomSongResponse
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ResourceBundle.getBundle

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MusicFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MusicFragment2() : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private var adapter: RecyclerView.Adapter<MusicViewAdapter.MusicViewHolder>? = null
    lateinit var recycler_view: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_music, container, false)
        recycler_view = view.findViewById(R.id.rv_songs)
        val layoutManager: LinearLayoutManager = LinearLayoutManager(context?.applicationContext)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler_view.adapter = adapter
        recycler_view.layoutManager = layoutManager

        startRetrofit()

        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MusicFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(list: ArrayList<RandomSongResponse>) =
            MusicFragment2()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        recycler_view = view.findViewById(R.id.rv_songs)
//        val layoutManager: LinearLayoutManager = LinearLayoutManager(context?.applicationContext)
//        layoutManager.orientation = LinearLayoutManager.VERTICAL
//        recycler_view.adapter = adapter
    }
    private fun startRetrofit()
    {
        apiService.createRetrofit().create(apiService::class.java).getClassicSongs().enqueue(object :
            Callback<RandomSongResponse> {
            override fun onResponse(
                call: Call<RandomSongResponse>,
                response: Response<RandomSongResponse>
            ) {
                if(response.isSuccessful)
                {
                    adapter = MusicViewAdapter(response.body()!!.results)
                    //var bundle: Bundle = Bundle()
                    //val string = Gson().toJson(response.body())
                    //bundle.putString("DATA",string)
                    recycler_view.adapter = adapter
                    println("Ran OK")
                }
            }

            override fun onFailure(call: Call<RandomSongResponse>, t: Throwable) {
                println("Fail oK")
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }

}