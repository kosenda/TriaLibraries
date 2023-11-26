package ksnd.trialibraries.libraries.tagcloud

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import eu.wewox.tagcloud.TagCloud
import eu.wewox.tagcloud.rememberTagCloudState
import ksnd.trialibraries.R
import ksnd.trialibraries.common.TopBar
import ksnd.trialibraries.ui.theme.TriaLibrariesTheme
import kotlin.random.Random

@Composable
fun TagCloudScreen(navHostController: NavHostController) {
    TagCloudScreenContent(onBack = navHostController::navigateUp)
}

@Composable
private fun TagCloudScreenContent(onBack: () -> Unit) {
    val uriHandler = LocalUriHandler.current
    val tagCloudUrl = stringResource(id = R.string.tag_cloud_url)

    val tagItems = remember {
        List(31) {
            Pair(
                first = "Item\n #$it",
                second = Color(
                    red = Random.nextInt(120, 255),
                    green = Random.nextInt(120, 255),
                    blue = Random.nextInt(120, 255),
                ),
            )
        }.toMutableStateList()
    }

    Scaffold(
        topBar = {
            TopBar(
                titleResId = R.string.tag_cloud,
                onBack = onBack,
                onClickGitHub = { uriHandler.openUri(uri = tagCloudUrl) },
            )
        },
    ) { padding ->

        Column(modifier = Modifier.padding(padding)) {
            TagCloud(
                state = rememberTagCloudState(),
                modifier = Modifier.fillMaxSize(),
            ) {
                items(tagItems) { (label, color) ->
                    Box(
                        modifier = Modifier
                            .tagCloudItemFade()
                            .tagCloudItemScaleDown(),
                    ) {
                        Text(
                            text = label,
                            modifier = Modifier
                                .background(
                                    color = color,
                                    shape = CircleShape,
                                )
                                .layout { measurable, constraints ->
                                    val placeable = measurable.measure(constraints)
                                    val length = maxOf(placeable.width, placeable.height) * 3 / 2
                                    layout(length, length) {
                                        placeable.placeRelative((length - placeable.width) / 2, (length - placeable.height) / 2)
                                    }
                                },
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewTagCloudScreenContent() {
    TriaLibrariesTheme {
        TagCloudScreenContent(onBack = {})
    }
}
