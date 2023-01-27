package com.example.composejc.Common

sealed class Resource<T>(val data:T? = null , val messege:String?= null){

    class loading<T>() : Resource<T>()

    class success<T>(data: T?) : Resource<T>(data = data)


    class error<T>(messege: String?) : Resource<T>(messege = messege)

}