import test_rules.test1ApplyOneWorkerInSift
import test_rules.test2PreventTheSameWorkerInTwoShifts
import test_rules.test3
import test_rules.testWeeklyScheduler1

fun main() {

    test1ApplyOneWorkerInSift()

    test2PreventTheSameWorkerInTwoShifts()

    test3()

    testWeeklyScheduler1()

}