package com.a.randomsquare.generator.namegenerator

import javax.inject.Inject

class MyNameGeneratorImpl @Inject constructor() : INameGenerator {
    private val name = "Ivan Belov"
    override fun getName(): String = name
}