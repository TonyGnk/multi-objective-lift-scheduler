package model

import kotlinx.coroutines.flow.MutableStateFlow
import rules.more_times.removeWorker

class Shift(
    day: WorkerDayType,
    availableWorkers: List<Worker>,
    numberOfRangesMap: Map<WorkerDayType, Int>
) {

    private val ranges = MutableStateFlow(
        List(
            numberOfRangesMap[day] ?: 0
        ) {
            Range(availableWorkers)
        }
    )

    fun setWorkerInAnyNotFixedRange(workerId: String): Boolean {
        ranges.value.forEach { range ->
            if (!range.isFixed() && range.canBeFixedWorker(workerId)) {
                range.setFixedWorker(workerId)
                return true
            }
        }
        return false
    }

    fun applyOneWorkerInShift() {
        ranges.value.forEach { currentRange ->
            if (currentRange.isFixed()) {
                removeFixedWorkerFromRanges(currentRange)
            }
        }
    }

    private fun removeFixedWorkerFromRanges(
        workersRange: Range
    ) {
        val idOfFixedWorker: String = workersRange.getFirstWorkerId()
        ranges.value.forEach { otherRange ->
            if (otherRange !== workersRange
                && otherRange.exists(idOfFixedWorker)
            ) {
                removeWorker(
                    range = otherRange,
                    ranges = ranges.value,
                )
            }
        }
    }

    fun removeWorker(idForRemove: String) {
        ranges.value.filter { range -> range.exists(idForRemove) }
            .forEach { range -> range.removeWorker(idForRemove) }

    }

//        public void removeWorker(int idForRemove) {
//        workers = workers.stream().filter(worker -> worker.id != idForRemove)
//                .collect(Collectors.toList());
//    }

}
