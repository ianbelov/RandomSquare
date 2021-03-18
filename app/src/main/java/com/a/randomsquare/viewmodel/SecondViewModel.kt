package com.a.randomsquare.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.colorsgenerator.IColorsGenerator
import javax.inject.Inject

class SecondViewModel @Inject constructor(private var generator: IColorsGenerator): ViewModel() {

    var colorCode : MutableLiveData<Int> = MutableLiveData()

    fun generateNewColor(code: Int){
        colorCode.value = generator.getColor(code)
    }

}