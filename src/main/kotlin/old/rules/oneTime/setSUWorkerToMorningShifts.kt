//package old.rules.oneTime
//
//import model.Shift
//import model.Time
//
//
//internal fun setSUWorkerToMorningShifts(
//    shifts: MutableMap<Int, Shift>,
//    availableShiftsForSU: Int
//) {
//    val idOfSU = "worker1"
//
//    var shiftsSet = 0
//    shifts.map { (_, shift) ->
//        if (shiftsSet <= availableShiftsForSU && shift.time == Time.MORNING) {
//            shift.setWorkerInAnyNotFixedRange(idOfSU)
//            shiftsSet++
//        }
//    }
//}
