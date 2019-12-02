package puzzle2

class Solver {

    fun solve(input: String): Result {
        return Result(
            part1 = executeWithNounAndVerb(input, 12, 2),
            part2 = findNounAndVerb(input)
        )
    }

    private fun findNounAndVerb(input: String): Int? {
        for (noun in 0..99) {
            for (verb in 0..99) {
                val result = executeWithNounAndVerb(input, noun, verb)
                if (result == 19690720) {
                    return 100 * noun + verb
                }
            }
        }
        return null
    }

    private fun executeWithNounAndVerb(input: String, noun: Int, verb: Int): Int {
        val program = compile(input)
        program[1] = noun
        program[2] = verb
        executeProgram(program)
        return program[0]!!
    }

    private fun executeProgram(program: MutableMap<Int, Int>) {
        var pointer = 0
        var opCode = program[0]

        while (opCode != 99) {
            val pointerA = program[pointer + 1]
            val pointerB = program[pointer + 2]
            val pointerResult = program[pointer + 3]

            when (opCode) {
                1 -> {
                    program[pointerResult!!] = program[pointerA]!! + program[pointerB]!!
                }
                2 -> {
                    program[pointerResult!!] = program[pointerA]!! * program[pointerB]!!
                }
            }

            pointer += 4
            opCode = program[pointer]!!
        }

    }

    private fun compile(input: String): MutableMap<Int, Int> {
        val program = mutableMapOf<Int, Int>()

        val serialized = input.split(",").map { it.toInt() }
        for ((index, nr) in serialized.withIndex()) {
            program[index] = nr
        }

        return program
    }

}
