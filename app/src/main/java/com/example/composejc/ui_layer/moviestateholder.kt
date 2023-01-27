package com.example.composejc.ui_layer

import com.example.composejc.model.Result

data class moviestateholder (
    val isloading:Boolean = false,
    val data : List<Result>? = null,
    val error : String = ""
)