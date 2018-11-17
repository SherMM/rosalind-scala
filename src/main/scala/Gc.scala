import Utils.{
  readFastaAndStrandsFromFile
}

object Gc {

  def calculateGcContent(dna: String): Double = {
    (dna.filter(nuc => nuc == 'C' || nuc == 'G').size / dna.size.toFloat) * 100
  }

  def calculateMaxGcContent(strands: Map[String, String]): (String, Double) = {
    strands.map(group => (group._1, calculateGcContent(group._2))).maxBy(_._2)
  }

  def solveGC(filename: String): Unit = {
    val strands = readFastaAndStrandsFromFile(filename)
    println(calculateMaxGcContent(strands))
  }

}