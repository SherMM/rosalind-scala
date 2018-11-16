import Dna.{
  solveDna
}

import Rna.{
  solveRna
}

object Main extends App {
  val filename = args(0)
  solveDna(filename)
}