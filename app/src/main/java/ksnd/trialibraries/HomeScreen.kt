package ksnd.trialibraries

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Surface {
        Text(
            text = "HOME",
            fontSize = 24.sp,
            color = Color.Black,
        )
    }
}
