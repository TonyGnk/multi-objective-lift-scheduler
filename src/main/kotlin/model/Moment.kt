package model

import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.minus
import kotlinx.datetime.plus

//data class Moment(
//    val date: LocalDate,
//    val time: Time,
//)
//
//
//fun Moment.next(): Moment {
//    return when (time) {
//        Time.NIGHT -> Moment(date, Time.MORNING)
//        Time.MORNING -> Moment(date, Time.AFTERNOON)
//        Time.AFTERNOON -> Moment(date.plus(1, DateTimeUnit.DAY), Time.NIGHT)
//    }
//}
//
//fun Moment.previous(): Moment {
//    return when (time) {
//        Time.NIGHT -> Moment(date.minus(1, DateTimeUnit.DAY), Time.AFTERNOON)
//        Time.MORNING -> Moment(date, Time.NIGHT)
//        Time.AFTERNOON -> Moment(date, Time.MORNING)
//    }
//}
//
//fun Moment.nextMorning(): Moment {
//    return when (time) {
//        Time.NIGHT -> Moment(date, Time.MORNING)
//        Time.MORNING -> Moment(date.plus(1, DateTimeUnit.DAY), time)
//        Time.AFTERNOON -> Moment(date.plus(1, DateTimeUnit.DAY), Time.MORNING)
//    }
//}
