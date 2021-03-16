package com.a.randomsquare

import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat
import javax.inject.Inject

class ColorsGenerator @Inject constructor(private val context: Context) {

    private var currentColor: Int = ContextCompat.getColor(context, R.color.blue)

    fun getColor(code: Int): Int {
        when (code) {
            1 -> currentColor = ContextCompat.getColor(context, R.color.blue)
            2 -> currentColor = ContextCompat.getColor(context, R.color.green)
            3 -> currentColor = ContextCompat.getColor(context, R.color.yellow)
            4 -> currentColor = ContextCompat.getColor(context, R.color.red)
            5 -> currentColor = ContextCompat.getColor(context, R.color.purple_500)
        }
        return currentColor
    }

    fun getCurrentColor(): Int = currentColor

}