package com.a.randomsquare

import android.content.Context
import android.content.res.Resources
import android.util.Log
import androidx.core.content.ContextCompat

class ColorsGenerator {

    private val BLUE_COLOR_CODE: Int = -16739862
    private val GREEN_COLOR_CODE: Int = -10167017
    private val YELLOW_COLOR_CODE: Int = -10752
    private val RED_COLOR_CODE: Int = -2818048
    private val PURPLE_COLOR_CODE: Int = -4487428

    fun getColor(code: Int): Int {
        when (code) {
            1 -> {
                return BLUE_COLOR_CODE
            }
            2 -> {
                return GREEN_COLOR_CODE
            }
            3 -> {
                return YELLOW_COLOR_CODE
            }
            4 -> {
                return RED_COLOR_CODE
            }
            5 -> {
                return PURPLE_COLOR_CODE
            }
        }
        return 0
    }
}