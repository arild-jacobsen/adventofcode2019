package com.adventofcode

import io.kotlintest.matchers.collections.shouldContainExactly
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

class Day2Test {

    @Test
    fun `simple addition`() {
        // GIVEN
        val input = intArrayOf(1, 0, 0, 0, 99)
        val expectedResult = intArrayOf(2, 0, 0, 0, 99)

        // WHEN
        val result = Day2.execute(input)

        // THEN
        result.shouldContainExactly(expectedResult)
    }

    @Test
    fun `simple multiplication`() {
        // GIVEN
        val input = intArrayOf(2, 3, 0, 3, 99)
        val expectedResult = intArrayOf(2, 3, 0, 6, 99)

        // WHEN
        val result = Day2.execute(input)

        // THEN
        result.shouldContainExactly(expectedResult)
    }

    @Test
    fun `bigger multiplication`() {
        // GIVEN
        val input = intArrayOf(2, 4, 4, 5, 99, 0)
        val expectedResult = intArrayOf(2, 4, 4, 5, 99, 9801)

        // WHEN
        val result = Day2.execute(input)

        // THEN
        result.shouldContainExactly(expectedResult)
    }

    @Test
    fun `complexer int code`() {
        // GIVEN
        val input = intArrayOf(1, 1, 1, 4, 99, 5, 6, 0, 99)
        val expectedResult = intArrayOf(30, 1, 1, 4, 2, 5, 6, 0, 99)

        // WHEN
        val result = Day2.execute(input)

        // THEN
        result.shouldContainExactly(expectedResult)
    }

    @Test
    fun `problem1 solution`() {
        Day2.solveProblem1() shouldBe 9706670
    }

    @Test
    fun `problem2 solution`() {
        Day2.solveProblem2() shouldBe 2552
    }
}

private fun IntArray.shouldContainExactly(expected: IntArray) = toList().shouldContainExactly(*expected.toTypedArray())