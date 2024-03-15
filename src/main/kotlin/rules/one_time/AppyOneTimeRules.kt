/*
    This file contains the rules that are applied only once,
    at the beginning of the search
 */

package rules.one_time

import Week
import helper_functions.Time
import helper_functions.WorkerType
import manager_blocks.setSUWorkerToMorningShifts

fun applyOneTimeRules(week: Week) {
    setSUWorkerToMorningShifts(week)
    //setSeniorsAtMorning(week)
}


fun setSeniorsAtMorning(week: Week) {
    val morningSifts = week.collectSiftsWithTime(Time.MORNING)
    val idsOfSeniors = listOf(1, 2, 3)
    for (sift in morningSifts) {
        if (sift.exists(WorkerType.SENIOR)) continue
        do {
            val randomId = idsOfSeniors.random()
            val successFix = sift.setWorkerInAnyNotFixedRange(randomId)
        } while (!successFix)
    }
}