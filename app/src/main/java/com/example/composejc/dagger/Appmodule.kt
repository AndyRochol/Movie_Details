package com.example.composejc.dagger

import android.util.Log
import com.example.composejc.Network.ApiService
import com.example.composejc.data.moviedatasource
import com.example.composejc.data.repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@InstallIn(SingletonComponent :: class)
@Module
object Appmodule {
    private val TAG = "MyActivity"
    private val mess = "hrgknkgng"
    @Provides
    fun provideretrofit() : Retrofit {
        return Retrofit.Builder().baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    fun provideApiservice(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService:: class.java)
    }

    @Provides
    fun providedatasource(apiService: ApiService) : moviedatasource{
        return moviedatasource(apiService)
        Log.i(TAG , mess)
    }

    @Provides
    fun providemovierepository(datasource: moviedatasource): repository{
        return repository(datasource)
    }
}