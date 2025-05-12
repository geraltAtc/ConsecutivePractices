package com.example.consecutivepractices

import com.example.consecutivepractices.response.MoviesResponse
import com.example.consecutivepractices.response.MovieShortResponse
import com.example.consecutivepractices.response.MoviesSearch

class MovieMapper {
    fun toDomain(response: MoviesResponse): Movie {
        return Movie(
            id = response.id ?: 0,
            name = response.name ?: "Без названия",
            rating = response.rating?.let {
                Rating(it.kp ?: 0.0, it.imdb ?: 0.0, it.filmCritics ?: 0.0)
            } ?: Rating(0.0, 0.0, 0.0),
            plot = response.description.orEmpty(),
            posterImageURL = response.poster?.url ?: "",
            genres = response.genres?.mapNotNull { it.name } ?: emptyList(),
            countries = response.countries?.mapNotNull { it.name } ?: emptyList(),
            people = response.persons
                ?.filter { it.name != null && it.photoURL != null }
                ?.map { Actor(it.name!!, it.characters, it.photoURL!!) }
                ?: emptyList()
        )
    }

    fun toDomain(response: MovieShortResponse): MovieShort {
        return MovieShort(
            id = response.id ?: 0,
            name = response.name.orEmpty(),
            posterImageURL = response.poster.url ?: ""
        )
    }

    fun toDomainList(response: MoviesSearch) =
        response.search?.map { movie -> toDomain(movie) }.orEmpty()
}