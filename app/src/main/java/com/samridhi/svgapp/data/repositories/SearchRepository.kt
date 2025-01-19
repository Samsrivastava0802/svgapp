package com.samridhi.svgapp.data.repositories

import javax.inject.Inject

class AppRepositories @Inject constructor(
    private val apiClientService: ApiClientService
) {
    suspend fun getData() = apiClientService.searchImage()
}