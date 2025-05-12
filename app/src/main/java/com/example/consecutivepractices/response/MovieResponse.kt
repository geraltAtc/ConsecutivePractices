package com.example.consecutivepractices.response

import com.example.consecutivepractices.Actor
import com.example.consecutivepractices.Rating

data class MoviesResponse(
    val id: Int?,
    val name: String?,
    val rating: Rating?,
    val description: String?,
    val poster: Poster?,
    val genres: List<Genre>?,
    val countries: List<Country>?,
    val persons: List<Actor>?
)

class Poster(
    val url: String,
)

class Genre(
    val name: String
)

class Country(
    val name: String
)