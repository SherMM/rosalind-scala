import Utils.readDnaStrandFromFile

object Revc {

  def getDnaReverseComplement(dna: String): String = {
    val comps = Map(
      'A' -> 'T', 'T' -> 'A',
      'C' -> 'G', 'G' -> 'C'
    )
    dna.map(nuc => comps(nuc)).mkString("").reverse
  }

  def solveRevc(filename: String): Unit = {
    val dna = readDnaStrandFromFile(filename)
    println(getDnaReverseComplement(dna))
  }

}