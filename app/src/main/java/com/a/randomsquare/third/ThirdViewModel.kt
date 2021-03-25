package com.a.randomsquare.third

import androidx.lifecycle.ViewModel
import com.a.randomsquare.generator.namegenerator.INameGenerator
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ThirdViewModel @Inject constructor(
    private var generator: INameGenerator
) : ViewModel() {
    var observable = Observable.just(generator.getName()).subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())


}