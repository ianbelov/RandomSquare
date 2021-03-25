package com.a.randomsquare.util.namegenerator

import javax.inject.Inject

class MyNameGeneratorImpl @Inject constructor() : INameGenerator {
    private val name = "Ivan Belov"
    override fun getName(): String = name
}