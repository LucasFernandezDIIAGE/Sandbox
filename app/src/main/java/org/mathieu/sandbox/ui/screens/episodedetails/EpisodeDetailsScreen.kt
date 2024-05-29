package org.mathieu.sandbox.ui.screens.episodedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import org.mathieu.sandbox.ui.screens.characterdetails.CharacterDetailsState
import org.mathieu.sandbox.ui.screens.episodedetails.EpisodeDetailsViewModel
@Composable
fun EpisodeDetailsScreen(
    navController: NavController,
    episodeId: Int
) {
    val viewModel: EpisodeDetailsViewModel = viewModel()
    val state: EpisodeDetailsState by viewModel.state.collectAsState()

    LaunchedEffect(key1 = 0) {
        viewModel.initialize(id = episodeId)
    }

    Content(
        state = state
    )
}


@Composable
private fun Content(
    state: EpisodeDetailsState
) = Column {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = state.date)
            Text(text = state.name)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    Content(
        state = EpisodeDetailsState()
    )
}