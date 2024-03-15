package rules.one_time

import Week
import helper_functions.Time
import helper_functions.WorkerType

/**
 * This one-time rule sets senior workers in every morning shift
 * doesn't have a senior worker or a supervisor
 *
 * @param week The week for which the morning shifts are to be set
 * @param showMessages A boolean to show the debug messages or not
 * @return Nothing
 */
fun setSeniorOnEveryMorning(week: Week, showMessages: Boolean) {
    val morningShifts = week.collectShiftsWith(Time.MORNING)
    val shiftsWithoutSeniorSU = morningShifts.filter { !it.isFixed(WorkerType.SENIOR) && !it.isFixed(WorkerType.SU) }
    val idsOfSeniors = listOf(1, 2, 3)

    var randomSeniorId: Int
    var previousRandom = -1

    for (sift in shiftsWithoutSeniorSU) {
        do {
            randomSeniorId = idsOfSeniors.random()
            //Avoid the same random value once
            if (randomSeniorId == previousRandom) randomSeniorId = idsOfSeniors.random()

            previousRandom = randomSeniorId
            val isFixSuccessful = sift.setWorkerInAnyNotFixedRange(randomSeniorId)
        } while (!isFixSuccessful)
    }

    if (showMessages) {
        println("Seniors have been set to the morning shifts")
        week.print()
    }
}