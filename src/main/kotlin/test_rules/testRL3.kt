package test_rules

import Week

fun test3() {
    //? Δε γίνεται ένας εργαζόμενος να εργαστεί παραπάνω από 5 φορές μέσα στην εβδομάδα

    val week = Week(4)
    println("Δημιουργούμε μια μικρή `εβδομάδα` 4 ημερών")
    week.print()

    println("Ορίζουμε στην πρώτη πρωινή βάρδια τον εργαζόμενο 3")
    if (week.solutionList[0].canSetWorkerInAnyNotFixedRange(3)) {
        week.solutionList[0].setWorkerInAnyNotFixedRange(3)
    }

    println("Ορίζουμε στην πρώτη Βραδυνή βάρδια τον εργαζόμενο 3")
    if (week.solutionList[2].canSetWorkerInAnyNotFixedRange(3)) {
        week.solutionList[2].setWorkerInAnyNotFixedRange(3)
    }

    println("Ορίζουμε στη δεύτερη μεσημεριανή βάρδια τον εργαζόμενο 3")
    if (week.solutionList[4].canSetWorkerInAnyNotFixedRange(3)) {
        week.solutionList[4].setWorkerInAnyNotFixedRange(3)
    }

    println("Ορίζουμε στην τρίτη πρωινή βάρδια τον εργαζόμενο 3")
    if (week.solutionList[6].canSetWorkerInAnyNotFixedRange(3)) {
        week.solutionList[6].setWorkerInAnyNotFixedRange(3)
    }

    println("Ορίζουμε στην τρίτη Βραδυνή βάρδια τον εργαζόμενο 3")
    if (week.solutionList[8].canSetWorkerInAnyNotFixedRange(3)) {
        week.solutionList[8].setWorkerInAnyNotFixedRange(3)
    }

    println("Ο εργαζόμενος 3 έχει δουλέψει 5 φορές, οπότε δε μπορούμε να τον βάλουμε σε άλλη βάρδια")
    if (week.solutionList[9].canSetWorkerInAnyNotFixedRange(3)) {
        week.solutionList[9].setWorkerInAnyNotFixedRange(3)
        println("Η προσθήκη έγινε με επιτυχία. Άρα έχουμε λάθος")
    } else {
        println("Ο περιορισμός εφαρμόστηκε επιτυχώς")
    }

    println("Ο τελικός πίνακας είναι:")
    week.print()
}