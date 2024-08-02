import com.tonyGnk.core.model.scheduler.ProblemResult
import com.tonyGnk.core.model.scheduler.Range
import com.tonyGnk.core.model.scheduler.SearchInput
import com.tonyGnk.core.model.scheduler.numberOfRangesMapPreset
import com.tonyGnk.core.model.time.next


fun createScheduleProblem(searchInput: SearchInput): ProblemResult {
    val list = mutableListOf<Range>()
    var id = 0
    var currentMoment = searchInput.start

    while (currentMoment != searchInput.end.next()) {
        val dayOfWeek = currentMoment.date.dayOfWeek
        val numberOfRanges = numberOfRangesMapPreset[Pair(dayOfWeek, currentMoment.time)] ?: 0
        // printOrange("For ${currentMoment.date} ${currentMoment.time} add $numberOfRanges ranges\n")

        for (i in 0 until numberOfRanges) {
            list.add(
                Range(
                    id = id,
                    possibleWorkers = searchInput.workers.toMutableList(),
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
