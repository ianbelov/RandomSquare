package com.a.randomsquare.util.colornamegenerator

import javax.inject.Inject

class ColorNameGeneratorImpl @Inject constructor() : IColorNameGenerator {

    override fun getColorName(code: Int): String {
        when (code) {
            1 -> return "BLUE"
            2 -> return "GREEN"
            3 -> return "YELLOW"
            4 -> return "RED"
            5 -> return "PURPLE"
        }
        return "BLUE"
    }
}