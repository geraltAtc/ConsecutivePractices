package com.example.consecutivepractices.response

import com.example.consecutivepractices.dto.GenreDto
import com.example.consecutivepractices.model.Poster
import com.google.gson.annotations.SerializedName

class MoviesSearch(
    @SerializedName("docs")
    val search: List<MovieShortResponse>?
)

class MovieShortResponse(
    val id: Int?,
    val name: String?,
    val poster: Poster,
    val type: String,
    val genres: List<GenreDto>
)