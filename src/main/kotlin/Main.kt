import com.tonyGnk.core.model.scheduler.ProblemResult
import com.tonyGnk.core.model.scheduler.Range
import com.tonyGnk.core.model.scheduler.SearchInput
import com.tonyGnk.core.model.time.Moment
import com.tonyGnk.core.model.time.Time
import com.tonyGnk.core.model.worker.workersPreSet
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate
import kotlinx.datetime.plus

fun main() {

    val week: List<LocalDate> = getWeek(LocalDate(2024, 7, 15)).take(4)

    val startMoment = Moment(date = week.first(), time = Time.MORNING)
    val end = Moment(date = week.last(), time = Time.NIGHT)
    val workers = workersPreSet.take(workersPreSet.size / 2)

    val input = SearchInput(
        start = startMoment, end = end, workers = workers.toMutableList()
    )
    var problemOutput: ProblemResult = createScheduleProblem(input)

    when (val problem = problemOutput) {
        is ProblemResult.Success -> {
            //print("Problem created:\n")
            //problem.problem.print()
            //print("\n")
        }

        ProblemResult.NotInitialized -> {}
    }

    if (problemOutput is ProblemResult.Success) {
        problemOutput = ProblemResult.Success(setValue(problemOutput))
        //print("Worker Set:\n")
        problemOutput.problem.print()
        print("\n")
    }

    if (problemOutput is ProblemResult.Success) {
        //problemOutput = liftSchedulerManualOptimizing(problemOutput.problem)
//        if (problemOutput is ProblemResult.Success) {
//            //print("Problem after search:\n")
//            //problemOutput.problem.print()
//        }
    }
}

fun setValue(problem: ProblemResult.Success): List<Range> {
    return problem.problem.map {
        if (it.id == 1) {
            it.setWorker("1")
        } else {
            it
        }
    }
}

fun getWeek(mondayDate: LocalDate): List<LocalDate> {
    return (0 until DayOfWeek.entries.size).map { dayOfWeek ->
        mondayDate.plus(dayOfWeek, DateTimeUnit.DAY)
    }
}
//fun applySUAtMorning(
//    ranges: MutableList<RangeNew>,
//    workers: MutableList<Worker>,
//    workerLimits: MutableMap<String, Int>
//): RuleResult {
//
//    val suWorkerId = workers.find { it.type == Role.SU }?.id
//    if (suWorkerId == null) return RuleResult.NoChanges
//
//    val updatedIndexes = mutableListOf<Int>()
//    for (range in ranges) {
//        if (range.moment.time == Time.MORNING && workerLimits[suWorkerId]!! > 0) {
//            range.setWorker(suWorkerId)
//            updatedIndexes.add(range.id)
//        }
//    }
//
//    ranges.forEach {
//        print("id:${it.id} possibleWorkers: ")
//        it.possibleWorkers.forEach { worker -> print("${worker.name}, ") }
//        println("\n${it.moment}")
//    }
//
//    return RuleResult.Success(updatedIndexes)
//}
