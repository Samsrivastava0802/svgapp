package com.samridhi.svgapp.presentation.recentlygenerated

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.samridhi.svgapp.R
import com.samridhi.svgapp.alias.AppString
import com.samridhi.svgapp.data.temporarycache.TemporaryCache
import com.samridhi.svgapp.navigation.RecentlyGeneratedScreenActions
import com.samridhi.svgapp.presentation.generate.viewmodel.GenerateScreenUiEvent
import com.samridhi.svgapp.presentation.recentlygenerated.viewmodel.RecentlyGeneratedUiState
import com.samridhi.svgapp.presentation.recentlygenerated.viewmodel.RecentlyGeneratedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecentlyGeneratedScreen(
    viewModel: RecentlyGeneratedViewModel = hiltViewModel(),
    onActions: (RecentlyGeneratedScreenActions) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier,
                        text = stringResource(AppString.my_recently_generated_dogs)
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
        RecentlyGeneratedScreenContent(
            modifier = Modifier.padding(innerPadding),
            uiState = viewModel.uiState
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecentlyGeneratedScreenContent(
    modifier: Modifier = Modifier,
    uiState: RecentlyGeneratedUiState
) {
    Column(
        modifier = modifier.padding(12.dp).fillMaxSize()
    ) {
        Spacer(modifier = Modifier.size(120.dp))
        val pagerState = rememberPagerState(pageCount = { uiState.data.size })
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            state = pagerState
        ) { page ->
            AsyncImage(
                model = uiState.data[page],
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

        }
        Spacer(modifier = Modifier.size(40.dp))
        Button(
            onClick = {
                TemporaryCache.clearCache()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(AppString.clear_dogs)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun RecentlyGeneratedScreenPreview() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier,
                        text = stringResource(AppString.my_recently_generated_dogs)
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
        RecentlyGeneratedScreenContent(
            modifier = Modifier.padding(innerPadding),
            uiState = RecentlyGeneratedUiState()
        )
    }
}