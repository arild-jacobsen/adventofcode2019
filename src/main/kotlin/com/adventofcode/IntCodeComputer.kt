package com.adventofcode

object IntCodeComputer {
    private var mem: IntArray = intArrayOf()

    private var reg1 = 0
    private var reg2 = 0

    private val add = { reg1 + reg2 }
    private val mul = { reg1 * reg2 }

    private fun execute(op: () -> Int, pos: Int) {
        reg1 = mem[mem[pos + 1]]
        reg2 = mem[mem[pos + 2]]
        mem[mem[pos + 3]] = op()
    }

    fun setMem(input: IntArray) {
        mem = input.copyOf()
    }

    fun getMem() = mem

    fun run() {
        var pos = 0
        while (true) {
            when (mem[pos]) {
                1 -> execute(add, pos)
                2 -> execute(mul, pos)
                99 -> return
            }
            pos += 4
        }
    }
}