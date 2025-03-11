package com.example.consecutivepractices

class MovieRepository {
    fun getList() = MoviesData.movies

    fun getMovie(id: Int) = MoviesData.movies.find { it.id == id }
}