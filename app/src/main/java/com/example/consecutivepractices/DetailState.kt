package com.example.consecutivepractices

interface MovieDetailState {
    val movie: Movie?
    val rating: Float
    val isRatingVisible: Boolean
    val isLoading: Boolean
    val error: String?
    val related: List<MovieShort>
}