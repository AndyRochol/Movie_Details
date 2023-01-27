package com.example.composejc.ui_layer.deatils

import androidx.lifecycle.LiveData
import com.example.composejc.model.deatils.Moviedeatilsfile

data class moviedetailstateholder(
    val error:String = "",
    val data: Moviedeatilsfile ?= null,
    val isloading:Boolean = false

)
