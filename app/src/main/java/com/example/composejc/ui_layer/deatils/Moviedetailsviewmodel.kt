package com.example.composejc.ui_layer.deatils

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composejc.Common.Resource
import com.example.composejc.data.repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Moviedetailsviewmodel @Inject constructor(private val repository: repository , savedStateHandle: SavedStateHandle):ViewModel() {
    val moviedetails = mutableStateOf(moviedetailstateholder())

    init {
        moviedetails.value = moviedetailstateholder(isloading =  true)
        viewModelScope.launch {
        savedStateHandle.getStateFlow("id" , "0").collectLatest {
            getmoviedetails(it)
           }
        }
    }

    fun getmoviedetails (id:String) = viewModelScope.launch ( Dispatchers.IO ){
        when(val result = repository.getmoviedeatils(id)){
            is Resource.error ->{
                moviedetails.value = moviedetailstateholder(error = result.messege.toString())
            }
            is Resource.success ->{
                moviedetails.value = moviedetailstateholder(data = result.data)
            }
            else -> {}
        }
    }
}