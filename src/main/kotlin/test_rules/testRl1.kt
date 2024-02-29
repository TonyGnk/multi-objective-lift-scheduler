package test_rules

import Sift

// This is a test of how the limit RL-1 is applied
fun test1ApplyOneWorkerInSift() {

    //? Δε γίνεται ένας εργαζόμενος να καλύπτει δύο θέσεις σε μια βάρδια

    //> Δημιουργούμε μια νέα βάρδια που θα έχει 3 θέσεις (Όπως η πρωινή βάρδια)
    val sift = Sift(1, 3)

    //> Βλέπουμε ότι και η 3 θέσεις (Ranges) έχουν όλους τους εργαζόμενους
    sift.print()

    //> Υποθέτουμε ότι με κάποιο τρόπο γίνεται ανάθεση των θέσεων 1 και 2 σε δύο εργαζόμενους
    sift.removeAllWorkersInAnyNotFixedRangeExcept(2)
    sift.removeAllWorkersInAnyNotFixedRangeExcept(5)

    //> Βλέπουμε ότι η θέση 3 έχει όλους τους εργαζόμενους ακόμη και αυτούς που έχουν ανατεθεί σε άλλες θέσεις
    sift.print()

    //> Εδώ εφαρμόζουμε τον περιορισμό του RL-1
    sift.applyOneWorkerInSift()

    //> Μετά την εφαρμογή του περιορισμού η θέση 3 δεν έχει πλέον τους εργαζόμενους που έχουν ανατεθεί σε άλλες θέσεις
    sift.print()
}