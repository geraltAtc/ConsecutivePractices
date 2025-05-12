package com.example.consecutivepractices

import android.os.Build
import androidx.annotation.RequiresApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@RequiresApi(Build.VERSION_CODES.O)
val rootModule = module {
    single<MoviesRepository> { MoviesRepository(get(), get()) }

    factory { MovieMapper() }

    viewModel { ListViewModel(get(), it.get()) }
    viewModel { DetailsViewModel(get(), it.get(), it.get()) }
}