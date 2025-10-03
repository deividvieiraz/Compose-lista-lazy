package com.gs.cp2_listalazy_bruno_sena_gustavo_duarte_deivid_vieira.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gs.cp2_listalazy_bruno_sena_gustavo_duarte_deivid_vieira.model.Game
import com.gs.cp2_listalazy_bruno_sena_gustavo_duarte_deivid_vieira.ui.theme.Cp2ListalazyTheme

@Composable
fun StudioCard(game: Game, onClick: (() -> Unit)? = null) {
    Card(
        modifier = Modifier
            .size(110.dp)
            .padding(end = 6.dp)
            .clickable(enabled = onClick != null) { onClick?.invoke() }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(8.dp)
        ) {
            Text(
                text = game.studio,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true, name = "Exemplo Studio Card")
@Composable
fun PreviewStudioCard() {
    Cp2ListalazyTheme {
        StudioCard(
            game = Game(
                id = 1,
                title = "Exemplo Game",
                studio = "Estúdio Exemplo",
                releaseYear = 2023
            )
        )
    }
}
