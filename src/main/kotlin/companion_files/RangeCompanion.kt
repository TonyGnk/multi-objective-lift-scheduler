package companion_files

import Range
import getWorkers

fun combineIds(range: Range, workerNames: StringBuilder): StringBuilder {
    val workersSize: Int = getWorkers().size

    for (i in 0 until workersSize) {
        if (range.workerExists(i)) {
            workerNames.append(i)
        } else {
            //If worker doesn't exist, add `space` with equal size if was existed
            val idInStringSize = i.toString().length
            workerNames.append(" ".repeat(idInStringSize))
        }
        //In the last worker don't add space (11|0)
        if (i != workersSize - 1) {
            workerNames.append(" ")
        }
    }
    return workerNames
}