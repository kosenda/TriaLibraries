package ksnd.trialibraries.libraries.konfetti

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import ksnd.trialibraries.R
import ksnd.trialibraries.common.TopBar

@Composable
fun KonfettiScreen(navHostController: NavHostController) {
    KonfettiScreenContent(onBack = navHostController::navigateUp)
}

@Composable
private fun KonfettiScreenContent(onBack: () -> Unit) {
    Scaffold(
        topBar = { TopBar(onBack = onBack) },
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            Text(text = stringResource(id = R.string.konfetti))
        }
    }
}
