package puzzle3

import InputReader
import org.junit.Test

const val INPUT_FILE = "input_3.txt"

class Puzzle3 {

    @Test
    fun puzzle3() {
        val input = InputReader().getLines(INPUT_FILE)
        val result = Solver().solve(input)

        println("Puzzle 3: $result")
    }
}
