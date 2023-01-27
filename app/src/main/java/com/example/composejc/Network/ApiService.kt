package com.example.composejc.Network

import com.example.composejc.model.Movielistresponse
import com.example.composejc.model.deatils.Moviedeatilsfile
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // https://api.themoviedb.org/3/movie/550?api_key=b721723e4f2021328fefbcc5e8dc8cb5



    @GET("3/movie/popular")
    suspend fun getmovielist(
        @Query("api_key") api_key: String
    ) : Movielistresponse

    @GET("3/movie/{id}")
    suspend fun getmoviedetails(
        @Path("id") id : String,
        @Query("api_key") api_key: String

    ): Moviedeatilsfile
}