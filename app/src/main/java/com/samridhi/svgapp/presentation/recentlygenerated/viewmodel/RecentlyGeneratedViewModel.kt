package com.samridhi.svgapp.presentation.recentlygenerated.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.samridhi.svgapp.data.temporarycache.TemporaryCache

class RecentlyGeneratedViewModel : ViewModel() {

    var uiState by mutableStateOf(RecentlyGeneratedUiState())
        private set

    init {
        uiState = uiState.copy(data = TemporaryCache.getAllSavedImages())
    }

}

data class RecentlyGeneratedUiState(
    val data: List<String> = emptyList()
)


