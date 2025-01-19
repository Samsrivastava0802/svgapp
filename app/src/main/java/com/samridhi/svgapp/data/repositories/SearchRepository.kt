package com.samridhi.svgapp.data.repositories

import com.samridhi.svgapp.data.ApiClientService
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val apiClientService: ApiClientService
) {
    suspend fun getSearchImage() = apiClientService.searchImage()
}