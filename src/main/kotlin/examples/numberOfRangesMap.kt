package examples

import com.tonyGnk.core.model.time.Time
import kotlinx.datetime.DayOfWeek

val numberOfRangesMap: Map<Pair<DayOfWeek, Time>, Int> = mapOf(
    Pair(DayOfWeek.MONDAY, Time.MORNING) to 3,
    Pair(DayOfWeek.MONDAY, Time.AFTERNOON) to 2,
    Pair(DayOfWeek.MONDAY, Time.NIGHT) to 1,

    Pair(DayOfWeek.TUESDAY, Time.MORNING) to 3,
    Pair(DayOfWeek.TUESDAY, Time.AFTERNOON) to 2,
    Pair(DayOfWeek.TUESDAY, Time.NIGHT) to 1,

    Pair(DayOfWeek.WEDNESDAY, Time.MORNING) to 3,
    Pair(DayOfWeek.WEDNESDAY, Time.AFTERNOON) to 2,
    Pair(DayOfWeek.WEDNESDAY, Time.NIGHT) to 1,

    Pair(DayOfWeek.THURSDAY, Time.MORNING) to 3,
    Pair(DayOfWeek.THURSDAY, Time.AFTERNOON) to 2,
    Pair(DayOfWeek.THURSDAY, Time.NIGHT) to 1,

    Pair(DayOfWeek.FRIDAY, Time.MORNING) to 3,
    Pair(DayOfWeek.FRIDAY, Time.AFTERNOON) to 2,
    Pair(DayOfWeek.FRIDAY, Time.NIGHT) to 1,

    Pair(DayOfWeek.SATURDAY, Time.MORNING) to 2,
    Pair(DayOfWeek.SATURDAY, Time.AFTERNOON) to 2,
    Pair(DayOfWeek.SATURDAY, Time.NIGHT) to 1,

    Pair(DayOfWeek.SUNDAY, Time.MORNING) to 2,
    Pair(DayOfWeek.SUNDAY, Time.AFTERNOON) to 2,
    Pair(DayOfWeek.SUNDAY, Time.NIGHT) to 1
)
