//package rules.one_time
//
//import model.Shift
//import kotlin.random.Random
//
///**
// * This shared function assigns workers to shifts randomly
// *
// * @param workers The list of workers to be assigned to the shifts
// * @param shifts The list of shifts to which the workers are to be assigned
// * @return Nothing
// */
//
//fun fixWorkersToShiftsRandomly(workers: List<Int>, shifts: List<model.Shift>) {
//    var selectedWorker = Random.nextInt(0, workers.size)
//
//    for (shift in shifts) {
//        do {
//            val workerIdToFix = workers[selectedWorker]
//            selectedWorker = (selectedWorker + 1) % workers.size
//
//            val isFixSuccessful = shift.setWorkerInAnyNotFixedRange(workerIdToFix)
//        } while (!isFixSuccessful)
//    }
//}
