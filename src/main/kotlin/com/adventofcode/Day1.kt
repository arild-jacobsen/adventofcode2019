package com.adventofcode

import java.io.File

object Day1 {
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

    fun solve() {
        val inputs = File("src/main/resources/day1_input.txt")
            .readLines()
            .map { it.toInt() }

        arrayOf(
            Day1::calculateFuelCostForMass,
            Day1::calculateTotalFuelCostIncludingFuelMassTailRecursive
        ).forEachIndexed { index, solution ->
            println("Solution for day 1 problem ${index + 1}: ${solution(inputs)}")
        }
    }
}

private fun Int.lessThanOneToNull() = when {
    this > 0 -> this
    else -> null
}