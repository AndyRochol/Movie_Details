package com.example.composejc.ui_layer.deatils

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun Moviedeatilsscreen(viewModel: Moviedetailsviewmodel = hiltViewModel()) {

    val result = viewModel.moviedetails.value
    if(result.isloading){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }

    if(result.error.isNotBlank()){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(text = result.error)
        }
    }

   result.data?.let {
       Column(modifier = Modifier.padding(horizontal = 12.dp)) {
           AsyncImage(model = "https://image.tmdb.org/t/p/w500/${it.poster_path}", contentDescription = null,
               modifier = Modifier
                   .fillMaxWidth()
                   .height(390.dp) , contentScale = ContentScale.FillBounds)
           
           Spacer(modifier = Modifier.height(15.dp))
           Text(text = it.original_title , style = MaterialTheme.typography.h4)
           Spacer(modifier = Modifier.height(11.dp))
           Text(text = it.tagline , style = MaterialTheme.typography.caption)
           Spacer(modifier = Modifier.height(8.dp))
           Text(text = it.overview , style = MaterialTheme.typography.body1)



       }
       
   }
   // Surface(modifier = Modifier.fillMaxSize()) {
     //   Text(text = "moviedetails")
    //}

}