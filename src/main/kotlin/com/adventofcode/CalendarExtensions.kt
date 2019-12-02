package com.adventofcode

import java.util.*

fun Calendar.dayOfMonth(): String {
    val day = get(Calendar.DAY_OF_MONTH)
    return "${day}${when (day % 10) {
        1 -> "st"
        2 -> "nd"
        3 -> "rd"
        else -> "th"
    }}"
}

fun Calendar.month() = when (get(Calendar.MONTH)) {
    0 -> "January"
    1 -> "February"
    2 -> "March"
    3 -> "April"
    4 -> "May"
    5 -> "June"
    6 -> "July"
    7 -> "August"
    8 -> "September"
    9 -> "October"
    10 -> "November"
    11 -> "December"
    else -> "NaNember"
}