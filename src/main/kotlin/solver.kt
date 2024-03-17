import rules.more_times.removeFixedWorkersInShift
import rules.one_time.setBothGenderInMorningShifts
import rules.one_time.setSUWorkerToMorningShifts
import rules.one_time.setSeniorOnEveryMorning

/**
 * This function is the central function of the project
 * It calls all the rules and apply them to the week
 *
 * @param week The week to be solved
 * @param showMessages A boolean to show the debug messages or not
 * @return The solved week
 */
fun solveWeek(week: Week, showMessages: Boolean = false): Week {
    applyOneTimeRules(week, showMessages)
    applyMultipleTimeRules(week, showMessages)


    //If is solution return
    return week

    //If is not solution, set a random value and apply the rules again
}

/**
 * This function call all the one-time rules
 *
 * @param week The week for which the one-time rules are to be applied
 * @param showMessages A boolean to show the debug messages or not
 * @return Nothing
 */
fun applyOneTimeRules(week: Week, showMessages: Boolean) {
    setSUWorkerToMorningShifts(week, showMessages)
    setSeniorOnEveryMorning(week, showMessages)
    setBothGenderInMorningShifts(week, showMessages)
}

fun applyMultipleTimeRules(week: Week, showMessages: Boolean) {
    var n = 1
    while (n != 0) {
        n = 0
        n += removeFixedWorkersInShift(week, showMessages)
    }
}