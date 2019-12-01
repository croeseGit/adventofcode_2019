package puzzle1

import kotlin.math.floor

class Solver {

    fun solve(lines: List<String>): Result {

        val result = Result()

        for (line in lines) {
            result.fuelForMass += getFuelForMass(line.toInt())
            result.fuelForMassAndFuel += getFuelForMassAndResultingFuel(line.toInt())
        }

        return result
    }

    private fun getFuelForMass(mass: Int): Int {
        return floor((mass / 3).toDouble()).toInt() - 2
    }

    private fun getFuelForMassAndResultingFuel(mass: Int): Int {
        val fuel = getFuelForMass(mass)
        if (fuel <= 0) {
            return 0
        }

        return fuel + getFuelForMassAndResultingFuel(fuel)
    }
}
