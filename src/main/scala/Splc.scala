import Utils.readFastaStrandsFromFile
import Rna.transcribeDnaToRna
import Prot.translateRnaToProtein

object Splc {

    def getSplicedProtein(dna: String, introns: List[String]): String = {
        if (introns.isEmpty) {
            dna
        } else {
            val intron::rest = introns
            getSplicedProtein(dna.replace(intron, ""), rest) 
        }
    }

    def solveSplc(filename: String): Unit = {
        val strands = readFastaStrandsFromFile(filename).toList
        val dna::introns = strands
        val spliced = getSplicedProtein(dna, introns)
        val rna = transcribeDnaToRna(spliced)
        println(translateRnaToProtein(rna))
    }

}