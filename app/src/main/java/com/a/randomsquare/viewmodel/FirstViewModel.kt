package com.a.randomsquare.viewmodel

import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.colorsgenerator.Color
import com.a.randomsquare.util.colorsgenerator.IColorsGenerator
import com.a.randomsquare.util.colorsgenerator.NameGeneratorImpl
import com.a.randomsquare.util.heavyobjects.HeavyObject
import dagger.Lazy
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class FirstViewModel @Inject constructor(
    private var colorGenerator: IColorsGenerator,
    private var heavyObject: Lazy<HeavyObject>,
    private var nameGenerator: NameGeneratorImpl
) : ViewModel() {
    var observable: Observable<Int> = Observable.create {
        it.onNext(((1..5).random()))
    }

    fun getColorObservable(): Observable<Int> = observable.map {
        colorGenerator.getColor(it)
    }

    fun getBackgroundColorObservable(): Observable<Color> {
        return observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .filter { x -> x != 4 }
            .map { colorGenerator.getColor(it) }
            .subscribeOn(Schedulers.computation())
            .flatMap { code -> Observable.create { it.onNext(Color(nameGenerator.getColorName(code),code))}}
    }


    fun instanceCount(): Int = HeavyObject.instantiationCount

    fun callObject() {
        heavyObject.get()
    }

}