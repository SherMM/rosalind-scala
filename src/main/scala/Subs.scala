import Utils.{
  readDnaStrandsFromFile
}


object Subs {

  def findSharedMotifs(dna: String, sub: String): IndexedSeq[Int] = {
    (0 to dna.size-sub.size)
      .map(i => (i+1, dna.substring(i,i+sub.size)))
      .filter(_._2 == sub)
      .map(_._1)
  }


  def solveSubs(filename: String): Unit = {
    val (dna, sub) = readDnaStrandsFromFile(filename)
    val indexes = findSharedMotifs(dna, sub)
    indexes.foreach(i => printf("%s ", i))
  }


}