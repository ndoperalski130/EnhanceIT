package com.example.noahdoperalskiitunes.model

data class RandomSongResponse(
    val results: List<RandomSong>
)

data class RandomSong(
    val trackName: String,
    val collectionName: String,
    val artistName: String,
    val trackPrice: Double,
    val country: String,
    val primaryGenreName: String,
    val previewUrl: String,
    val artworkUrl60: String
)
