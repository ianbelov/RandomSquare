package com.a.randomsquare.viewmodel

import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.colorsgenerator.IColorsGenerator
import com.a.randomsquare.util.heavyobjects.HeavyObject
import dagger.Lazy
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject


class FirstViewModel @Inject constructor(
    private var generator: IColorsGenerator,
    private var heavyObject: Lazy<HeavyObject>
) : ViewModel() {

    var subject =  PublishSubject.create<Int>()

    fun generateNewColor(code: Int) {
        subject.onNext(generator.getColor(code))
    }

    fun instanceCount(): Int = HeavyObject.instantiationCount

    fun callObject() {
        heavyObject.get()
    }

}