package com.example.noahdoperalskiitunes.controller

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.noahdoperalskiitunes.R
import com.example.noahdoperalskiitunes.model.RandomSong
import com.example.noahdoperalskiitunes.model.RandomSongResponse
import com.squareup.picasso.Picasso

class MusicViewAdapter(private val list: List<RandomSong>) : RecyclerView.Adapter<MusicViewAdapter.MusicViewHolder>()
{
    inner class MusicViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        fun onBind(randomSong: RandomSong)
        {
            if(randomSong.trackPrice > 0.00)
            {
                val tvSongArtist = itemView.findViewById<TextView>(R.id.tvSongArtist)
                val tvSongTitle = itemView.findViewById<TextView>(R.id.tvSongTitle)
                val tvSongPrice = itemView.findViewById<TextView>(R.id.tvSongPrice)
                val tvSongActualTitle = itemView.findViewById<TextView>(R.id.tvSongActualTitle)
                val ivSongImage = itemView.findViewById<ImageView>(R.id.ivCoverPhoto)

                tvSongArtist.text = randomSong.artistName
                tvSongTitle.text = randomSong.trackName
                println("---> " + randomSong.artworkUrl60)
                tvSongPrice.text = "$ ${randomSong.trackPrice}"
                tvSongActualTitle.text = randomSong.collectionName
                //val url = randomSong.artWorkUrl100.trim()

                Picasso.get()
                    .load(randomSong.artworkUrl60)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .fit()
                    .into(ivSongImage)

                itemView.setOnClickListener{
                    val url = randomSong.previewUrl
                    val mediaPlayer = MediaPlayer().apply {
                        setAudioAttributes(
                            AudioAttributes.Builder()
                                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                .setUsage(AudioAttributes.USAGE_MEDIA)
                                .build()
                        )
                        setDataSource(url)
                        prepare()
                        start()
                    }

                    Toast.makeText(itemView.context, "${randomSong.trackName} Was clicked", Toast.LENGTH_SHORT).show()
                }
            }


        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MusicViewHolder {
        val listItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.music_item, parent, false)

            return MusicViewHolder(listItem)

    }

    override fun onBindViewHolder(holder: MusicViewAdapter.MusicViewHolder, position: Int) {
        if(list[position].trackPrice > 0.00)
            holder.onBind(list[position])

    }

    override fun getItemCount(): Int {
        return list.size
    }

}