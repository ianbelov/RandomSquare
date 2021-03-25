package com.a.randomsquare.util.colorcodegenerator

import android.content.Context
import androidx.core.content.ContextCompat
import com.a.randomsquare.R
import javax.inject.Inject

class FirstColorsGeneratorImpl @Inject constructor(private val context: Context) :
    IColorsGenerator {

    override fun getColor(code: Int): Int {
        when (code) {
            1 -> return ContextCompat.getColor(context, R.color.black)
            2 -> return ContextCompat.getColor(context, R.color.first_gray)
            3 -> return ContextCompat.getColor(context, R.color.second_gray)
            4 -> return ContextCompat.getColor(context, R.color.third_gray)
            5 -> return ContextCompat.getColor(context, R.color.fourth_gray)
        }
        return ContextCompat.getColor(context, R.color.black)
    }
}