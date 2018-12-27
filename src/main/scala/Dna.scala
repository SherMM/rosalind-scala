import Utils.readDnaStrandFromFile

object Dna {

  def countNucleotides(dna: String): Map[Char, Int] = {
    dna.map(nuc => (nuc, 1)).groupBy(_._1).mapValues(_.map(_._2).sum)
  }

  def solveDna(filename: String): Unit = {
    val dna = readDnaStrandFromFile(filename)
    val counts = countNucleotides(dna)
    "ACGT".foreach(nuc => printf("%s ", counts(nuc)))
  }

}