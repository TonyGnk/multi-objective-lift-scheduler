package test_rules

import Week
import printGreen

fun test2PreventTheSameWorkerInTwoShifts() {
    println("\nΕφαρμογή 2ου Περιορισμού")
    //? Δε γίνεται ένας εργαζόμενος να εργαστεί δύο συνεχόμενες βάρδιες

    printGreen("\nΔημιουργείται μια νέα εβδομάδα 1 ημέρας")
    val testWeek = Week(1)
    testWeek.print()


    printGreen("Γίνεται ανάθεση των θέσεων 1 και 2 σε δύο εργαζόμενους")
    testWeek.solutionList.first().setWorkerInAnyNotFixedRange(2)
    testWeek.solutionList.first().setWorkerInAnyNotFixedRange(5)
    testWeek.print()


    printGreen("Εφαρμόζεται ο περιορισμός RL-1")
    testWeek.solutionList.first().applyOneWorkerInSift()
    testWeek.print()


    printGreen("Αφαιρούνται οι εργαζόμενοι των πρώτων βάρδιων απο τις δεύτερες βάρδιες της πρώτης μέρας")
    //testWeek.solutionList.first().removeWorkersFromContinuousShift()
    testWeek.print()

    println("________________________________________________")

}