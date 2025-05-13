package com.example.consecutivepractices.state

import com.example.consecutivepractices.model.MovieShort

data class FavoritesState (
    val items: List<MovieShort> = emptyList()
)