package com.example.composejc.data

import com.example.composejc.Network.ApiService

class moviedatasource(private val apiService: ApiService) {

    suspend fun getmovielist() = apiService.getmovielist(api_key = "b721723e4f2021328fefbcc5e8dc8cb5")

    suspend fun getmoviedetails(id:String) = apiService.getmoviedetails(id , api_key = "b721723e4f2021328fefbcc5e8dc8cb5")
}