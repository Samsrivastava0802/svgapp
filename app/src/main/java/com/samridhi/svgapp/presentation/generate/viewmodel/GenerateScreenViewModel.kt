package com.samridhi.svgapp.presentation.generate.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samridhi.svgapp.data.temporarycache.TemporaryCache
import com.samridhi.svgapp.domain.SearchImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenerateScreenViewModel @Inject constructor(
    val searchImageUseCase: SearchImageUseCase
) : ViewModel() {
    var uiState by mutableStateOf(GenerateScreenUiState())
        private set

    fun onEvent(event: GenerateScreenUiEvent) {
        when (event) {
            GenerateScreenUiEvent.GenerateImage -> {
                generateImage()
            }
        }
    }

    private fun generateImage() {
        viewModelScope.launch {
            val response = searchImageUseCase()
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.d("lion22", "generateImage: $it ")
                    uiState = uiState.copy(
                        photoUrl = it.message
                    )
                    TemporaryCache.saveImage(it.message)
                }
            }
        }
    }
}

data class GenerateScreenUiState(
    val photoUrl: String = ""
)

sealed class GenerateScreenUiEvent {
    data object GenerateImage : GenerateScreenUiEvent()
}