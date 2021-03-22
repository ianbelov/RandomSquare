package com.a.randomsquare.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.colorsgenerator.Color
import com.a.randomsquare.util.colorsgenerator.IColorsGenerator
import com.a.randomsquare.util.colorsgenerator.NameGenerator
import com.a.randomsquare.util.heavyobjects.HeavyObject
import dagger.Lazy
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
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

    fun getBackgroundColorObservable(): Observable<Color> {
        return observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .filter { x -> x != 4 }
            .map { generator.getColor(it) }
            .subscribeOn(Schedulers.computation())
            .flatMap { code -> Observable.create { it.onNext(Color(NameGenerator.getColorName(code),code))}}
    }


    fun instanceCount(): Int = HeavyObject.instantiationCount

    fun callObject() {
        heavyObject.get()
    }

}