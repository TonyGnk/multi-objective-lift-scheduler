import helper_functions.Day
import helper_functions.Gender
import helper_functions.WorkerType

// In this project the Java code is converted to Kotlin to run using the Kotlin compiler.
// If you have greek characters inside the java file and run the kotlin compiler, the letters will be converted to question marks.
// Because of this, I create this kotlin function to handle the greek characters and return the workers list.
// @TonyGnk
fun getWorkers(): List<Worker> {
    return listOf(
        // SU: 0, Seniors: 1,2,3
        Worker("Γιαννακοβίτης", Gender.MALE, WorkerType.SU),
        Worker("Καρυτόπουλος", Gender.MALE, WorkerType.SENIOR),
        Worker("Σιδηρόπουλος", Gender.MALE, WorkerType.SENIOR),
        Worker("Στογιάννου", Gender.MALE, WorkerType.SENIOR),
        Worker("Μαυροκεφαλίδου", Gender.FEMALE, WorkerType.STAFF),
        Worker("Γραμμένας", Gender.MALE, WorkerType.STAFF),
        Worker("Παπαστεγίου", Gender.MALE, WorkerType.STAFF),
        Worker("Συροπούλου", Gender.FEMALE, WorkerType.STAFF),
        Worker("Βασιλειάδη", Gender.MALE, WorkerType.STAFF),
        Worker("Λουκίδου", Gender.FEMALE, WorkerType.STAFF),
        Worker("Μαλλού", Gender.FEMALE, WorkerType.STAFF),
        Worker("Χατζοπούλου", Gender.FEMALE, WorkerType.STAFF)
    )
}

val workLimit = List(12) { 5 } //Ο ορισμός της απλότητας


private var latestId: Int = -1

fun getWorkersLatestId(): Int {
    if (latestId == 11) latestId = -1

    latestId++
    return latestId
}

fun combineIds(range: Range): StringBuilder {
    val workersSize: Int = getWorkers().size
    val workerNames = StringBuilder()


    for (i in 0 until workersSize) {
        if (range.exists(i)) {
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

fun weekPrinter(weekList: MutableList<Sift>) {

    // Repeat 3 times
    for (siftType in 0..2) {

        // Create a list of StringBuilder based on the size of the ranges
        // For example, for the morning sift we have a list of 3 StringBuilder
        val listSB = MutableList(weekList[siftType].ranges.size) { StringBuilder() }

        // The morning sifts are in 0,3,6
        // The afternoon sifts are in 1,4,7
        // The night sifts are in 2,5,8
        for (i in siftType until weekList.size step 3) {


            // For each range, we create a row with "|"
            for (j in weekList[i].ranges.indices) {
                listSB[j].append(weekList[i].ranges[j].ids)
                //if j is in last index of the list, we don't append "|"
                if (i + 3 < weekList.size) {
                    listSB[j].append("|")
                }
            }

        }

        // Print the list of StringBuilder
        for (sb in listSB) {
            // We use the printColorMap to print the StringBuilder with the correct color
            // The printColorMap is a map of Int to function
            // For 0 printBlue, for 1 printOrange and int 2 printDefault
            printColorMap[siftType]?.invoke(sb.toString())
        }
    }
    println()
}


val printColorMap = mapOf(0 to ::printBlue, 1 to ::printOrange, 2 to ::printDef)


fun printBlue(text: String) {
    println("\u001B[34m$text")
    print("\u001B[0m")
}

fun printOrange(text: String) {
    println("\u001B[33m$text")
    print("\u001B[0m")
}

fun printDef(text: String) {
    println("\u001B[0m$text")
}

fun printGreen(text: String) {
    println("\u001B[32m$text")
    print("\u001B[0m")
}

fun printRed(text: String) {
    println("\u001B[31m$text")
    print("\u001B[0m")
}

val findDayType = mapOf(
    1 to Day.NORMAL,
    2 to Day.NORMAL,
    3 to Day.NORMAL,
    4 to Day.NORMAL,
    5 to Day.NORMAL,
    6 to Day.WEEKEND,
    7 to Day.WEEKEND,
)