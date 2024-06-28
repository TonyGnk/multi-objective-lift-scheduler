import model.Range
import model.Worker

fun initializeWorkersLimits(workers: List<Worker>): MutableMap<String, Int> {
    val workerLimits: MutableMap<String, Int> = mutableMapOf()
    workers.forEach { worker ->
        workerLimits[worker.id] = 5
    }
    return workerLimits
}


sealed class SearchResult {
    data class Success(val ranges: MutableList<Range>) : SearchResult()
    data object InitialisationError : SearchResult()
    data object RangesWithNoWorkers : SearchResult()
}


sealed class RuleResult {
    data class Success(val updatedIndexes: List<Int>) : RuleResult()
    data object NoChanges : RuleResult()
}
