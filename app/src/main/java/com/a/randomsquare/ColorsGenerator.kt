package com.a.randomsquare

import android.content.Context
import android.content.res.Resources
import androidx.core.content.ContextCompat

class ColorsGenerator {

    fun getColor(context: Context, code: Int):Int {
        when (code) {
            1 -> return ContextCompat.getColor(context, R.color.blue)
            2 -> return ContextCompat.getColor(context, R.color.green)
            3 -> return ContextCompat.getColor(context, R.color.yellow)
            4 -> return ContextCompat.getColor(context, R.color.red)
            5 -> return ContextCompat.getColor(context, R.color.black)
        }
        return 0
    }
}