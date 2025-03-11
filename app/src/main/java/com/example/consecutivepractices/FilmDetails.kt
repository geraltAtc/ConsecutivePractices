package com.example.consecutivepractices

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun FilmDetailsScreen(navController: NavHostController, movieId: Int) {
    val viewModel = koinViewModel<DetailsViewModel> { parametersOf(navController, movieId) }

    MovieDetails(
        movie = viewModel.mutableState.movie,
        onBackPressed = { viewModel.back() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MovieDetails(
    movie: Movie?,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    movie?.name?.let {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(
                            Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Назад",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF1976D2),
                    titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        }
    ) { paddingValues ->
        movie?.let {
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    AsyncImage(
                        model = it.posterImageURL,
                        contentDescription = "Poster ${it.name}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .clip(MaterialTheme.shapes.large),
                        contentScale = ContentScale.Crop
                    )
                }

                item {
                    Text(
                        text = it.plot,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.9f)
                        ),
                        lineHeight = 24.sp
                    )
                }

                item {
                    Column(
                        modifier = Modifier.padding(vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Premier year: ${it.premierYear}",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        )
                        Text(
                            text = "Rating: ${it.rating.aggregateRating}",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        )
                        Text(
                            text = "Genres: ${it.genres.joinToString(", ")}",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                            )
                        )
                        Text(
                            text = "Countries: ${it.countries.joinToString(", ")}",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                            )
                        )
                    }
                }

                item {
                    Text(
                        text = "Cast:",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        ),
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                items(it.people) { person ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            model = person.photoURL,
                            contentDescription = "Photo ${person.name}",
                            modifier = Modifier
                                .size(80.dp)
                                .padding(end = 8.dp)
                                .clip(MaterialTheme.shapes.large),
                            contentScale = ContentScale.Crop
                        )
                        Column {
                            Text(
                                text = person.name,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            )
                            Text(
                                text = "Role: ${person.characters.joinToString(", ")}",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}