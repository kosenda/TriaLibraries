package ksnd.trialibraries.libraries.konfetti

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import ksnd.trialibraries.R
import ksnd.trialibraries.common.TopBar
import ksnd.trialibraries.ui.theme.TriaLibrariesTheme
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.compose.OnParticleSystemUpdateListener
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.PartySystem
import nl.dionsegijn.samples.shared.Presets

@Composable
fun KonfettiScreen(
    navHostController: NavHostController,
    viewModel: KonfettiViewModel,
) {
    val parties by viewModel.parties.collectAsStateWithLifecycle()

    KonfettiScreenContent(
        parties = parties,
        updateParties = viewModel::updateParties,
        onBack = navHostController::navigateUp,
    )
}

@Composable
private fun KonfettiScreenContent(
    parties: List<Party>,
    updateParties: (List<Party>) -> Unit,
    onBack: () -> Unit,
) {
    val uriHandler = LocalUriHandler.current
    val konfettiUrl = stringResource(id = R.string.konfetti_url)
    val presets: List<Pair<String, List<Party>>> = listOf(
        "festival" to Presets.festive(),
        "explode" to Presets.explode(),
        "parade" to Presets.parade(),
        "rain" to Presets.rain(),
        "all" to mutableListOf<Party>().apply {
            addAll(Presets.festive())
            addAll(Presets.explode())
            addAll(Presets.parade())
            addAll(Presets.rain())
        },
    )

    Scaffold(
        topBar = {
            TopBar(
                onBack = onBack,
                onClickGitHub = { uriHandler.openUri(uri = konfettiUrl) },
            )
        },
    ) { padding ->
        Row(
            modifier = Modifier
                .padding(padding)
                .horizontalScroll(rememberScrollState())
                .padding(start = 16.dp),
        ) {
            presets.forEach { (name, preset) ->
                Button(
                    modifier = Modifier.padding(end = 16.dp),
                    onClick = {
                        updateParties(preset)
                    },
                    enabled = parties.isEmpty(),
                ) {
                    Text(text = name)
                }
            }
        }

        AnimatedVisibility(
            visible = parties.isNotEmpty(),
            enter = fadeIn(tween(500)),
            exit = fadeOut(tween(500)),
        ) {
            KonfettiView(
                modifier = Modifier.fillMaxSize(),
                parties = parties,
                updateListener = object : OnParticleSystemUpdateListener {
                    override fun onParticleSystemEnded(system: PartySystem, activeSystems: Int) {
                        if (activeSystems == 0) {
                            updateParties(emptyList())
                        }
                    }
                },
            )
        }
    }
}

@Preview
@Composable
private fun PreviewKonfettiScreenContent() {
    TriaLibrariesTheme {
        KonfettiScreenContent(
            parties = emptyList(),
            updateParties = {},
            onBack = {},
        )
    }
}
