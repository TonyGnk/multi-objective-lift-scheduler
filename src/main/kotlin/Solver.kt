//import com.tonyGnk.core.model.scheduler.Range
//import com.tonyGnk.core.model.scheduler.existsRangeWithOnlyGender
//import com.tonyGnk.core.model.time.Time
//import com.tonyGnk.core.model.worker.Gender
//import old.printBlue
//
//fun liftSchedulerSearch(
//    ranges: MutableList<Range>
//): SearchResult {
//    var updatedListIndexes = mutableListOf<Int>()
//
//    println("Start Searching...")
//
//    printBlue("Optimizing Problem...")
//    previousFunction(ranges)
//    printBlue("\n")
//
//    updatedListIndexes = setSUInMorningsRule(ranges)
//
//    printBlue("Optimizing Problem...")
//    previousFunction(ranges, updatedListIndexes)
//    printBlue("\n")
//
//    updatedListIndexes = setEveryGenderInMorningRule(ranges)
//
//    printBlue("Optimizing Problem...")
//    previousFunction(ranges, updatedListIndexes)
//    printBlue("\n")
//
//
//    if (ranges.any { it.isEmpty() }) return SearchResult.RangesWithNoWorkers
//
//    return SearchResult.Success(ranges)
//}
//
//fun setEveryGenderInMorningRule(ranges: MutableList<Range>): MutableList<Int> {
//    val updatedIndexes = mutableListOf<Int>()
//
//    //Collect all the morning moments
//    val morningMoments = ranges.filter { it.moment.time == Time.MORNING }.map { it.moment }
//
//    morningMoments.forEach { currentMoment ->
//        val rangesWithMoment = ranges.filter { it.moment == currentMoment }.toMutableList()
//
//        if (rangesWithMoment.size >= 1) {
//            val possibleMales: Int? = rangesWithMoment.existsRangeWithOnlyGender(Gender.MALE)
//            val possibleFemales: Int? = rangesWithMoment.existsRangeWithOnlyGender(Gender.FEMALE)
//
////            if (possibleMales != null && possibleFemales == null) {
////                rangesWithMoment.removeAt(possibleMales)
////                rangesWithMoment[0].setGenderOnly(Gender.FEMALE)
////                updatedIndexes.add(rangesWithMoment[0].id)
////            }
//
//            if (possibleFemales == null) {
//                rangesWithMoment[1].setGenderOnly(Gender.FEMALE)
//                updatedIndexes.add(rangesWithMoment[1].id)
//            }
//        }
//    }
//
//    return updatedIndexes
//}
//
//fun setSUInMorningsRule(ranges: MutableList<Range>): MutableList<Int> {
//    val updatedIndexes = mutableListOf<Int>()
//
//    val morningMoments = ranges.filter { it.moment.time == Time.MORNING }.map { it.moment }
//    val suId = "1"
//    var availableWorkTimes = 5
//
//    morningMoments.forEach { currentMoment ->
//        if (availableWorkTimes > 0) {
//            val rangesWithMoment = ranges.filter { it.moment == currentMoment }.toMutableList()
//            rangesWithMoment[0].setWorker(suId)
//            updatedIndexes.add(rangesWithMoment[0].id)
//            availableWorkTimes--
//        }
//    }
//
//    return updatedIndexes
//}
