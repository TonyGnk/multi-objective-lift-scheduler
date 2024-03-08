import helper_functions.Gender
import helper_functions.WorkerType

// In this project the Java code is converted to Kotlin to run using the Kotlin compiler.
// If you have greek characters inside the java file and run the kotlin compiler, the letters will be converted to question marks.
// Because of this, I create this kotlin function to handle the greek characters and return the workers list.
// @TonyGnk
fun getWorkers(): List<Worker> {
    return listOf(
        Worker("Μαυροκεφαλίδου", Gender.FEMALE, WorkerType.STAFF, 0),
        Worker("Γιαννακοβίτης", Gender.MALE, WorkerType.SU, 1),
        Worker("Καρυτόπουλος", Gender.MALE, WorkerType.SENIOR, 2),
        Worker("Σιδηρόπουλος", Gender.MALE, WorkerType.SENIOR, 3),
        Worker("Στογιάννου", Gender.MALE, WorkerType.SENIOR, 4),
        Worker("Γραμμένας", Gender.MALE, WorkerType.STAFF, 5),
        Worker("Παπαστεγίου", Gender.MALE, WorkerType.STAFF, 6),
        Worker("Συροπούλου", Gender.FEMALE, WorkerType.STAFF, 7),
        Worker("Βασιλειάδη", Gender.MALE, WorkerType.STAFF, 8),
        Worker("Λουκίδου", Gender.FEMALE, WorkerType.STAFF, 9),
        Worker("Μαλλού", Gender.FEMALE, WorkerType.STAFF, 10),
        Worker("Χατζοπούλου", Gender.FEMALE, WorkerType.STAFF, 11)
    )
}

val printColorMap = mapOf(0 to ::printBlue, 1 to ::printOrange, 2 to ::printDef)

public fun printBlue(text: String) {
    println("\u001B[34m$text")
    print("\u001B[0m")
}

public fun printOrange(text: String) {
    println("\u001B[33m$text")
    print("\u001B[0m")
}

public fun printDef(text: String) {
    println("\u001B[0m$text")
}

public fun printGreen(text: String) {
    println("\u001B[32m$text")
    print("\u001B[0m")
}

public fun printRed(text: String) {
    println("\u001B[31m$text")
    print("\u001B[0m")
}