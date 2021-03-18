package com.a.randomsquare.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.colorsgenerator.IColorsGenerator
import com.a.randomsquare.util.colorsgenerator.SecondColorsGeneratorImpl
import com.a.randomsquare.util.heavyobjects.HeavyObject
import dagger.Lazy
import javax.inject.Inject

class FirstViewModel @Inject constructor(
    private var generator: IColorsGenerator,
    private var heavyObject: Lazy<HeavyObject>
) : ViewModel() {

    var colorCode: MutableLiveData<Int> = MutableLiveData()

    fun generateNewColor(code: Int) {
        colorCode.value = generator.getColor(code)
    }

    fun instanceCount(): Int = HeavyObject.instantiationCount

    fun callObject() {
        heavyObject.get()
    }

}