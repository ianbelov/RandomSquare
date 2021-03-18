package com.a.randomsquare.util.heavyobjects

class HeavyObject {

    var firstArray = IntArray(300000) { (1..10).random() }
    var secondArray = IntArray(300000) { (1..10).random() }

    companion object {
        var instantiationCount: Int = 0
    }

    init {
        instantiationCount++
    }

}