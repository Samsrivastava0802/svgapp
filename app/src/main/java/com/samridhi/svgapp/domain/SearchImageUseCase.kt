package com.samridhi.svgapp.domain

import com.samridhi.svgapp.data.repositories.SearchRepository
import javax.inject.Inject

class SearchImageUseCase @Inject constructor(
    private val searchRepository : SearchRepository
) {
    suspend operator fun invoke() = searchRepository.getSearchImage()
}