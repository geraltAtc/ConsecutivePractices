package com.example.consecutivepractices

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

class ListViewModel(
    private val repository: MovieRepository,
    private val navigation: NavHostController
) : ViewModel() {

    init {
        loadMovies()
    }

    fun loadMovies(): List<Movie> {
        return repository.getList()
    }

    fun onItemClicked(id: Int) {
        navigation.navigate("filmDetail/$id")
    }
}