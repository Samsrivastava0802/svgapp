package com.samridhi.svgapp.data.temporarycache

object TemporaryCache {

    private val data = mutableListOf<String>()
    fun saveImage(url: String) = data.add(url)

    fun getAllSavedImages() = data

    fun clearCache() = data.clear()
}


// TemporaryCache.clearCache()