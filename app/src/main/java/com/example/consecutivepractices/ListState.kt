package com.example.consecutivepractices


interface MoviesListState {
    val items: List<MovieShort>
    val query: String
    val isEmpty: Boolean
    val isLoading: Boolean
    val error: String?
}