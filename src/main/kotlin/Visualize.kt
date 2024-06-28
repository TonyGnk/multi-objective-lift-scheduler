import model.Range
import model.Time
import old.printBlue
import old.printDef
import old.printOrange

fun MutableList<Range>.print() {
    this.forEach {
        printPerTime("${it.id} -  [", it.moment.time)
        it.possibleWorkers.forEach { worker ->
            printPerTime(
                worker.id + if (it.possibleWorkers.last() != worker) ", " else "", it.moment.time
            )
        }
        printPerTime("]  ${it.moment.date}", it.moment.time)
        println()
    }
}

fun printPerTime(text: String, time: Time) {
    when (time) {
        Time.NIGHT -> printDef(text)
        Time.MORNING -> printOrange(text)
        Time.AFTERNOON -> printBlue(text)
    }
}
