package rules.more_times

import Week
import model.Range
import printGreen

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

    if (showMessages) {
        printGreen("\nThe fixed workers have been removed in all others ranges. Total changes: $hasMadeChange")
        week.print()
    }

    return hasMadeChange
}

/**
 * This function removes the worker from the ranges that are not the same with the range
 * @param range The range to be solved
 * @param ranges The list of ranges
 * @return The number of changes made
 */
fun removeWorker(range: Range, ranges: List<Range>): Int {
    var hasMadeChange = 0
    val idOfFixedWorker = range.getFirstWorkerId()

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
