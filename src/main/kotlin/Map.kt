import com.tonyGnk.core.model.scheduler.numberOfRanges
import com.tonyGnk.core.model.time.Time
import com.tonyGnk.core.model.worker.Worker
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn


//data class ProblemResultNew(
//    val today: LocalDate = Clock.System.todayIn(TimeZone.currentSystemDefault()),
//    val week: List<LocalDate>,
//    val workers: List<Worker>,
//    val dates: Map<LocalDate, ProblemResultNested> = week.associateWith { date ->
//        ProblemResultNested(
//            date = date, workers = workers
//        )
//    }
//)
//
//
//data class ProblemResultNested(
//    val date: LocalDate = LocalDate(2024, 7, 21),
//    val workers: List<Worker> = emptyList(),
//    val times: Map<Time, ProblemResultNestedNested> = Time.entries.associateWith { time ->
//        ProblemResultNestedNested(
//            date = date, workers = workers, time = time
//        )
//    }
//)
//
//data class ProblemResultNestedNested(
//    val date: LocalDate = LocalDate(2024, 7, 21),
//    val workers: List<Worker> = emptyList(),
//    val time: Time = Time.MORNING,
//    val ranges: List<Range> = List(numberOfRanges(date.dayOfWeek, time)) {
//        Range(
//            possibleWorkers = workers.toMutableList(), date = date, time = time
//        )
//    }
//)


//class Range(
//    val time: Time,
//    val date: LocalDate,
//    val possibleWorkers: MutableList<Worker>
//) {
//    fun isFixed(): Boolean = possibleWorkers.size == 1
//
//    fun fixedWorker(): Worker = possibleWorkers.first()
//
//    fun manualSet(workerId: String) {
//        possibleWorkers.removeIf { it.id != workerId }
//    }
//
//    fun print() {
//        print("Range $")
//        print(" - Possible Workers: ")
//        possibleWorkers.forEach {
//            print(it)
//        }
//        print(" - Time: $time")
//    }
//}
