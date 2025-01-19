package com.samridhi.svgapp.data.repositories

import com.samridhi.svgapp.data.models.response.DogImages
import retrofit2.Response
import retrofit2.http.GET
interface ApiClientService {
    @GET("breeds/image/random")
    suspend fun searchImage(): Response<DogImages>
}