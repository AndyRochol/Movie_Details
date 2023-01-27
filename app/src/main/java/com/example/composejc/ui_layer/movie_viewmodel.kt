package com.example.composejc.ui_layer

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composejc.Common.Resource
import com.example.composejc.data.repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class movie_viewmodel @Inject constructor(private val repository: repository) : ViewModel(){
    private val TAG = "MyActivity"
    private val mess = "hrgknkgng"

    val movielist = mutableStateOf(moviestateholder())

    init {
        movielist.value = moviestateholder(isloading = true)
        getmovielist()
    }

    fun getmovielist() = viewModelScope.launch(Dispatchers.IO) {
        val result = repository.getmovielist()

        when(result){
            is Resource.success -> {
                movielist.value = moviestateholder(data = result.data)
            }
            is Resource.error -> {
                movielist.value = moviestateholder(error = result.messege.toString())
            }
            else ->{

            }
        }
    }
}