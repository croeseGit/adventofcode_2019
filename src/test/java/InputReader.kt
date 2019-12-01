import java.io.BufferedReader

class InputReader {

    fun getLines(fileName: String): List<String> {
        val stream = this.javaClass.getResourceAsStream(fileName)
        return BufferedReader(stream.reader()).readLines()
    }
}
