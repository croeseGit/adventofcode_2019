package puzzle2

class Solver {

    fun solve(input: String): Result {
        val program = compile(input)
        restoreProgram(program, 12, 2)
        executeProgram(program)

        return Result(
            valueLeftOnPosition0 = program[0],
            nounAndVerb = findNounAndVerb(input)
        )
    }

    private fun findNounAndVerb(input: String): Int? {
        for (noun in 0..99) {
            for (verb in 0..99) {
                val program = compile(input)
                restoreProgram(program, noun, verb)
                executeProgram(program)
                if (program[0] == 19690720) {
                    return 100 * noun + verb
                }
            }
        }

        return null
    }

    private fun restoreProgram(program: MutableMap<Int, Int>, noun: Int, verb: Int) {
        program[1] = noun
        program[2] = verb
    }

    private fun executeProgram(program: MutableMap<Int, Int>) {
        execute(program, 0)
    }

    private fun execute(program: MutableMap<Int, Int>, position: Int) {
        val opCode = program[position]
        if (opCode == null || opCode == 99) {
            return
        }

        val positionA = program[position + 1]
        val positionB = program[position + 2]
        val positionResult = program[position + 3]

        when (opCode) {
            1 -> {
                program[positionResult!!] = program[positionA]!! + program[positionB]!!
            }
            2 -> {
                program[positionResult!!] = program[positionA]!! * program[positionB]!!
            }
            else -> {
                throw RuntimeException()
            }
        }

        execute(program, position + 4)
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
