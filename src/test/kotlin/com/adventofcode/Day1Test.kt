package com.adventofcode

import io.kotlintest.forAll
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

class Day1Test {
    @Test
    fun `calculate fuel for mass`() {
        forAll(
            // GIVEN
            12 to 2,
            14 to 2,
            1969 to 654,
            100756 to 33583
        ) { (mass, expectedFuel) ->
            // WHEN
            val fuel = Day1.calculateFuelCostForMass(listOf(mass))
            // THEN
            fuel shouldBe expectedFuel
        }
    }

    @Test
    fun `calculate fuel for mass and fuel for fuel`() {
        forAll(
            // GIVEN
            14 to 2,
            1969 to 966,
            100756 to 50346
        ) { (mass, expectedFuel) ->
            // WHEN
            val fuel = Day1.calculateTotalFuelCostIncludingFuelMassRecursive(listOf(mass))
            // THEN
            fuel shouldBe expectedFuel
        }
    }

    @Test
    fun `calculate fuel for mass and fuel for fuel without recursion`() {
        forAll(
            // GIVEN
            14 to 2,
            1969 to 966,
            100756 to 50346
        ) { (mass, expectedFuel) ->
            // WHEN
            val fuel = Day1.calculateTotalFuelCostIncludingFuelMass(listOf(mass))
            // THEN
            fuel shouldBe expectedFuel
        }
    }

    @Test
    fun `calculate fuel for mass and fuel for fuel with tail recursion`() {
        forAll(
            // GIVEN
            14 to 2,
            1969 to 966,
            100756 to 50346
        ) { (mass, expectedFuel) ->
            // WHEN
            val fuel = Day1.calculateTotalFuelCostIncludingFuelMassTailRecursive(listOf(mass))
            // THEN
            fuel shouldBe expectedFuel
        }
    }

    @Test
    fun `problem1 solution`() {
        Day1.solveProblem1() shouldBe 3488702
    }

    @Test
    fun `problem2 solution`() {
        Day1.solveProblem2() shouldBe 5230169
    }
}

private fun forAll(
    vararg inputs: Pair<Int, Int>,
    fn: (Pair<Int, Int>) -> Unit
) = forAll(inputs, fn)