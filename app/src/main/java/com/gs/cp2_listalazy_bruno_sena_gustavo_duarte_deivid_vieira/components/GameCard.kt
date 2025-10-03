package com.gs.cp2_listalazy_bruno_sena_gustavo_duarte_deivid_vieira.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gs.cp2_listalazy_bruno_sena_gustavo_duarte_deivid_vieira.model.Game
import com.gs.cp2_listalazy_bruno_sena_gustavo_duarte_deivid_vieira.ui.theme.Cp2ListalazyTheme

@Composable
fun GameCard(game: Game) {
    Card(modifier = Modifier.padding(bottom = 8.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(3f)
            ) {
                Text(
                    text = game.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = game.studio,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Text(
                text = game.releaseYear.toString(),
                modifier = Modifier.weight(1f),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1565C0) // Azul diferente para personalizar
            )
        }
    }
}

@Preview(showBackground = true, name = "Exemplo Game Card")
@Composable
fun PreviewGameCard() {
    Cp2ListalazyTheme {
        GameCard(
            game = Game(
                id = 1,
                title = "Exemplo Game",
                studio = "Estúdio Exemplo",
                releaseYear = 2023
            )
        )
    }
}
