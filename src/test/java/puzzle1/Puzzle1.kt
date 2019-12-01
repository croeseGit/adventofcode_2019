package puzzle1

import InputReader
import org.junit.Test

const val INPUT_FILE = "input_1.txt"

class Puzzle1 {

    @Test
    fun puzzle1() {
        val input = InputReader().getLines(INPUT_FILE)
        val result = Solver().solve(input)

        println("Puzzle 1: $result")
    }
}
