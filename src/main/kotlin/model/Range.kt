package model

class Range(
    val id: Int,
    val possibleWorkers: MutableList<Worker>,
    val moment: Moment,
) {

    fun setWorker(workerId: String) {
        possibleWorkers.removeIf { it.id != workerId }
    }

    fun isEmpty(): Boolean {
        return possibleWorkers.isEmpty()
    }

    fun setGenderOnly(gender: Gender) {
        possibleWorkers.removeIf { it.gender != gender }
    }

    fun hasOnly(gender: Gender): Boolean {
        return possibleWorkers.all { it.gender == gender }
    }
}


fun MutableList<Range>.existsRangeWithOnlyGender(gender: Gender): Int? {
    this.forEach {
        if (it.hasOnly(gender)) {
            return it.id
        }
    }
    return null
}
