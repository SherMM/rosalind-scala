object Dna {

  def countNucleotides(dna: String): Map[Char, Int] = {
    dna.map(nuc => (nuc, 1)).groupBy(_._1).mapValues(_.map(_._2).sum)
  }

  def printNucleotideCounts(counts: Map[Char, Int]): Unit = {
    "ACGT".foreach(nuc => printf("%s ", counts(nuc)))
  }

}