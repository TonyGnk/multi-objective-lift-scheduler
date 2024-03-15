package manager_blocks

import Week
import helper_functions.Time
import workersRemainingWorkTimes

/**
 * This one-time rule sets SU worker in every morning shift as possible
 *
 * @param week The week for which the morning shifts are to be set
 * @return Nothing
 */
fun setSUWorkerToMorningShifts(week: Week) {
    val morningSifts = week.solutionList.filter { it.time == Time.MORNING }.toList()
    val idOfSU = 0

    //While the workersRemainingWorkTimes of the SU worker is not 0 set the SU worker to the morning shifts
    while (workersRemainingWorkTimes[idOfSU] != 0) {
        for (sift in morningSifts) {
            sift.setWorkerInAnyNotFixedRange(idOfSU)
        }
    }

    println("SU worker has been set to the morning shifts")
    week.print()

}