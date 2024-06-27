package manager_blocks

import helper_functions.Day
import model.Time

fun getDayType(day: Int): Day {
    return if (day == 0 || day % 7 == 0 || day % 7 == 6) Day.WEEKEND
    else Day.NORMAL
}

fun getListTimeFrom(startTime: Time): List<Time> {
    if (startTime == Time.MORNING) return listOf(Time.MORNING, Time.AFTERNOON, Time.NIGHT)
    if (startTime == Time.AFTERNOON) return listOf(Time.AFTERNOON, Time.NIGHT)
    return listOf(Time.NIGHT)
}

fun findNextTime(time: Time): Time {
    return when (time) {
        Time.MORNING -> Time.AFTERNOON
        Time.AFTERNOON -> Time.NIGHT
        Time.NIGHT -> Time.MORNING
    }
}

class RangesNumber {
    private var rangesInSift = mapOf(
        Pair(Time.MORNING, Day.NORMAL) to 3,
        Pair(Time.MORNING, Day.WEEKEND) to 2,
        Pair(Time.AFTERNOON, Day.NORMAL) to 2,
        Pair(Time.AFTERNOON, Day.WEEKEND) to 2,
        Pair(Time.NIGHT, Day.NORMAL) to 1,
        Pair(Time.NIGHT, Day.WEEKEND) to 1,
    )

    fun get(time: Time, day: Day): Int {
        return rangesInSift[Pair(time, day)] ?: 0
    }

    fun print() {
        rangesInSift.forEach { (key, value) -> println("$key -> $value") }
    }

    fun removePair(time: Time, day: Day) {
        //Keep the pairs that are not equal to the pair we want to remove
        rangesInSift = rangesInSift.filterKeys { it != Pair(time, day) }
    }

    fun addPair(time: Time, day: Day, value: Int) {
        if (rangesInSift.containsKey(Pair(time, day))) {
            println("The pair already exists")
            return
        }

        rangesInSift = rangesInSift.plus(Pair(Pair(time, day), value))
    }
}
