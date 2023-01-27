package com.example.composejc.navigation

sealed class Movienavigationitem(val route : String){

    object movielist : Movienavigationitem("movie_list")
    object moviedeatils : Movienavigationitem("movie_details")

}
