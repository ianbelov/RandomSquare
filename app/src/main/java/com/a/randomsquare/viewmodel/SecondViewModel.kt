package com.a.randomsquare.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.colorsgenerator.IColorsGenerator
import com.a.randomsquare.util.heavyobjects.HeavyObject
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject
import javax.inject.Provider

@SuppressLint("CheckResult")
class SecondViewModel @Inject constructor(
    private var generator: IColorsGenerator,
    private var heavyObject: Provider<HeavyObject>
) : ViewModel() {

    var colorCode: MutableLiveData<Int> = MutableLiveData()
    var subject = BehaviorSubject.create<MutableLiveData<Int>>()

    init {
        subject.onNext(colorCode)
        subject.subscribe { onNext ->
            colorCode = onNext
        }
    }

    fun generateNewColor(code: Int) {
        colorCode.value = generator.getColor(code)
    }

    fun instanceCount(): Int = HeavyObject.instantiationCount

    fun callObject() {
        heavyObject.get()
    }

}