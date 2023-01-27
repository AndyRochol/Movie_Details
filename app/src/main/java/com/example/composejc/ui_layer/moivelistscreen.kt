package com.example.composejc.ui_layer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.composejc.data.moviedatasource
import com.example.composejc.model.Result
import com.example.composejc.navigation.Movienavigationitem

@Composable
fun Moivelistscreen(navController: NavController,viewModel : movie_viewmodel = hiltViewModel() ) {

    val result = viewModel.movielist.value

    if (result.isloading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    if (result.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = result.error)
        }

    }

    result.data?.let {
        LazyColumn {
            items(result.data) {
                Movielist(it){
                    navController.navigate(Movienavigationitem.moviedeatils.route)
                }
            }
        }
    }
}
    @Composable
    fun Movielist(it : Result , onClick:(String) ->Unit){

        AsyncImage(model = "https://image.tmdb.org/t/p/w500/${it.poster_path}", contentDescription = null ,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(vertical = 5.dp)
                .clickable { onClick.invoke(it.id.toString()) } ,
            contentScale = ContentScale.Crop)

    }

