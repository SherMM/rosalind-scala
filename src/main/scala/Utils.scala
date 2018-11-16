import scala.io.Source

object Utils {

    def readDnaStrandFromFile(filename: String): String = {
        val lines = Source.fromFile(filename).getLines.toList
        lines.mkString("")
    }


    def readFastaAndStrandsFromFile(filename: String): Map[String, String] = {
        val lines = Source.fromFile(filename).getLines.toList
        processFastaStrands(lines, "", Map())
    }


    def processFastaStrands(lines: List[String], code: String, strands: Map[String, String]): Map[String, String] = {
        if (lines.isEmpty) {
            strands
        } else {
            val line::rest = lines
            if (line.startsWith(">")) {
                val fasta = line.stripPrefix(">")
                processFastaStrands(rest, fasta, strands + (fasta -> ""))
            } else {
                processFastaStrands(rest, code, strands + (code -> strands(code).concat(line)))
            }
        }
    }
}