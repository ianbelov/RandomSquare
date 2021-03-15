package com.a.randomsquare

import android.graphics.Color

class ColorsGenerator {

    fun getColor(code: Int): Int {
        when (code) {
            1 -> return Color.rgb(0, 145, 234)
            2 -> return Color.rgb(100, 221, 23)
            3 -> return Color.rgb(255, 214, 0)
            4 -> return Color.rgb(213, 0, 0)
            5 -> return Color.rgb(98, 0, 238)
        }
        return 0
    }
}