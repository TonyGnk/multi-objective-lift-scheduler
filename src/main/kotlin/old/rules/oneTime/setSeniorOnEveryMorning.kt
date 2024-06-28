//package rules.one_time
//
//import Week
//import helper_functions.Time
//import helper_functions.WorkerType
//import printGreen
//
///**
// * This one-time rule sets senior workers in every morning shift
// * doesn't have a senior worker or a supervisor
// *
// * @param week The week for which the morning shifts are to be set
// * @param showMessages A boolean to show the debug messages or not
// * @return Nothing
// */
//fun setSeniorOnEveryMorning(week: Week, showMessages: Boolean) {
//    val morningShifts = week.collectShiftsWith(Time.MORNING)
//    val shiftsWithoutSeniorSU = morningShifts.filter { !it.isFixed(WorkerType.SENIOR) && !it.isFixed(WorkerType.SU) }
//    val idsOfSeniors = listOf(1, 2, 3)
//
//    fixWorkersToShiftsRandomly(idsOfSeniors, shiftsWithoutSeniorSU)
//
//    if (showMessages) {
//        printGreen("\nEvery morning shift has a senior or a supervisor")
//        week.print()
//    }
//}
