package rules.more_times

import Range
import Week

/**
 * This function removes the workers from the ranges that are fixed
 * @param week The week to be solved
 * @param showMessages A boolean to show the debug messages or not
 * @return The number of changes made
 *
 * Why we return a flag hasMadeChange?
 * Example:
 *       3,
 *    2, 3,
 * 1, 2, 3,
 * In first execution we remove the worker 3 from other ranges,
 * but we don't remove the worker 2 from the range 3
 */
fun removeFixedWorkersInShift(week: Week, showMessages: Boolean): Int {
    var hasMadeChange = 0
    val allShifts = week.solutionList

    for (shift in allShifts) {
        for (range in shift.ranges) {
            if (range.isFixed) {
                hasMadeChange += removeWorker(range, shift.ranges)
            }
        }
    }
    return hasMadeChange
}

fun removeWorker(range: Range, ranges: List<Range>): Int {
    var hasMadeChange = 0
    val idOfFixedWorker = range.firstWorkerId

    for (otherRange in ranges) {
        if (otherRange !== range
            && otherRange.exists(idOfFixedWorker)
        ) {
            otherRange.removeWorker(idOfFixedWorker)
            hasMadeChange += 1
        }
    }
    return hasMadeChange
}