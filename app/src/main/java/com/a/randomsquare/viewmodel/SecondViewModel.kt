package com.a.randomsquare.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.colorsgenerator.IColorsGenerator
import com.a.randomsquare.util.heavyobjects.HeavyObject
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject
import javax.inject.Provider

@SuppressLint("CheckResult")
class SecondViewModel @Inject constructor(
    private var generator: IColorsGenerator,
    private var heavyObject: Provider<HeavyObject>
) : ViewModel() {

    var colorCodeLiveData: MutableLiveData<Int> = MutableLiveData()
    var observable: Observable<Int> = Observable.create {
        it.onNext(((1..5).random()))
    }

    fun generateRandomColor() {
        observable.map { generator.getColor(it) }
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { colorCodeLiveData.value = it }
    }

    fun instanceCount(): Int = HeavyObject.instantiationCount

    fun callObject() {
        heavyObject.get()
    }

}