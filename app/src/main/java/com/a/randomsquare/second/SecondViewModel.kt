package com.a.randomsquare.second

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.colornamegenerator.IColorNameGenerator
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@SuppressLint("CheckResult")
class SecondViewModel @Inject constructor(
    private var generator: IColorNameGenerator,
) : ViewModel() {

    var colorCodeLiveData: MutableLiveData<String> = MutableLiveData()
    var observable: Observable<Int> = Observable.create {
        it.onNext(((1..5).random()))
    }

    fun generateRandomColor() {
        observable.map { generator.getColorName(it) }
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { colorCodeLiveData.value = it }
    }
}