package com.a.randomsquare.first

import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.colorcodegenerator.Color
import com.a.randomsquare.util.colorcodegenerator.IColorsGenerator
import com.a.randomsquare.util.colornamegenerator.ColorNameGeneratorImpl
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class FirstViewModel @Inject constructor(
    private var colorGenerator: IColorsGenerator,
    private var nameGenerator: ColorNameGeneratorImpl
) : ViewModel() {
    var observable: Observable<Int> = Observable.create {
        it.onNext((1..5).random())
        it.onComplete()
    }
    var backgroundColorCode: Int = android.graphics.Color.GRAY
    var customSquareColor: Color = Color("Example", android.graphics.Color.TRANSPARENT)

    fun getColorObservable(): Observable<Int> =
        observable.map { colorGenerator.getColor(it) }
            .delay(2, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { backgroundColorCode = it }

    fun getBackgroundColorObservable(): Observable<Color> =
        observable
            .delay(2, TimeUnit.SECONDS)
            .filter { x -> x != 4 }
            .switchIfEmpty(Observable.error(Throwable()))
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .map { code -> generateColor(code) }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { customSquareColor = it }

    private fun generateColor(code: Int): Color = Color(
        nameGenerator.getColorName(code),
        colorGenerator.getColor(code)
    )

}