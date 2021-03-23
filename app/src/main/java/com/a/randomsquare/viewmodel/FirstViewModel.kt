package com.a.randomsquare.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import com.a.randomsquare.ui.FirstFragment
import com.a.randomsquare.util.colorsgenerator.Color
import com.a.randomsquare.util.colorsgenerator.IColorsGenerator
import com.a.randomsquare.util.colorsgenerator.NameGeneratorImpl
import com.a.randomsquare.util.heavyobjects.HeavyObject
import dagger.Lazy
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.Exception
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@SuppressLint("CheckResult")
class FirstViewModel @Inject constructor(
    private var colorGenerator: IColorsGenerator,
    private var heavyObject: Lazy<HeavyObject>,
    private var nameGenerator: NameGeneratorImpl
) : ViewModel() {
    var observable: Observable<Int> = Observable.create {
        it.onNext(((1..5).random()))
    }

    fun getColorObservable(): Observable<Int> =
        observable.map { colorGenerator.getColor(it) }
            .delay(2, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())

    fun getBackgroundColorObservable(): Observable<Color> =
        observable
            .delay(2, TimeUnit.SECONDS)
            .doOnNext { Log.d("Value", it.toString()) }
            .filter { x -> x != 4 }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .map { code -> generateColor(code) }
            .observeOn(AndroidSchedulers.mainThread())


    private fun generateColor(code: Int): Color =
        Color(nameGenerator.getColorName(code), colorGenerator.getColor(code))

    fun instanceCount(): Int = HeavyObject.instantiationCount

    fun callObject() {
        heavyObject.get()
    }

}