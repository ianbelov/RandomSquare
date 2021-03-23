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
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
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

    fun getColorObservable(): Observable<Int> = observable.map { colorGenerator.getColor(it) }
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())

    fun getBackgroundColorObservable(): Observable<Color> {
        return observable
            .filter { x -> x != 4 }
            .doAfterNext { Log.d("Filter", Thread.currentThread().name) }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .map { code -> generateColor(code) }
            .doAfterNext { Log.d("Map", Thread.currentThread().name) }
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterNext { Log.d("Observe", Thread.currentThread().name) }
    }


    private fun generateColor(code: Int): Color =
        Color(nameGenerator.getColorName(code), colorGenerator.getColor(code))

    fun instanceCount(): Int = HeavyObject.instantiationCount

    fun callObject() {
        heavyObject.get()
    }

}