import java.io.BufferedReader

class InputReader {

    fun getInput(fileName: String): String {
        val stream = this.javaClass.getResourceAsStream(fileName)
        return BufferedReader(stream.reader()).use { reader -> reader.readText() }
    }

    fun getLines(fileName: String): List<String> {
        val stream = this.javaClass.getResourceAsStream(fileName)
        return BufferedReader(stream.reader()).readLines()
    }
}
