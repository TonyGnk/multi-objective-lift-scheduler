import com.tonyGnk.core.model.scheduler.Range
import com.tonyGnk.core.model.time.next
import com.tonyGnk.core.model.time.previous


fun previousFunction(
    listToOptimize: MutableList<Range>,
    updatedListIndexes: List<Int> = listToOptimize.indices.toList()
) {
    //println("The updated indexes are $updatedListIndexes")
    for (index in updatedListIndexes) {
        iterateAndOptimize(listToOptimize, index)
    }
}


fun iterateAndOptimize(
    listToOptimize: MutableList<Range>,
    updatedIndex: Int,
) {
    //println("The updated index is $updatedIndex")
    val newUpdatedListIndexes = mutableListOf<Int>()

    if (listToOptimize[updatedIndex].possibleWorkers.size == 1) {

        val fixedWorker = listToOptimize[updatedIndex].possibleWorkers[0]
        val momentOfIndex = listToOptimize[updatedIndex].moment
        val previousMoment = momentOfIndex.previous()
        val nextMoment = momentOfIndex.next()


        val listOfTheSameMomentIndexes: List<Int> = listToOptimize.filter {
            (it.moment == momentOfIndex || it.moment == previousMoment || it.moment == nextMoment) &&
                    it.id != updatedIndex
        }.map { it.id }
        //printBlue("listOfTheSameMoment $listOfTheSameMomentIndexes \n")


        for (index in listOfTheSameMomentIndexes) {
            if (listToOptimize[index].possibleWorkers.contains(fixedWorker)) {
                //listToOptimize.print()
                // print("\n")
                //listToOptimize[index].possibleWorkers.filter { it.id != fixedWorker.id }
                //listToOptimize[index] = listToOptimize[index].removeWorker(fixedWorker)
                listToOptimize[index].possibleWorkers.removeIf { it.id == fixedWorker.id }
                //listToOptimize.print()


                newUpdatedListIndexes.add(index)
            }
        }
        //printDef("newUpdatedListIndexes $newUpdatedListIndexes \n")
    }


    for (index in newUpdatedListIndexes) {
        iterateAndOptimize(listToOptimize, index)
    }
}
