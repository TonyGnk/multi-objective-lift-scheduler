package rules.one_time

import Week

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
}