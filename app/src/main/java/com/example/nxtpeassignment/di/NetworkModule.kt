package com.example.nxtpeassignment.di

import com.example.nxtpeassignment.api.NxtPeAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl("https://apptestsoko.s3.ap-south-1.amazonaws.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesPageData(retrofit: Retrofit) : NxtPeAPI{
         return retrofit.create(NxtPeAPI::class.java)
    }
}