package puzzle3

import kotlin.math.abs

class Solver {

    fun solve(input: List<String>): Result {
        val gridWireA = createGrid(input[0])
        val gridWireB = createGrid(input[1])

        return getResult(gridWireA, gridWireB)
    }

    private fun createGrid(line: String): MutableMap<Int, MutableMap<Int, Int>> {
        val instructions = line.split(",")
        val position = Position()
        var steps = 0
        val grid = mutableMapOf<Int, MutableMap<Int, Int>>()

        for (instruction in instructions) {
            for (i in 0 until instruction.drop(1).toInt()) {
                when {
                    instruction.startsWith('U') -> position.y += 1
                    instruction.startsWith('D') -> position.y += -1
                    instruction.startsWith('R') -> position.x += 1
                    instruction.startsWith('L') -> position.x += -1
                }
                steps++
                grid.getOrPut(position.y) { mutableMapOf() }.getOrPut(position.x) { steps }
            }
        }

        return grid
    }

    private fun getResult(
        gridA: MutableMap<Int, MutableMap<Int, Int>>,
        gridB: MutableMap<Int, MutableMap<Int, Int>>
    ): Result {
        val distances = mutableListOf<Int>()
        val steps = mutableListOf<Int>()
        for ((y, row) in gridA) {
            for ((x, _) in row) {
                if (y == 0 && x == 0) {
                    continue
                }
                val stepsA = gridA[y]!![x]!!
                val stepsB = gridB.getOrDefault(y, mutableMapOf()).getOrDefault(x, null)
                if (stepsB != null) {
                    distances.add(abs(x) + abs(y))
                    steps.add(stepsA + stepsB)
                }
            }
        }
        return Result(
            smallestDistance = distances.min(),
            fewestSteps = steps.min()
        )
    }

    data class Position(var x: Int = 0, var y: Int = 0)
}
