package com.example.consecutivepractices

import android.util.Log
import com.example.consecutivepractices.api.MovieApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepository(
    private val api: MovieApi,
    private val mapper: MovieMapper
) {
    suspend fun getList(query: String) =
        withContext(Dispatchers.IO) {
            val response = api.searchMovies(query = query)
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
}