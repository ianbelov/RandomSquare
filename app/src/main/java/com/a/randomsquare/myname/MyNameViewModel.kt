package com.a.randomsquare.myname

import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.namegenerator.INameGenerator
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MyNameViewModel @Inject constructor(
    generator: INameGenerator
) : ViewModel() {
    var observable: Observable<String> =
        Observable.just(generator.getName()).subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
}