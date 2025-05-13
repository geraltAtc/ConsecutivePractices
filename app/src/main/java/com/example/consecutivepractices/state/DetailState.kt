package com.example.consecutivepractices.state

import com.example.consecutivepractices.model.Movie
import com.example.consecutivepractices.model.MovieShort

interface MovieDetailState {
    val movie: Movie?
    val rating: Float
    val isRatingVisible: Boolean
    val isLoading: Boolean
    val error: String?
    val related: List<MovieShort>
}