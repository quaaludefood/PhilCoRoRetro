package com.example.philcororetro.di

import com.example.philcororetro.network.RetrofitService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitServiceModule {
    @Singleton
    @Provides
    fun provideNewsService(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)
    }

    companion object {
       // private const val BASE_URL = "http://mylabdaemon.thefusion.works/api/"
       private const val BASE_URL = "http://192.168.1.165:52477/api/"
    }

}