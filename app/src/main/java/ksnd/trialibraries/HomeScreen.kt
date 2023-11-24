package ksnd.trialibraries

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ksnd.trialibraries.ui.theme.TriaLibrariesTheme

@Composable
fun HomeScreen(navHostController: NavHostController) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            TransitionButton(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp),
                textId = R.string.konfetti,
                onClick = { navHostController.navigate(NavRoute.Konfetti.route) },
            )
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    TriaLibrariesTheme {
        HomeScreen(navHostController = rememberNavController())
    }
}
