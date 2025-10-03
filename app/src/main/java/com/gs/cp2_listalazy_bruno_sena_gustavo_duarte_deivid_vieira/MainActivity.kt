package com.gs.cp2_listalazy_bruno_sena_gustavo_duarte_deivid_vieira

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gs.cp2_listalazy_bruno_sena_gustavo_duarte_deivid_vieira.components.GameCard
import com.gs.cp2_listalazy_bruno_sena_gustavo_duarte_deivid_vieira.components.StudioCard
import com.gs.cp2_listalazy_bruno_sena_gustavo_duarte_deivid_vieira.model.Game
import com.gs.cp2_listalazy_bruno_sena_gustavo_duarte_deivid_vieira.repository.getAllGames
import com.gs.cp2_listalazy_bruno_sena_gustavo_duarte_deivid_vieira.repository.getGamesByStudio
import com.gs.cp2_listalazy_bruno_sena_gustavo_duarte_deivid_vieira.ui.theme.Cp2ListalazyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Cp2ListalazyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GamesScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GamesScreen(modifier: Modifier = Modifier) {
    var searchTextState by remember { mutableStateOf("") }
    var gamesListState by remember { mutableStateOf(getAllGames()) }

    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Meus jogos favoritos",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = searchTextState,
            onValueChange = { searchTextState = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Nome do estúdio") },
            trailingIcon = {
                IconButton(onClick = {
                    gamesListState = getGamesByStudio(searchTextState)
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Pesquisar"
                    )
                }
            }
        )

        // Botão de limpar filtro
        if (searchTextState.isNotEmpty() || gamesListState != getAllGames()) {
            Text(
                text = "Limpar filtro",
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .clickable {
                        searchTextState = ""
                        gamesListState = getAllGames()
                    },
                fontWeight = FontWeight.SemiBold,
                color = Color.Blue
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow {
            items(gamesListState) { game ->
                StudioCard(
                    game = game,
                    onClick = {
                        searchTextState = game.studio
                        gamesListState = getGamesByStudio(game.studio)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(gamesListState) { game ->
                GameCard(game = game)
            }
        }
    }
}

@Preview(showBackground = true, name = "Tela de Jogos")
@Composable
fun PreviewGamesScreen() {
    Cp2ListalazyTheme {
        GamesScreen()
    }
}

@Preview(showBackground = true, name = "Card de Estúdio")
@Composable
fun PreviewStudioCard() {
    Cp2ListalazyTheme {
        StudioCard(game = Game(1, "Exemplo Game", "Exemplo Studio", 2023))
    }
}

@Preview(showBackground = true, name = "Card de Jogo")
@Composable
fun PreviewGameCard() {
    Cp2ListalazyTheme {
        GameCard(game = Game(1, "Exemplo Game", "Exemplo Studio", 2023))
    }
}
