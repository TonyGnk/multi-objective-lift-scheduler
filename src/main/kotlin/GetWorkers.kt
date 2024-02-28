import helper_functions.Gender

// In this project the Java code is converted to Kotlin to run using the Kotlin compiler.
// If you have greek characters inside the java file and run the kotlin compiler, the letters will be converted to question marks.
// Because of this, I create this kotlin function to handle the greek characters and return the workers list.
// @TonyGnk
fun getWorkers() : List<Worker> {
    return listOf(
        Worker("Μαυροκεφαλίδου", Gender.FEMALE, 1),
        Worker("Γιαννακοβίτης", Gender.MALE, 2),
        Worker("Καρυτόπουλος", Gender.MALE, 3),
        Worker("Σιδηρόπουλος", Gender.MALE, 4),
        Worker("Στογιάννου", Gender.MALE, 5),
        Worker("Γραμμένας", Gender.MALE, 6),
        Worker("Παπαστεγίου", Gender.MALE, 7),
        Worker("Συροπούλου", Gender.FEMALE, 8),
        Worker("Βασιλειάδη", Gender.MALE, 9),
        Worker("Λουκίδου", Gender.FEMALE, 10),
        Worker("Μαλλού", Gender.FEMALE, 11),
        Worker("Χατζοπούλου", Gender.FEMALE, 12)
    )
}