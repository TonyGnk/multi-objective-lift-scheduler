
class WorkSet {
    private var potentialValues: List<Worker> = listOf(
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

    fun printVariable() {
        val names = potentialValues.joinToString(" ") { it.fullName }
        println(names)
    }

    fun hasOnlyOneValue(): Boolean {
        return potentialValues.size == 1
    }

    fun singleMemberId(): Int {
        return potentialValues[0].id
    }

    fun removeWorker(id: Int) {
        potentialValues = potentialValues.filter { it.id != id }
    }

    fun removeAllExcept(id: Int) {
        potentialValues = potentialValues.filter { it.id == id }
    }

    fun workerExists(id: Int): Boolean {
        return potentialValues.any { it.id == id }
    }
}