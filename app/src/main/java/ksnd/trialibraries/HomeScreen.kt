package ksnd.trialibraries

import androidx.annotation.StringRes
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
    val libraries: List<LibraryInfo> = listOf(
        LibraryInfo(
            textId = R.string.konfetti,
            onClick = { navHostController.navigate(NavRoute.Konfetti.route) },
        ),
        LibraryInfo(
            textId = R.string.page_curl,
            onClick = { navHostController.navigate(NavRoute.PageCurl.route) },
        ),
        LibraryInfo(
            textId = R.string.tag_cloud,
            onClick = { navHostController.navigate(NavRoute.TagCloud.route) },
        ),
    )

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            libraries.forEach { library ->
                TransitionButton(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp),
                    textId = library.textId,
                    onClick = library.onClick,
                )
            }
        }
    }
}

private data class LibraryInfo(
    @StringRes val textId: Int,
    val onClick: () -> Unit,
)

@Preview
@Composable
fun PreviewHomeScreen() {
    TriaLibrariesTheme {
        HomeScreen(navHostController = rememberNavController())
    }
}
