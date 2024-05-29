package org.mathieu.sandbox.ui.screens.characterdetails

import android.content.Context
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import org.mathieu.sandbox.domain.models.Episode
import android.media.MediaPlayer
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import java.io.IOException
import org.mathieu.sandbox.R
import kotlin.random.Random


var mediaPlayer: MediaPlayer? = null

@Composable
fun CharacterDetailsScreen(
    navController: NavController,
    characterId: Int
) {

    val viewModel: CharacterDetailsViewModel = viewModel()
    val state: CharacterDetailsState by viewModel.state.collectAsState()

    LaunchedEffect(key1 = 0) {
        viewModel.initialize(id = characterId)
    }

    Content(
        state = state,
        navController = navController
    )
}

private fun getRandomSoundResource(context: Context): Int {
    val rawResources = listOf(
        R.raw.sound,
        R.raw.sound2,
        R.raw.sound3,
        R.raw.sound4
    )
    return rawResources[Random.nextInt(rawResources.size)]
}
private fun playSound(context: Context) {
    try {
        val randomSoundResource = getRandomSoundResource(context)
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(context, randomSoundResource)
        mediaPlayer?.start()
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

private fun Vibrate(context: Context){
    val vibrate = context.getSystemService(Vibrator::class.java) as Vibrator
    if(Build.VERSION.SDK_INT>=26){
        vibrate.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
    }
    else{
        vibrate.vibrate(400)
    }
}

@Composable
private fun Content(
    state: CharacterDetailsState,
    navController: NavController
) {
    Column {
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
                Text(text = state.firstName)
                Text(text = state.lastName)
            }
        }

        state.episodes.forEach { episode ->
            EpisodeCard(
                episode = episode,
                navController = navController
            )
        }
    }
}

@Composable
private fun EpisodeCard(
    episode: Episode,
    navController: NavController
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable {
                    playSound(context)
                    Vibrate(context)
                    navController.navigate("episodes/${episode.id}")
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = episode.date)
            Text(text = episode.name)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    Content(
        state = CharacterDetailsState(),
        navController = NavController(LocalContext.current)
    )
}
