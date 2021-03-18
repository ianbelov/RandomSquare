package com.a.randomsquare.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a.randomsquare.ColorsGenerator
import javax.inject.Inject

class MainViewModel @Inject constructor(private var generator: ColorsGenerator): ViewModel() {

    var colorCode : MutableLiveData<Int> = MutableLiveData()

    fun generateNewColor(code: Int){
        colorCode.value = generator.getColor(code)
    }

}