import Utils.readDnaStrandFromFile

object Dna {

  def countNucleotides(dna: String): Map[Char, Int] = {
    dna.map(nuc => (nuc, 1)).groupBy(_._1).mapValues(_.map(_._2).sum)
  }

  def countNucleotidesRec(dna: String): (Int, Int, Int, Int) = {
    def count(dna: List[Char], a: Int, c: Int, g: Int, t: Int): (Int, Int, Int, Int) = {
      dna match {
        case Nil => (a, c, g, t)
        case 'A'::tail => count(tail, a+1, c, g, t)
        case 'C'::tail => count(tail, a, c+1, g, t)
        case 'G'::tail => count(tail, a, c, g+1, t)
        case 'T'::tail => count(tail, a, c, g, t+1)
        case _::tail => count(tail, a, c, g, t)
      }
    }
    count(dna.toList, 0, 0, 0, 0)
  }

  def solveDna(filename: String): Unit = {
    val dna = readDnaStrandFromFile(filename)
    val counts = countNucleotidesRec(dna)
    println(counts)
  }

}