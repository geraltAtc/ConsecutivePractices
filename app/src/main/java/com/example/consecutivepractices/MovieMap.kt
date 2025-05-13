package com.example.consecutivepractices

import com.example.consecutivepractices.model.Actor
import com.example.consecutivepractices.model.Genre
import com.example.consecutivepractices.model.Movie
import com.example.consecutivepractices.model.MovieShort
import com.example.consecutivepractices.model.MovieType
import com.example.consecutivepractices.model.Rating
import com.example.consecutivepractices.response.MoviesResponse
import com.example.consecutivepractices.response.MovieShortResponse


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
            genres = response.genres?.map { genre -> Genre.getGenreByName(genre.name) }
                ?: emptyList(),
            countries = response.countries?.map { country -> country.name } ?: emptyList(),
            type = MovieType.getMovieTypeByCode(response.type),
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
            type = (response.type?.let { MovieType.getMovieTypeByCode(it) } ?: MovieType.MOVIE).toString(),
            genres = response.genres?.map { Genre.getGenreByName(it.name) } ?: emptyList(),
            posterImageURL = response.poster?.url ?: ""
        )
    }

    fun toDomainList(response: List<MovieShortResponse>): List<MovieShort> {
        return response.map { toDomain(it) }
    }
}