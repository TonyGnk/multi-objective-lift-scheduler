import helper_functions.Gender

// In this project the Java code is converted to Kotlin to run using the Kotlin compiler.
// If you have greek characters inside the java file and run the kotlin compiler, the letters will be converted to question marks.
// Because of this, I create this kotlin function to handle the greek characters and return the workers list.
// @TonyGnk
fun getWorkers() : List<Worker> {
    return listOf(
        Worker("Μαυροκεφαλίδου", Gender.FEMALE, 0),
        Worker("Γιαννακοβίτης", Gender.MALE, 1),
        Worker("Καρυτόπουλος", Gender.MALE, 2),
        Worker("Σιδηρόπουλος", Gender.MALE, 3),
        Worker("Στογιάννου", Gender.MALE, 4),
        Worker("Γραμμένας", Gender.MALE, 5),
        Worker("Παπαστεγίου", Gender.MALE, 6),
        Worker("Συροπούλου", Gender.FEMALE, 7),
        Worker("Βασιλειάδη", Gender.MALE, 8),
        Worker("Λουκίδου", Gender.FEMALE, 9),
        Worker("Μαλλού", Gender.FEMALE, 10),
        Worker("Χατζοπούλου", Gender.FEMALE, 11)
    )
}

val printColorMap = mapOf(0 to ::printBlue, 1 to ::printOrange, 2 to ::printDefault)

private fun printBlue(text : String) {
    println("\u001B[34m$text")
}

private fun printOrange(text : String) {
    println("\u001B[33m$text")
}

private fun printDefault(text : String) {
    println("\u001B[0m$text")
}

//private fun printDarkGreen(text : String) {
//    println("\u001B[32m$text")
//}