package ksnd.trialibraries.libraries.htmltext

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import de.charlex.compose.material3.HtmlText
import ksnd.trialibraries.R
import ksnd.trialibraries.common.TopBar
import ksnd.trialibraries.ui.theme.TriaLibrariesTheme

@Composable
fun HtmlTextScreen(navHostController: NavHostController) {
    HtmlTextScreenContent(onBack = navHostController::navigateUp)
}

@Composable
private fun HtmlTextScreenContent(onBack: () -> Unit) {
    val uriHandler = LocalUriHandler.current
    val htmlTextUrl = stringResource(id = R.string.html_text_url)

    val examplePairList = listOf(
        "<b> - Bold text" to "<b>ぼーるど</b>",
        "<i> - Italic text" to "<i>いたりっく</i>",
        "<strike> - Striked text" to "<strike>とりけし</strike>",
        "<u> - Underlined text" to "<u>あんだーらいん</u>",
        "<a href=\"...\"> - Link" to "<a href=\"https://github.com/ch4rl3x/HtmlText\">りんく</a>",
        "<span style=\"color: #FF00FF\"> - Colored text" to "<span style=\"color: #FF00FF\">すぱん</span>",
        "<span style=\"color: lime\"> - Colored text" to "<span style=\"color: lime\">すぱん</span>",
        "<font color=\"#FF0000\"> - Colored text" to "<font color=\"#FF0000\">ふぉんと</font>",
        "<font color=\"teal\"> - Colored text" to "<font color=\"teal\">ふぉんと</font>",
    )

    Scaffold(
        topBar = {
            TopBar(
                titleResId = R.string.html_text,
                onBack = onBack,
                onClickGitHub = { uriHandler.openUri(uri = htmlTextUrl) },
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(padding)
                .padding(all = 8.dp)
                .fillMaxSize(),
        ) {
            examplePairList.forEach { (desc, html) ->
                Text(text = desc, fontSize = 16.sp)
                HtmlText(text = html, fontSize = 16.sp)
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Preview
@Composable
private fun PreviewHtmlTextScreenContent() {
    TriaLibrariesTheme {
        HtmlTextScreenContent {}
    }
}
