package test_rules

import WeekScheduler

fun testWeeklyScheduler1() {
    val Scheduler = WeekScheduler()
    val week = Scheduler.ProgramGenerator()
    week.print()
}