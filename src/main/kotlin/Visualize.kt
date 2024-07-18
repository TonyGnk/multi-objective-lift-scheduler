import com.tonyGnk.core.model.scheduler.Range
import com.tonyGnk.core.model.time.Time
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

fun MutableList<Range>.toText(): String {
    var result = ""
    this.forEach {
        result += "${it.id} -  ["
        it.possibleWorkers.forEach { worker ->
            result += worker.id + if (it.possibleWorkers.last() != worker) ", " else ""
        }
        result += "]  ${it.moment.date}\n"
    }
    return result
}

fun printPerTime(text: String, time: Time) {
    when (time) {
        Time.NIGHT -> printDef(text)
        Time.MORNING -> printOrange(text)
        Time.AFTERNOON -> printBlue(text)
    }
}
