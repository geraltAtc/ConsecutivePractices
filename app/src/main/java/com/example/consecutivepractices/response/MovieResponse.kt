package com.example.consecutivepractices.response

import com.example.consecutivepractices.dto.CountryDto
import com.example.consecutivepractices.dto.GenreDto
import com.example.consecutivepractices.dto.PremiereDto
import com.example.consecutivepractices.model.Actor
import com.example.consecutivepractices.model.Poster
import com.example.consecutivepractices.model.Rating

data class MoviesResponse(
    val id: Int?,
    val name: String?,
    val type: String?,
    val rating: Rating?,
    val premiere: PremiereDto?,
    val description: String?,
    val poster: Poster?,
    val genres: List<GenreDto>?,
    val countries: List<CountryDto>?,
    val persons: List<Actor>?
)