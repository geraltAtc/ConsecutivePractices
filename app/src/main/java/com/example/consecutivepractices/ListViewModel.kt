package com.example.consecutivepractices

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.debounce
import java.time.Duration

@RequiresApi(Build.VERSION_CODES.O)
class ListViewModel(
    private val repository: MoviesRepository,
    private val navigation: NavHostController
) : ViewModel() {

    private val mutableState = MutableMoviesListState()
    val viewState = mutableState as MoviesListState

    private val textChangesFlow = MutableStateFlow("")

    init {
        viewModelScope.launch {
            textChangesFlow
                .debounce(Duration.ofSeconds(1L))
                .collect { loadMovies(it) }
        }
    }

    private fun loadMovies(query: String) {
        mutableState.items = emptyList()
        mutableState.error = null

        if (query.length < MIN_QUERY_LENGTH_TO_SEARCH) return
        viewModelScope.launchLoadingAndError(
            handleError = { mutableState.error = it.localizedMessage },
            updateLoading = { mutableState.isLoading = it }
        ) {
            mutableState.items = repository.getList(query)
        }
    }

    fun onQueryChanged(query: String) {
        mutableState.query = query
        viewModelScope.launch { textChangesFlow.emit(query) }
    }

    fun onItemClicked(id: Int) {
        navigation.navigate("filmDetail/$id")
    }

    private class MutableMoviesListState : MoviesListState {
        override var items: List<MovieShort> by mutableStateOf(emptyList())
        override var query by mutableStateOf("")
        override val isEmpty get() = items.isEmpty()
        override var isLoading: Boolean by mutableStateOf(false)
        override var error: String? by mutableStateOf(null)
    }

    companion object {
        private const val MIN_QUERY_LENGTH_TO_SEARCH = 3
    }
}