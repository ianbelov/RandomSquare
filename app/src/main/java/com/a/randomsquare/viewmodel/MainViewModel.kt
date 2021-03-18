package com.a.randomsquare.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a.randomsquare.di.colorsgenerator.SecondColorsGeneratorImpl
import javax.inject.Inject

class MainViewModel @Inject constructor(private var generatorRgbI: SecondColorsGeneratorImpl): ViewModel() {

    var colorCode : MutableLiveData<Int> = MutableLiveData()

    fun generateNewColor(code: Int){
        colorCode.value = generatorRgbI.getColor(code)
    }

}