import com.tonyGnk.core.model.scheduler.ProblemResult
import examples.exampleTwoDays

fun main() {


    val selectedExampleInput = exampleTwoDays

    when (val problemOutput = createProblem(selectedExampleInput)) {
        is ProblemResult.Success -> {
            print("Problem created\n")
            problemOutput.problem.print()
            print("\n")

            when (val solution = liftSchedulerSearch(problemOutput.problem)) {
                is SearchResult.Success -> solution.ranges.print()
                is SearchResult.InitialisationError -> println("\nError! InitialisationError")
                is SearchResult.RangesWithNoWorkers -> println("\nError! RangesWithNoWorkers")
            }
        }
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
