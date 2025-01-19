package com.samridhi.svgapp.presentation.generate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.samridhi.svgapp.R
import com.samridhi.svgapp.alias.AppString
import com.samridhi.svgapp.app.App
import com.samridhi.svgapp.navigation.GenerateScreenActions
import com.samridhi.svgapp.presentation.generate.viewmodel.GenerateScreenUiEvent
import com.samridhi.svgapp.presentation.generate.viewmodel.GenerateScreenUiState
import com.samridhi.svgapp.presentation.generate.viewmodel.GenerateScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenerateScreen(
    viewModel: GenerateScreenViewModel = hiltViewModel(),
    onActions: (GenerateScreenActions) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier,
                        text = stringResource(AppString.generate_dogs)
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                        }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        GenerateScreenContent(
            modifier = Modifier.padding(innerPadding),
            uiState = viewModel.uiState,
            onEvent = {
                viewModel.onEvent(it)
            }
        )
    }

}

@Composable
fun GenerateScreenContent(
    modifier: Modifier = Modifier,
    uiState: GenerateScreenUiState,
    onEvent: (GenerateScreenUiEvent) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Spacer(modifier = Modifier.size(120.dp))

        AsyncImage(
            model = uiState.photoUrl,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.size(40.dp))
        Button(
            onClick = {
                onEvent(GenerateScreenUiEvent.GenerateImage)
            }
        ) {
            Text(
                text = stringResource(AppString.generate)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GenerateScreenPreview() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier,
                        text = stringResource(AppString.generate_dogs)
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                        }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        GenerateScreenContent(
            modifier = Modifier.padding(innerPadding),
            uiState = GenerateScreenUiState(),
            onEvent = {}
        )
    }
}