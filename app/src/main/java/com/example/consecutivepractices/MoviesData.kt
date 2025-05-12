package com.example.consecutivepractices

//object MoviesData {
//    val movies = listOf(
//        Movie(
//            id = 1,
//            name = "Inglourious Basterds",
//            rating = Rating(8.4, 1566170),
//            plot = "In Nazi-occupied France during World War II, a plan to assassinate Nazi leaders by a group of Jewish U.S. soldiers coincides with a theatre owner's vengeful plans for the same.",
//            premierYear = 2009,
//            posterImageURL = "https://m.media-amazon.com/images/M/MV5BOTJiNDEzOWYtMTVjOC00ZjlmLWE0NGMtZmE1OWVmZDQ2OWJhXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_.jpg",
//            genres = listOf("Adventure", "Drama", "War"),
//            countries = listOf("Germany", "United States"),
//            people = listOf(
//                Actor(
//                    photoURL = "https://m.media-amazon.com/images/M/MV5BMjA1MjE2MTQ2MV5BMl5BanBnXkFtZTcwMjE5MDY0Nw@@._V1_.jpg",
//                    name = "Brad Pitt",
//                    characters = listOf("Lt. Aldo Raine")
//                ),
//                Actor(
//                    photoURL = "https://m.media-amazon.com/images/M/MV5BMTU0NzQzNDc5M15BMl5BanBnXkFtZTcwNzMyOTYzNQ@@._V1_.jpg",
//                    name = "Mélanie Laurent",
//                    characters = listOf("Shosanna")
//                ),
//                Actor(
//                    photoURL = "https://m.media-amazon.com/images/M/MV5BMTM4MDk3OTYxOF5BMl5BanBnXkFtZTcwMDk5OTUwOQ@@._V1_.jpg",
//                    name = "Christoph Waltz",
//                    characters = listOf("Col. Hans Landa")
//                ),
//                Actor(
//                    photoURL = "https://m.media-amazon.com/images/M/MV5BMTkyMjU0NDk2OF5BMl5BanBnXkFtZTgwMDY4MDE4NTM@._V1_.jpg",
//                    name = "Eli Roth",
//                    characters = listOf("Sgt. Donny Donowitz")
//                ),
//                Actor(
//                    photoURL = "https://m.media-amazon.com/images/M/MV5BMTk0NjM2MTE5M15BMl5BanBnXkFtZTcwODIxMzcyNw@@._V1_.jpg",
//                    name = "Michael Fassbender",
//                    characters = listOf("Lt. Archie Hicox")
//                )
//            )
//        ),
//        Movie(
//            id = 2,
//            name = "Pulp Fiction",
//            rating = Rating(8.9, 2223586),
//            plot = "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
//            premierYear = 1994,
//            posterImageURL = "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg",
//            genres = listOf("Crime", "Drama"),
//            countries = listOf("United States"),
//            people = listOf(
//                Actor(
//                    photoURL = "https://m.media-amazon.com/images/M/MV5BMjA5NTA3MDQyOV5BMl5BanBnXkFtZTcwODM4NDE3Mw@@._V1_.jpg",
//                    name = "Tim Roth",
//                    characters = listOf("Pumpkin")
//                ),
//                Actor(
//                    photoURL = "https://m.media-amazon.com/images/M/MV5BMjAzNDczNzUzMV5BMl5BanBnXkFtZTcwOTQwNTQ1NA@@._V1_.jpg",
//                    name = "Amanda Plummer",
//                    characters = listOf("Honey Bunny")
//                ),
//                Actor(
//                    photoURL = "https://m.media-amazon.com/images/M/MV5BZDVhMTc0YjktODg0OS00MzBhLWIzMTMtYzE3MWZkNTUxMjg5XkEyXkFqcGdeQXVyNjUxMjc1OTM@._V1_.jpg",
//                    name = "Laura Lovelace",
//                    characters = listOf("Waitress")
//                ),
//                Actor(
//                    photoURL = "https://m.media-amazon.com/images/M/MV5BMTMyMjZlYzgtZWRjMC00OTRmLTllZTktMmM1ODVmNjljMTQyXkEyXkFqcGdeQXVyMTExNzQ3MzAw._V1_.jpg",
//                    name = "John Travolta",
//                    characters = listOf("Vincent Vega")
//                ),
//                Actor(
//                    photoURL = "https://m.media-amazon.com/images/M/MV5BMTQ1NTQwMTYxNl5BMl5BanBnXkFtZTYwMjA1MzY1._V1_.jpg",
//                    name = "Samuel L. Jackson",
//                    characters = listOf("Jules Winnfield")
//                )
//            )
//        ),
//        Movie(
//            id = 3,
//            name = "The Hateful Eight",
//            rating = Rating(7.8, 654080),
//            plot = "In the dead of a Wyoming winter, a bounty hunter and his prisoner find shelter in a cabin currently inhabited by a collection of nefarious characters.",
//            premierYear = 2015,
//            posterImageURL = "https://m.media-amazon.com/images/M/MV5BMjA1MTc1NTg5NV5BMl5BanBnXkFtZTgwOTM2MDEzNzE@._V1_.jpg",
//            genres = listOf("Crime", "Drama", "Mystery", "Thriller", "Western"),
//            countries = listOf("United States"),
//            people = listOf(
//                Actor(
//                    photoURL = "https://m.media-amazon.com/images/M/MV5BMTQ1NTQwMTYxNl5BMl5BanBnXkFtZTYwMjA1MzY1._V1_.jpg",
//                    name = "Samuel L. Jackson",
//                    characters = listOf("Major Marquis Warren")
//                ),
//                Actor(
//                    photoURL = "https://m.media-amazon.com/images/M/MV5BMTk3MjkxNzQwMV5BMl5BanBnXkFtZTYwNDk4ODM1._V1_.jpg",
//                    name = "Kurt Russell",
//                    characters = listOf("John Ruth")
//                ),
//                Actor(
//                    photoURL = "https://m.media-amazon.com/images/M/MV5BMTU1MzU2NTg0Nl5BMl5BanBnXkFtZTcwMjcyNjY0MQ@@._V1_.jpg",
//                    name = "Jennifer Jason Leigh",
//                    characters = listOf("Daisy Domergue")
//                ),
//                Actor(
//                    photoURL = "https://m.media-amazon.com/images/M/MV5BMzcxNjJiMWUtMDgwYS00MDg0LWJmZGQtMWNlMTIwNDhhODQ0XkEyXkFqcGdeQXVyNDg4OTQzNjg@._V1_.jpg",
//                    name = "Walton Goggins",
//                    characters = listOf("Sheriff Chris Mannix")
//                ),
//                Actor(
//                    photoURL = "https://m.media-amazon.com/images/M/MV5BMjIzNDMwMzI3OV5BMl5BanBnXkFtZTgwNTk2NzMyMTE@._V1_.jpg",
//                    name = "Demián Bichir",
//                    characters = listOf("Bob")
//                )
//            )
//        )
//    )
//}