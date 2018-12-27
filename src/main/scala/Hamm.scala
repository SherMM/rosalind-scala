import Utils.readDnaStrandsFromFile


object Hamm {

  def calculateHammingDistance(strandA: String, strandB: String): Int = {
    strandA.zip(strandB).map(tup => if (tup._1 != tup._2) 1 else 0).sum
  }


  def solveHamm(filename: String): Unit = {
    val (strandA, strandB) = readDnaStrandsFromFile(filename)
    println(calculateHammingDistance(strandA, strandB))
  }

}