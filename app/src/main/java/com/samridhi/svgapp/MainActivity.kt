package com.samridhi.svgapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.samridhi.svgapp.navigation.AppNavGraph
import com.samridhi.svgapp.navigation.AppNavigationActions
import com.samridhi.svgapp.ui.theme.SvgAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SvgAppTheme {
                SvgApp(
                    onNavigationEnd = {
                        finish()
                    }
                )
            }
        }
    }
}
@Composable
fun SvgApp(
    onNavigationEnd: () -> Unit
) {
    val navController = rememberNavController()
    val navActions = remember(navController) {
        AppNavigationActions(navController, onNavigationEnd)
    }
    AppNavGraph(
        navController = navController,
        navActions = navActions
    )
}
