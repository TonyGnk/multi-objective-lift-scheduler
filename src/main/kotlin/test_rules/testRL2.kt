package test_rules

import Week

fun test2PreventTheSameWorkerInTwoShifts() {

    //? Δε γίνεται ένας εργαζόμενος να καλύπτει δύο θέσεις σε μια βάρδια

    println("\nΔημιουργείται μια νέα εβδομάδα 1 ημέρας")
    val testWeek = Week(1)
    testWeek.printNew()


    println("Γίνεται ανάθεση των θέσεων 1 και 2 σε δύο εργαζόμενους")
    testWeek.solutionList.first().setWorkerInAnyNotFixedRange(2)
    testWeek.solutionList.first().setWorkerInAnyNotFixedRange(5)
    testWeek.printNew()


    println("Εφαρμόζεται ο περιορισμός RL-1")
    testWeek.solutionList.first().applyOneWorkerInSift()
    testWeek.printNew()


    println("Αφαιρούνται οι εργαζόμενοι των πρώτων βάρδιων απο τις δεύτερες βάρδιες της πρώτης μέρας")
    testWeek.solutionList.first().removeWorkersFromSecondShift(testWeek.solutionList)
    testWeek.printNew()

}