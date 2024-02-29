import test_rules.test1ApplyOneWorkerInSift
import test_rules.test2PreventTheSameWorkerInTwoShifts
import test_rules.test3

fun main() {
    println("Εφαρμογή 1ου Περιορισμού")
    test1ApplyOneWorkerInSift()
    println("________________________________________________")

    println("Εφαρμογή 2ου Περιορισμού")
    test2PreventTheSameWorkerInTwoShifts()
    println("________________________________________________")

    println("Εφαρμογή 3ου Περιορισμού")
    test3()

}