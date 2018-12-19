import Utils.readFastaAndStrandsFromFile

object Cons {

    def countNucleotides(strand: Seq[Char]): Map[Char, Int] = {
        strand.groupBy(nuc => nuc).mapValues(nuc => nuc.size)
    }

    def calculateColumn(col: Map[Char, Int]): List[Int] = {
        "ACGT".map(nuc => col.getOrElse(nuc, 0)).toList
    }

    def calculateConsensusOfStrands(strands: Seq[String]): (String, List[List[Int]]) = {
        val counts = strands.transpose
          .map(strand => countNucleotides(strand))
        val consensus = counts.map(m => m.maxBy(_._2)).map(_._1).mkString
        val matrix = counts.map(m => calculateColumn(m)).toList.transpose
        (consensus, matrix)
    }

    def solveCons(filename: String): Unit = {
        val strands = readFastaAndStrandsFromFile(filename).values.toSeq
        val (consensus, matrix) = calculateConsensusOfStrands(strands)
        val nucleotides = "ACGT"
        println(consensus)
        (0 to 3).foreach(i => println(s"${nucleotides(i)}: ${matrix(i).mkString(" ")}"))
    }
}