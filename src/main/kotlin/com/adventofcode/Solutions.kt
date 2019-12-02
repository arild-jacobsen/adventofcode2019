package com.adventofcode

import java.util.*

fun main() {
    val today = Calendar.getInstance()
    println("Merry ${today.dayOfMonth()} of ${today.month()}!\n".toUpperCase())

    Day1.solve()
    Day2.solve()
}

