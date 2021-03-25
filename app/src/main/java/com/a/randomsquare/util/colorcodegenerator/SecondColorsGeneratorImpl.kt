package com.a.randomsquare.util.colorcodegenerator

import android.content.Context
import androidx.core.content.ContextCompat
import com.a.randomsquare.R
import javax.inject.Inject

class SecondColorsGeneratorImpl @Inject constructor(private val context: Context) :
    IColorsGenerator {

    override fun getColor(code: Int): Int {
        when (code) {
            1 -> return ContextCompat.getColor(
                context,
                R.color.blue
            )
            2 -> return ContextCompat.getColor(
                context,
                R.color.green
            )
            3 -> return ContextCompat.getColor(
                context,
                R.color.yellow
            )
            4 -> return ContextCompat.getColor(
                context,
                R.color.red
            )
            5 -> return ContextCompat.getColor(
                context,
                R.color.purple_500
            )
        }
        return ContextCompat.getColor(context, R.color.blue)
    }
}