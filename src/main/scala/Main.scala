import Dna.{
  countNucleotides,
  printNucleotideCounts
}

import Utils.{
  readDnaStrandFromFile
}

import Rna.{
  transcribeDnaToRna
}


object Main extends App {
  val filename = args(0)
  val dna = readDnaStrandFromFile(filename)
  val rna = transcribeDnaToRna(dna)
  println(rna)
}