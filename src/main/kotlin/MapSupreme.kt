import com.tonyGnk.core.model.time.Time
import com.tonyGnk.core.model.worker.Worker
import kotlinx.datetime.LocalDate


//fun ProblemResultNew.manualSet(
//    time: Time, date: LocalDate, index: Int, workerId: String
//) {
//    dates[date]?.times?.get(time)?.ranges?.get(index)?.manualSet(workerId)
//}
//
//
//fun ProblemResultNew.getAvailableWorkers(
//    time: Time, date: LocalDate, index: Int
//): List<Worker> {
//    return dates[date]?.times?.get(time)?.ranges?.get(index)?.possibleWorkers ?: emptyList()
//}
//
//fun ProblemResultNew.print(): String {
//    val allTheRangesInAList: MutableList<Range> = dates.flatMap { day ->
//        day.value.times.flatMap { time ->
//            time.value.ranges
//        }
//    }.toMutableList()
//    return allTheRangesInAList.toText()
//}
