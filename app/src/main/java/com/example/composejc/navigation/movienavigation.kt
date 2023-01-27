package com.example.composejc.navigation

import android.content.Intent
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composejc.ui_layer.Moivelistscreen
import com.example.composejc.ui_layer.deatils.Moviedeatilsscreen

@Composable
fun Movienavigation(navHostController: NavHostController) {


    NavHost(navController = navHostController, startDestination = Movienavigationitem.movielist.route){
        composable(Movienavigationitem.movielist.route){
            Moivelistscreen(navHostController)
        }

        composable(Movienavigationitem.moviedeatils.route + "/{id}"){
           val id= it.arguments?.getString("id")
            Log.d("TAG" , "message from it: $id")

            Moviedeatilsscreen()
        }
    }
}