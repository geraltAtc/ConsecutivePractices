package com.example.consecutivepractices.state

import com.example.consecutivepractices.model.MovieShort
import com.example.consecutivepractices.model.MovieType


interface MoviesListState {
    val items: List<MovieShort>
    val query: String
    val isEmpty: Boolean
    val isLoading: Boolean
    val error: String?
    val hasBadge: Boolean
    val showTypesDialog: Boolean
    val typesVariants: Set<MovieType>
    val selectedTypes: Set<MovieType>
}