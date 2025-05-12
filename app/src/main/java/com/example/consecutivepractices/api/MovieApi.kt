package com.example.consecutivepractices.api

import com.example.consecutivepractices.response.MoviesResponse
import com.example.consecutivepractices.response.MoviesSearch
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/search")
    suspend fun searchMovies(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 10,
        @Query("query") query: String,
    ): MoviesSearch

    @GET("movie/{id}")
    suspend fun getMovie(
        @Path("id") id: Int? = null,
    ): MoviesResponse
}