//package model
//
//class Shift(
//    val size: Int,
//    val time: Time,
//    val availableWorkers: List<Worker>,
//) {
//    private val ranges: MutableMap<Int, model.Range> =
//        List(size) { it + 1 }.associateWith { model.Range(availableWorkers) }.toMutableMap()
//
//    fun setWorkerInAnyNotFixedRange(workerId: String) {
//        ranges.forEach { (index, range) ->
//            if (!range.isFixed() && range.canBeFixedWorker(workerId)) {
//                range.setFixedWorker(workerId)
//                removeWorkerEveryWhereInsteadOf(workerId, index)
//            }
//        }
//    }
//
//    private fun removeWorkerEveryWhereInsteadOf(
//        idForRemove: String, rangeIndex: Int
//    ) {
//        ranges.map { (index, range) ->
//            if (index != rangeIndex) {
//                range.removeWorker(idForRemove)
//            }
//        }
//    }
//
//
//    fun rangesInLines(): String {
//        val string = StringBuilder()
//        for (range in ranges) {
//            string.append(range.value.ids())
//            if (range !== ranges.entries.last()) string.append(" | ")
//        }
//        return string.toString()
//    }
//
//
////    fun applyOneWorkerInShift() {
////        ranges.value.forEach { currentRange ->
////            if (currentRange.isFixed()) {
////                removeFixedWorkerFromRanges(currentRange)
////            }
////        }
////    }
////
////    private fun removeFixedWorkerFromRanges(
////        workersRange: model.Range
////    ) {
////        val idOfFixedWorker: String = workersRange.getFirstWorkerId()
////        ranges.value.forEach { otherRange ->
////            if (otherRange !== workersRange
////                && otherRange.exists(idOfFixedWorker)
////            ) {
////                removeWorker(
////                    range = otherRange,
////                    ranges = ranges.value,
////                )
////            }
////        }
////    }
////
////    fun removeWorker(idForRemove: String) {
////        ranges.value.filter { range -> range.exists(idForRemove) }
////            .forEach { range -> range.removeWorker(idForRemove) }
////
////    }
//
////        public void removeWorker(int idForRemove) {
////        workers = workers.stream().filter(worker -> worker.id != idForRemove)
////                .collect(Collectors.toList());
////    }
//
//}
