package test_rules

import Week

// This is a test of how the limit RL-1 is applied
fun test2PreventTheSameWorkerInTwoShifts() {

    //? Δε γίνεται ένας εργαζόμενος να καλύπτει δύο θέσεις σε μια βάρδια
    val testWeek = Week(1)
    val sift = testWeek.solutionList[0]

    //> Δημιουργούμε μια νέα βάρδια που θα έχει 3 θέσεις (Όπως η πρωινή βάρδια)


    //> Βλέπουμε ότι και η 3 θέσεις (Ranges) έχουν όλους τους εργαζόμενους
    //sift.print()

    //> Υποθέτουμε ότι με κάποιο τρόπο γίνεται ανάθεση των θέσεων 1 και 2 σε δύο εργαζόμενους
    sift.setWorkerInAnyNotFixedRange(2)
    sift.setWorkerInAnyNotFixedRange(5)

    //> Βλέπουμε ότι η θέση 3 έχει όλους τους εργαζόμενους ακόμη και αυτούς που έχουν ανατεθεί σε άλλες θέσεις
    //sift.print() //!Πρόβλημα


    //> Εδώ εφαρμόζουμε τον περιορισμό του RL-1
    sift.applyOneWorkerInSift()

    //> Μετά την εφαρμογή του περιορισμού η θέση 3 δεν έχει πλέον τους εργαζόμενους που έχουν ανατεθεί σε άλλες θέσεις
    //sift.print()

    //>Δημιουργείται μεταβλητή τύπου Week με τις βάρδιες των πρώτων 3 ημερών

    //>Αφαιρούνται οι εργαζόμενοι των πρώτων βάρδιων απο τις δεύτερες βάρδιες της πρώτης μέρας
    sift.removeWorkersFromSecondShift(testWeek.solutionList)
    //sift.print()

    testWeek.print()

}