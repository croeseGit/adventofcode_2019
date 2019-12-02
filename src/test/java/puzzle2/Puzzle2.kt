package puzzle2

import InputReader
import org.junit.Test

const val INPUT_FILE = "input_2.txt"

class Puzzle2 {

    @Test
    fun puzzle2() {
        val input = InputReader().getInput(INPUT_FILE)
        val result = Solver().solve(input)

        println("Puzzle 2: $result")
    }
}
