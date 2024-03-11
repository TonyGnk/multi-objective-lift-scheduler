package test_rules

import Week
import printGreen

fun test3() {
    println("\nΕφαρμογή 3ου Περιορισμού")
    //? Δε γίνεται ένας εργαζόμενος να εργαστεί παραπάνω από 5 φορές μέσα στην εβδομάδα

    printGreen("Δημιουργείται μια μικρή `εβδομάδα` 4 ημερών")
    val week = Week(4)
    week.print()

    printGreen("Ορίζεται στην πρώτη πρωινή βάρδια ο εργαζόμενος 3")
    if (week.solutionList[0].canSetWorkerInAnyNotFixedRange(3)) {
        week.solutionList[0].setWorkerInAnyNotFixedRange(3)
    }

    printGreen("Ορίζεται στην πρώτη βραδυνή βάρδια ο εργαζόμενο 3")
    if (week.solutionList[2].canSetWorkerInAnyNotFixedRange(3)) {
        week.solutionList[2].setWorkerInAnyNotFixedRange(3)
    }

    printGreen("Ορίζεται στη δεύτερη μεσημεριανή βάρδια ο εργαζόμενος 3")
    if (week.solutionList[4].canSetWorkerInAnyNotFixedRange(3)) {
        week.solutionList[4].setWorkerInAnyNotFixedRange(3)
    }

    printGreen("Ορίζεται στην τρίτη πρωινή βάρδια ο εργαζόμενος 3")
    if (week.solutionList[6].canSetWorkerInAnyNotFixedRange(3)) {
        week.solutionList[6].setWorkerInAnyNotFixedRange(3)
    }

    printGreen("Ορίζεται στην τρίτη Βραδυνή βάρδια ο εργαζόμενος 3")
    if (week.solutionList[8].canSetWorkerInAnyNotFixedRange(3)) {
        week.solutionList[8].setWorkerInAnyNotFixedRange(3)
    }

    week.print()
    printGreen("Ο εργαζόμενος 3 έχει δουλέψει 5 φορές, απόπειρα νέα προσθήκης:")
//    if (week.solutionList[9].canSetWorkerInAnyNotFixedRange(3)) {
//        week.solutionList[9].setWorkerInAnyNotFixedRange(3)
//        println("Η προσθήκη έγινε με επιτυχία. Άρα έχουμε λάθος")
//    } else {
//        printRed("Δεν επιτρέπεται νέα προσθήκη")
//    }

    println("________________________________________________")
}