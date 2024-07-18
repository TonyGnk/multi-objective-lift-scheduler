import com.tonyGnk.core.model.scheduler.ProblemResult
import com.tonyGnk.core.model.scheduler.Range
import com.tonyGnk.core.model.scheduler.SearchInput
import com.tonyGnk.core.model.time.next
import examples.numberOfRangesMap
import old.printOrange

fun createProblem(input: SearchInput): ProblemResult {
    printOrange("Create problem for ${input.start.date} ${input.start.time} - ${input.end.date} ${input.end.time}\n")

    val list = mutableListOf<Range>()
    var id = 0
    var currentMoment = input.start

    while (currentMoment != input.end.next()) {
        val dayOfWeek = currentMoment.date.dayOfWeek
        val numberOfRanges = numberOfRangesMap[Pair(dayOfWeek, currentMoment.time)] ?: 0
        printOrange("For ${currentMoment.date} ${currentMoment.time} add $numberOfRanges ranges\n")

        for (i in 0 until numberOfRanges) {
            list.add(
                Range(
                    id = id,
                    possibleWorkers = input.workers.toMutableList(),
                    moment = currentMoment
                )
            )
            id++
        }
        currentMoment = currentMoment.next()
    }
    print("\n")

    //list[0].setWorker(input.workers[0].id)

    return ProblemResult.Success(list)
}
