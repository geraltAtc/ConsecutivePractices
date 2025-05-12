package com.example.consecutivepractices.response

import com.google.gson.annotations.SerializedName

class MoviesSearch(
    @SerializedName("docs")
    val search: List<MovieShortResponse>?
)

class MovieShortResponse(
    val id: Int?,
    val name: String?,
    val poster: Poster,
)