package ksnd.trialibraries.common

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import ksnd.trialibraries.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(onBack: () -> Unit, onClickGitHub: () -> Unit) {
    TopAppBar(
        title = { Text(stringResource(id = R.string.konfetti)) },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(painter = painterResource(id = R.drawable.ic_arrow_back_24), contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = onClickGitHub) {
                Icon(painter = painterResource(id = R.drawable.ic_github_mark), contentDescription = "")
            }
        },
    )
}
