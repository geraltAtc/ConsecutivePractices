package com.example.consecutivepractices.view

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.consecutivepractices.repository.MoviesRepository
import com.example.consecutivepractices.launchLoadingAndError
import com.example.consecutivepractices.model.Movie
import com.example.consecutivepractices.model.MovieShort
import com.example.consecutivepractices.state.MovieDetailState
import kotlinx.coroutines.launch


class DetailsViewModel(
    private val repository: MoviesRepository,
    private val navigation: NavHostController,
    private val id: Int
) : ViewModel() {

    val viewState = MutableDetailsState()

    init {
        viewModelScope.launchLoadingAndError(
            handleError = { viewState.error = it.localizedMessage },
            updateLoading = { viewState.isLoading = it }
        ) {
            Log.e("DEBUG", "$id")
            viewState.movie = repository.getById(id)
            viewState.movie?.name?.let {
                launch { viewState.related = repository.getList(it).take(3) }
            }
        }
    }

    fun back() {
        navigation.popBackStack()
    }
}

class MutableDetailsState : MovieDetailState {
    override var movie: Movie? by mutableStateOf(null)
    override var rating: Float by mutableFloatStateOf(0f)
    override val isRatingVisible: Boolean get() = rating != 0f
    override var isLoading: Boolean by mutableStateOf(false)
    override var error: String? by mutableStateOf(null)
    override var related: List<MovieShort> by mutableStateOf(emptyList())
}