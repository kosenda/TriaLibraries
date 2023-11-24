package ksnd.trialibraries

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import ksnd.trialibraries.ui.theme.TriaLibrariesTheme

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            TriaLibrariesTheme {
                FirstScreen()
            }
        }
    }
}
