package com.a.randomsquare.util.colorsgenerator

class NameGenerator {
    fun getName(code: Int): String {
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