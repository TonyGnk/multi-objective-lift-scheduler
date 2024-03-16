package rules.one_time

import Week
import helper_functions.Time
import printGreen
import workersRemainingWorkTimes

/**
 * This one-time rule sets SU worker in every morning shift as possible
 *
 * @param week The week for which the morning shifts are to be set
 * @param showMessages A boolean to show the debug messages or not
 * @return Nothing
 */
fun setSUWorkerToMorningShifts(week: Week, showMessages: Boolean) {
    val morningSifts = week.collectShiftsWith(Time.MORNING)
    val idOfSU = 0

    //While the workersRemainingWorkTimes of the SU worker is not 0 set the SU worker to the morning shifts
    while (workersRemainingWorkTimes[idOfSU] != 0) {
        for (sift in morningSifts) {
            sift.setWorkerInAnyNotFixedRange(idOfSU)
        }
    }

    if (showMessages) {
        printGreen("\nSU worker has been set to the morning shifts")
        week.print()
    }
}