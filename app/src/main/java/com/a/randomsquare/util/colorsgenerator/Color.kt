package com.a.randomsquare.util.colorsgenerator

import androidx.core.content.ContextCompat
import com.a.randomsquare.R

data class Color constructor(val name: String) {
    val code: Int = getColorCode(name)

    private fun getColorCode(name: String): Int {
        when (name) {
            "BLUE" -> return -16739862
            "GREEN" -> return -10167017
            "YELLOW" -> return -10752
            "RED" -> return -2818048
            "PURPLE" -> return -10354450
        }
        return -16739862
    }

}