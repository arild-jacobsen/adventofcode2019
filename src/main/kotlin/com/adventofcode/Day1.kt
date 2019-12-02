package com.adventofcode

import java.io.File

object Day1 {
    private fun readInputs() = File("src/main/resources/day1_input.txt")
        .readLines()
        .map { it.toInt() }

    private fun fuelCost(mass: Int) = mass / 3 - 2

    private fun recursiveFuelCost(mass: Int): Int {
        val fuel = fuelCost(mass)
        return when {
            fuel <= 0 -> 0
            else -> fuel + recursiveFuelCost(fuel)
        }
    }

    private tailrec fun tailRecursiveFuelCost(accumulator: Long, mass: Int): Long {
        val fuel = fuelCost(mass)
        return when {
            fuel <= 0 -> accumulator
            else -> tailRecursiveFuelCost(accumulator + fuel, fuel)
        }
    }

    fun calculateFuelCostForMass(moduleMasses: Iterable<Int>) =
        moduleMasses.fold(0L) { accumulator, mass ->
            accumulator + fuelCost(mass)
        }

    fun calculateTotalFuelCostIncludingFuelMass(
        moduleMasses: Iterable<Int>
    ) = moduleMasses.asSequence()
        .flatMap { mass ->
            generateSequence(
                { fuelCost(mass).lessThanOneToNull() },
                { fuelCost(it).lessThanOneToNull() }
            )
        }
        .map { it.toLong() }
        .sum()

    fun calculateTotalFuelCostIncludingFuelMassRecursive(moduleMasses: Iterable<Int>) =
        moduleMasses.fold(0L) { acc, mass -> acc + recursiveFuelCost(mass) }

    fun calculateTotalFuelCostIncludingFuelMassTailRecursive(moduleMasses: Iterable<Int>) =
        moduleMasses.fold(0L) { acc, mass -> acc + tailRecursiveFuelCost(0L, mass) }

    fun solveProblem1(): Long {
        val inputs = readInputs()
        return calculateFuelCostForMass(inputs)
    }

    fun solveProblem2(): Long {
        val inputs = readInputs()
        return calculateTotalFuelCostIncludingFuelMassTailRecursive(inputs)
    }

    fun solve() {
        println("Solution for day 1 problem 1: ${solveProblem1()}")
        println("Solution for day 1 problem 2: ${solveProblem2()}")
    }
}

private fun Int.lessThanOneToNull() = when {
    this > 0 -> this
    else -> null
}