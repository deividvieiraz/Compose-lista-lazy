package com.gs.cp2_listalazy_bruno_sena_gustavo_duarte_deivid_vieira.repository

import com.gs.cp2_listalazy_bruno_sena_gustavo_duarte_deivid_vieira.model.Game

fun getAllGames(): List<Game> {
    return listOf(
        Game(id = 1, title = "Shadow Quest", studio = "PixelForge", releaseYear = 1989),
        Game(id = 2, title = "Galaxy Riders", studio = "Starbyte", releaseYear = 1992),
        Game(id = 3, title = "Turbo Rally", studio = "FastTrack", releaseYear = 1985),
        Game(id = 4, title = "Mystic Tower", studio = "ArcanaSoft", releaseYear = 1987),
        Game(id = 5, title = "Cyber Strike", studio = "NeoTech", releaseYear = 1990),
        Game(id = 6, title = "Jungle Jump", studio = "WildGames", releaseYear = 1984),
        Game(id = 7, title = "Sky Blaster", studio = "CloudNine", releaseYear = 1986),
        Game(id = 8, title = "Neon Fighter", studio = "FuturePlay", releaseYear = 1988),
        Game(id = 9, title = "Pixel Warriors", studio = "BitMasters", releaseYear = 1985),
        Game(id = 10, title = "Rocket Patrol", studio = "OrbitGames", releaseYear = 1983)
    )

}

fun getGamesByStudio(studio: String): List<Game> {
    return getAllGames().filter {
        it.studio.startsWith(prefix = studio, ignoreCase = true)
    }
}