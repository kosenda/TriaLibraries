package ksnd.trialibraries

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ksnd.trialibraries.ui.theme.TriaLibrariesTheme

@Composable
fun TransitionButton(
    modifier: Modifier = Modifier,
    @StringRes textId: Int,
    onClick: () -> Unit,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = modifier
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
    ) {
        Row(
            modifier = Modifier.defaultMinSize(minHeight = 56.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(id = textId),
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Image(
                painter = painterResource(id = R.drawable.ic_right_24),
                contentDescription = "move screen",
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onSurfaceVariant),
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(32.dp),
            )
        }
    }
}

@Preview
@Composable
fun TransitionButton() {
    TriaLibrariesTheme {
        Surface(color = MaterialTheme.colorScheme.surface) {
            TransitionButton(textId = R.string.konfetti){}
        }
    }
}
