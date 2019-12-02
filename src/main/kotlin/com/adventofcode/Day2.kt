package com.adventofcode

import java.io.File

object Day2 {
    fun execute(input: IntArray): IntArray {
        IntCodeComputer.setMem(input)
        IntCodeComputer.run()
        return IntCodeComputer.getMem()
    }

    private fun readInput() = File("src/main/resources/day2_input.txt")
        .readLines()
        .flatMap { it.split(",") }
        .map { it.toInt() }
        .toIntArray()

    fun solveProblem1(): Int {
        val inputs = readInput()
        // restore to 1202 program alarm
        inputs[1] = 12
        inputs[2] = 2

        return execute(inputs)[0]
    }

    fun solveProblem2(): Int {
        val inputs = readInput()
        val result = generateSequence(0 to 0) {
            when {
                it.second < 99 -> it.first to it.second + 1
                it.first < 99 -> it.first + 1 to 0
                else -> null
            }
        }
            .map {
                inputs[1] = it.first
                inputs[2] = it.second
                Triple(it.first, it.second, execute(inputs)[0])
            }
            .first { it.third == 19690720 }
        return 100 * result.first + result.second
    }

    fun solve() {
        val result = solveProblem1()
        println("Solution for day 2 problem 1: $result")

        val solution = solveProblem2()
        println("Solution for day 2 problem 2: $solution")
    }
}