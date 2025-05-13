package com.example.consecutivepractices.repository

import android.util.Log
import com.example.consecutivepractices.MovieMapper
import com.example.consecutivepractices.api.MovieApi
import com.example.consecutivepractices.model.Genre
import com.example.consecutivepractices.model.MovieShort
import com.example.consecutivepractices.model.MovieType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepository(
    private val api: MovieApi,
    private val mapper: MovieMapper,
    private val db: MovieDatabase
) {
    suspend fun getList(query: String, filterTypes: Set<MovieType>? = null) =
        withContext(Dispatchers.IO) {
            val response = api.searchMovies(query = query).search
                .orEmpty()
                .filter { movie ->
                    filterTypes.isNullOrEmpty()
                            || filterTypes.contains(MovieType.getMovieTypeByCode(movie.type))
                }
            mapper.toDomainList(response)
        }

    suspend fun getById(id: Int) = withContext(Dispatchers.IO) {
        Log.d("API_DEBUG", "Запрашиваю фильм с ID: $id")
        try {
            val response = api.getMovie(id)
            Log.d("API_DEBUG", "Ответ API: ${response.toString()}")
            val movie = mapper.toDomain(response)
            Log.d("API_DEBUG", "Смаппленный фильм: $movie")
            movie
        } catch (e: Exception) {
            Log.e("API_DEBUG", "Ошибка при запросе: ${e.message}")
            null
        }
    }

    suspend fun saveFavorite(movie: MovieShort) =
        withContext(Dispatchers.IO) {
            db.movieDao().insert(
                MovieDatabaseEntity(
                    name = movie.name,
                    type = movie.type,
                    genre = movie.genres.joinToString(",") { it.name },
                    url = movie.posterImageURL
                )
            )
        }

    suspend fun getFavorites() = withContext(Dispatchers.IO) {
        db.movieDao().getAll().map {
            MovieShort(
                id = it.id ?: 0,
                name = it.name.orEmpty(),
                type = it.type.orEmpty(),
                genres = it.genre?.let { genreStr ->
                    genreStr.split(",").mapNotNull { genreName ->
                        try {
                            Genre.valueOf(genreName.trim())
                        } catch (e: IllegalArgumentException) {
                            null
                        }
                    }
                } ?: emptyList(),
                posterImageURL = it.url.orEmpty()
            )
        }
    }
}