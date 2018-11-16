import Dna.{
  solveDna
}

import Rna.{
  solveRna
}

import Revc.{
  solveRevc
}

object Main extends App {
  val filename = args(0)
  solveRevc(filename)
}