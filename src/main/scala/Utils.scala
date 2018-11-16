import scala.io.Source

object Utils {

    def readDnaStrandFromFile(filename: String): String = {
        val lines = Source.fromFile(filename).getLines.toList
        lines.mkString("")
    }
}