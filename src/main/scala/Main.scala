import Dna.{
  solveDna
}

import Rna.{
  solveRna
}

import Revc.{
  solveRevc
}

import GC.{
  solveGC
}

object Main extends App {
  val filename = args(0)
  solveGC(filename)
}