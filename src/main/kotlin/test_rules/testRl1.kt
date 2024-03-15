package test_rules

import Shift
import printGreen

fun test1ApplyOneWorkerInSift() {
    println("\nΕφαρμογή 1ου Περιορισμού")
    //? Δε γίνεται ένας εργαζόμενος να καλύπτει δύο θέσεις σε μια βάρδια

    printGreen("\nΔημιουργείται μια νέα βάρδια 3 θέσεων (Όπως η πρωινή βάρδια)")
    val sift = Shift()
    sift.print()


    printGreen("Γίνεται ανάθεση των θέσεων 1 και 2 σε δύο εργαζόμενους")
    sift.setWorkerInAnyNotFixedRange(2)
    sift.setWorkerInAnyNotFixedRange(5)
    sift.print() //!Πρόβλημα


    printGreen("Εφαρμόζουμε τον περιορισμό και βλέπουμε ότι στη θέση 3 αφαιρέθηκαν οι εργαζόμενοι που ορίστηκαν στις άλλες θέσεις")
    sift.applyOneWorkerInShift()
    sift.print()

    println("________________________________________________")
}