package com.a.randomsquare.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.colorsgenerator.IColorsGenerator
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@SuppressLint("CheckResult")
class SecondViewModel @Inject constructor(
    private var generator: IColorsGenerator,
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

}