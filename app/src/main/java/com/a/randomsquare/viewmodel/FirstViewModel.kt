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

    fun getColorObservable(): Observable<Int> = observable.map {
        colorGenerator.getColor(it)
    }

    fun getBackgroundColorObservable(fragment: FirstFragment) {
        observable
            .filter { x -> x != 4 }
            .subscribeOn(Schedulers.io())
            .doAfterNext { Log.d("Map",Thread.currentThread().name) }
            .flatMap { code ->
                Observable.create<Color> {
                    it.onNext(
                        generateColor(code)
                    )
                    Log.d("FlatMap", Thread.currentThread().name)
                }.subscribeOn(Schedulers.computation())
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { onNext ->
                Log.d("Subscribe",Thread.currentThread().name)
                fragment.setBackgroundColor(onNext)
            }
    }

    private fun generateColor(code: Int): Color =
        Color(nameGenerator.getColorName(code), colorGenerator.getColor(code))

    fun instanceCount(): Int = HeavyObject.instantiationCount

    fun callObject() {
        heavyObject.get()
    }

}