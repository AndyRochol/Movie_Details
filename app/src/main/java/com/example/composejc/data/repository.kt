package com.example.composejc.data

import android.util.Log
import com.example.composejc.Common.Resource
import com.example.composejc.model.Result
import com.example.composejc.model.deatils.Moviedeatilsfile

class repository(private val moviedatasource: moviedatasource) {
    private val TAG = "repos"
    private val messe = "data is fetched"
    suspend fun getmovielist() : Resource<List<Result>> {

        return try {
            Resource.success(data = moviedatasource.getmovielist().results)

        }
        catch (e : Exception){
            Resource.error(messege = e.toString())
        }
    }

    suspend fun getmoviedeatils(id:String): Resource<Moviedeatilsfile>{

       return try {
            Resource.success(data = moviedatasource.getmoviedetails(id))
        }
       catch (e :Exception){
            Resource.error(messege = e.toString())
       }
    }
}