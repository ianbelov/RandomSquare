package com.a.randomsquare.generator.colornamegenerator

import javax.inject.Inject

class NameGeneratorImpl @Inject constructor(): INameGenerator {
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