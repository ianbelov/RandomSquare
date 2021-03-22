package com.a.randomsquare.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.colorsgenerator.IColorsGenerator
import com.a.randomsquare.util.heavyobjects.HeavyObject
import dagger.Lazy
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class FirstViewModel @Inject constructor(
    private var generator: IColorsGenerator,
    private var heavyObject: Lazy<HeavyObject>
) : ViewModel() {
    var observable: Observable<Int> = Observable.create {
        it.onNext(((1..5).random()))
    }

    fun getColorObservable(): Observable<Int> = observable.map {
        generator.getColor(it)
    }


    fun instanceCount(): Int = HeavyObject.instantiationCount

    fun callObject() {
        heavyObject.get()
    }

}