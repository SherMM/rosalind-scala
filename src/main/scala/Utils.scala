import scala.io.Source

object Utils {

  def readDnaStrandFromFile(filename: String): String = {
    val lines = Source.fromFile(filename).getLines.toList
    lines.mkString("")
  }


  def readDnaStrandsFromFile(filename: String): (String, String) = {
    val lines = Source.fromFile(filename).getLines.toList
    (lines(0), lines(1))
  }


  def readFastaAndStrandsFromFile(filename: String): Map[String, String] = {
    val lines = Source.fromFile(filename).getLines.toList
    processFastaAndStrands(lines, "", Map())
  }


  def processFastaAndStrands(lines: List[String], code: String, strands: Map[String, String]): Map[String, String] = {
    if (lines.isEmpty) {
      strands
    } else {
      val line::rest = lines
      if (line.startsWith(">")) {
        val fasta = line.stripPrefix(">")
        processFastaAndStrands(rest, fasta, strands + (fasta -> ""))
      } else {
        processFastaAndStrands(rest, code, strands + (code -> strands(code).concat(line)))
      }
    }
  }


  def readFastaStrandsFromFile(filename: String): Vector[String] = {
    val lines = Source.fromFile(filename).getLines.toList
    processFastaStrands(lines, -1, Vector())
  }


  def processFastaStrands(lines: List[String], index: Int, strands: Vector[String]): Vector[String] = {
    if (lines.isEmpty) {
      strands
    } else {
      val line::rest = lines
      if (line.startsWith(">")) {
        processFastaStrands(rest, index + 1, strands :+ "")
      } else {
        processFastaStrands(rest, index, strands.slice(0, index) :+ strands(index).concat(line))
      }
    }
  }


}