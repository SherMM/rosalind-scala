import Utils.readDnaStrandFromFile

object Rna {

  def transcribeDnaToRna(dna: String): String = {
    dna.map(nuc => if (nuc == 'T') "U" else nuc).mkString("")
  }


  def solveRna(filename: String): Unit = {
    val dna = readDnaStrandFromFile(filename)
    println(transcribeDnaToRna(dna))
  }
  
}