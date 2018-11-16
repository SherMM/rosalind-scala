object Rna {

  def transcribeDnaToRna(dna: String): String = {
    dna.map(nuc => if (nuc == 'T') "U" else nuc).mkString("")
  }
  
}