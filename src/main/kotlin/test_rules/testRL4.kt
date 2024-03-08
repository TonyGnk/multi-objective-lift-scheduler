package test_rules

import Week
import printGreen
import printRed

//Θα βρω όνομα μετά
fun test4() {
    println("\nΕφαρμογή 4ου Περιορισμού")
    //? Στην πρωινή βάρδια πρέπει να εκπροσωπούνται και τα δύο φύλλα

    printGreen("Δημιουργείται μια μικρή `εβδομάδα` 2 ημερών")
    val week = Week(2)
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
    if (week.solutionList[9].canSetWorkerInAnyNotFixedRange(3)) {
        week.solutionList[9].setWorkerInAnyNotFixedRange(3)
        println("Η προσθήκη έγινε με επιτυχία. Άρα έχουμε λάθος")
    } else {
        printRed("Δεν επιτρέπεται νέα προσθήκη")
    }

    println("________________________________________________")
}