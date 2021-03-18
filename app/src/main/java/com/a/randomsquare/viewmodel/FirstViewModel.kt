package com.a.randomsquare.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.colorsgenerator.IColorsGenerator
import com.a.randomsquare.util.colorsgenerator.SecondColorsGeneratorImpl
import javax.inject.Inject

class FirstViewModel @Inject constructor(private var generator: IColorsGenerator): ViewModel() {

    var colorCode : MutableLiveData<Int> = MutableLiveData()

    fun generateNewColor(code: Int){
        colorCode.value = generator.getColor(code)
    }

}