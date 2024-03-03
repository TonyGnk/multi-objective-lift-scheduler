package test_rules

import Sift

fun test1ApplyOneWorkerInSift() {

    //? Δε γίνεται ένας εργαζόμενος να καλύπτει δύο θέσεις σε μια βάρδια

    println("\nΔημιουργούμε μια νέα βάρδια που θα έχει 3 θέσεις (Όπως η πρωινή βάρδια)")
    val sift = Sift(1, 3)
    sift.print()

    println("Γίνεται ανάθεση θέσεων 1 και 2 σε δύο εργαζόμενους")
    sift.setWorkerInAnyNotFixedRange(2)
    sift.setWorkerInAnyNotFixedRange(5)
    sift.printNew() //!Πρόβλημα

    println("Εφαρμόζουμε τον περιορισμό και βλέπουμε ότι από τη θέση 3 αφαιρέθηκαν οι εργαζόμενοι που ορίστηκαν στις άλλες θέσεις")
    sift.applyOneWorkerInSift()

    sift.printNew()
}