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
    //week.print()

    //applyRules(week)

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