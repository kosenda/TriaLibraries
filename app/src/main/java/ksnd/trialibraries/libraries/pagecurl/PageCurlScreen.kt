package ksnd.trialibraries.libraries.pagecurl

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import eu.wewox.pagecurl.ExperimentalPageCurlApi
import eu.wewox.pagecurl.page.PageCurl
import ksnd.trialibraries.R
import ksnd.trialibraries.common.TopBar

@Composable
fun PageCurlScreen(navHostController: NavHostController) {
    PageCurlScreenContent(
        onBack = navHostController::navigateUp,
    )
}

@OptIn(ExperimentalPageCurlApi::class)
@Composable
private fun PageCurlScreenContent(onBack: () -> Unit) {
    val uriHandler = LocalUriHandler.current
    val pageCurlUrl = stringResource(id = R.string.page_curl_url)
    val pages = listOf(
        "Page 1" to Color.Black,
        "Page 2" to Color.Blue,
        "Page 3" to Color.Cyan,
    )

    Scaffold(
        topBar = {
            TopBar(
                titleResId = R.string.page_curl,
                onBack = onBack,
                onClickGitHub = { uriHandler.openUri(uri = pageCurlUrl) },
            )
        },
    ) { padding ->
        PageCurl(
            count = pages.size,
            key = { pages[it].hashCode() },
            modifier = Modifier.padding(padding),
        ) {
            Box(
                modifier = Modifier
                    .background(color = pages[it].second)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = pages[it].first,
                    fontSize = 36.sp,
                    color = Color.White,
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewPageCurlScreenContent() {
    PageCurlScreenContent(onBack = {})
}
