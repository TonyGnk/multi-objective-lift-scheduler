package manager_blocks

import Sift
import Week
import helper_functions.Time
import helper_functions.WorkerType

fun applyOneTimeRules(week: Week) {
    val morningSifts = week.collectSiftsWithTime(Time.MORNING)
    setSUinMorning(morningSifts)
    setSeniorsAtMorning(morningSifts)
}

fun setSUinMorning(morningSifts: List<Sift>) {
    for (sift in morningSifts) {
        val successFix = sift.setWorkerInAnyNotFixedRange(0)
    }
}

fun setSeniorsAtMorning(morningSifts: List<Sift>) {
    val idsOfSeniors = listOf(1, 2, 3)
    for (sift in morningSifts) {
        if (sift.exists(WorkerType.SENIOR)) continue
        do {
            val randomId = idsOfSeniors.random()
            val successFix = sift.setWorkerInAnyNotFixedRange(randomId)
        } while (!successFix)
    }
}