package com.samridhi.svgapp.di

import com.google.gson.GsonBuilder
import com.samridhi.svgapp.data.ApiClientService
import com.samridhi.svgapp.data.repositories.SearchRepository
import com.samridhi.svgapp.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideAppApiInterface(): ApiClientService =
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ApiClientService::class.java)

}