package com.example.consecutivepractices

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationBar(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "films")
    {
        composable("films") { FilmsScreen(navController)  }
        composable("filmDetail/{movieId}") {  x ->
            val movieId = x.arguments?.getString("movieId")?.toInt() ?: 0
            FilmDetailsScreen(navController, movieId)
        }
        composable("profile") { ProfileScreen() }
    }
}