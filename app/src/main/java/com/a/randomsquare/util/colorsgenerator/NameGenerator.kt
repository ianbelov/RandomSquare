package com.a.randomsquare.util.colorsgenerator

object NameGenerator {
    fun getColorName(code: Int): String {
        when (code) {
            -16739862 -> return "BLUE"
            -10167017 -> return "GREEN"
            -10752 -> return "YELLOW"
            -2818048 -> return "RED"
            -10354450 -> return "PURPLE"
        }
        return "BLUE"
    }
}