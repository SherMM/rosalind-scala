import Dna.solveDna
import Rna.solveRna
import Revc.solveRevc
import Gc.solveGC
import Hamm.solveHamm
import Prot.solveProt
import Subs.solveSubs
import Cons.solveCons
import Prtm.solvePrtm
import Splc.solveSplc


object Main extends App {
  val filename = args(0)
  solveDna(filename)
}