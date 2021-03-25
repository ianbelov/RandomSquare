package com.a.randomsquare.first

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import com.a.randomsquare.generator.colorgenerator.Color
import com.a.randomsquare.generator.colorgenerator.IColorsGenerator
import com.a.randomsquare.generator.namegenerator.NameGeneratorImpl
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@SuppressLint("CheckResult")
class FirstViewModel @Inject constructor(
    private var colorGenerator: IColorsGenerator,
    private var nameGenerator: NameGeneratorImpl
) : ViewModel() {
    var observable: Observable<Int> = Observable.create {
        it.onNext((1..5).random())
        it.onComplete()
    }

    fun getColorObservable(): Observable<Int> =
        observable.map { colorGenerator.getColor(it) }
            .delay(2, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())

    fun getBackgroundColorObservable(): Observable<Color> =
        observable
            .delay(2, TimeUnit.SECONDS)
            .filter { x -> x != 4 }
            .switchIfEmpty(Observable.error(Throwable()))
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .map { code -> generateColor(code) }
            .observeOn(AndroidSchedulers.mainThread())

    private fun generateColor(code: Int): Color {
        Log.d("Generate", code.toString())
        return Color(nameGenerator.getColorName(code), colorGenerator.getColor(code))
    }

}