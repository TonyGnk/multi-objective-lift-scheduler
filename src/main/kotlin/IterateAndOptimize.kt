import model.Range
import model.next
import model.previous
import old.printBlue


fun previousFunction(
    listToOptimize: MutableList<Range>,
    updatedListIndexes: List<Int> = listToOptimize.indices.toList()
) {
    for (index in updatedListIndexes) {
        iterateAndOptimize(listToOptimize, index)
    }
}


fun iterateAndOptimize(
    listToOptimize: MutableList<Range>,
    updatedIndex: Int,
) {
    printBlue(updatedIndex.toString())
    val newUpdatedListIndexes = mutableListOf<Int>()

    if (listToOptimize[updatedIndex].possibleWorkers.size == 1) {
        printBlue("F")

        val fixedWorkerId = listToOptimize[updatedIndex].possibleWorkers[0]
        val momentOfIndex = listToOptimize[updatedIndex].moment
        val previousMoment = momentOfIndex.previous()
        val nextMoment = momentOfIndex.next()

        val listOfTheSameMomentIndexes: List<Int> = listToOptimize.filter {
            (it.moment == momentOfIndex || it.moment == previousMoment || it.moment == nextMoment) &&
                    it.id != updatedIndex
        }.map { it.id }
        printBlue("+${listOfTheSameMomentIndexes} ")

        for (index in listOfTheSameMomentIndexes) {
            if (listToOptimize[index].possibleWorkers.contains(fixedWorkerId)) {
                listToOptimize[index].possibleWorkers.remove(fixedWorkerId)

                newUpdatedListIndexes.add(index)
            }
        }

    }

    for (index in newUpdatedListIndexes) {
        iterateAndOptimize(listToOptimize, index)
    }
}
