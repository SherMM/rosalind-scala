import Dna.{
  solveDna
}

import Rna.{
  solveRna
}

import Revc.{
  solveRevc
}

import Gc.{
  solveGC
}

import Hamm.{
  solveHamm
}

object Main extends App {
  val filename = args(0)
  solveHamm(filename)
}