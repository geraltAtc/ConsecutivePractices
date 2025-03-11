package com.example.consecutivepractices

import com.example.consecutivepractices.MovieRepository
import com.example.consecutivepractices.DetailsViewModel
import com.example.consecutivepractices.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<MovieRepository> { MovieRepository() }

    viewModel { ListViewModel(get(), it.get()) }
    viewModel { DetailsViewModel(get(), it.get(), it.get()) }
}