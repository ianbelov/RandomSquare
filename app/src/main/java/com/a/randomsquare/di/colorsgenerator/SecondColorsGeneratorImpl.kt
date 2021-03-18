package com.a.randomsquare.di.colorsgenerator

import android.content.Context
import androidx.core.content.ContextCompat
import com.a.randomsquare.R

class SecondColorsGeneratorImpl(private val context: Context): IColorsGenerator {

    override fun getColor(code: Int): Int {
        when (code) {
            1 -> return ContextCompat.getColor(context,
                R.color.blue
            )
            2 -> return ContextCompat.getColor(context,
                R.color.green
            )
            3 -> return ContextCompat.getColor(context,
                R.color.yellow
            )
            4 -> return ContextCompat.getColor(context,
                R.color.red
            )
            5 -> return ContextCompat.getColor(context,
                R.color.purple_500
            )
        }
        return ContextCompat.getColor(context, R.color.blue)
    }

}