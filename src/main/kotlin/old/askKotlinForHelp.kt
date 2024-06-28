package old

import model.Time

//import helper_functions.Day
//import helper_functions.Time
//
//// In this project the Java code is converted to Kotlin to run using the Kotlin compiler.
//// If you have greek characters inside the java file and run the kotlin compiler, the letters will be converted to question marks.
//// Because of this, I create this kotlin function to handle the greek characters and return the workers list.
//// @TonyGnk
////fun getWorkers(): List<Worker> {
////    return listOf(
////        // SU: 0, Seniors: 1,2,3
////        Worker("Γιαννακοβίτης", Gender.MALE, WorkerType.SU),//0
////        Worker("Καρυτόπουλος", Gender.MALE, WorkerType.SENIOR),//1
////        Worker("Σιδηρόπουλος", Gender.MALE, WorkerType.SENIOR), //2
////        Worker("Στογιάννου", Gender.MALE, WorkerType.SENIOR), //3
////        Worker("Μαυροκεφαλίδου", Gender.FEMALE, WorkerType.STAFF), //4
////        Worker("Γραμμένας", Gender.MALE, WorkerType.STAFF), //5
////        Worker("Παπαστεγίου", Gender.MALE, WorkerType.STAFF), //6
////        Worker("Συροπούλου", Gender.FEMALE, WorkerType.STAFF), //7
////        Worker("Βασιλειάδη", Gender.MALE, WorkerType.STAFF), //8
////        Worker("Λουκίδου", Gender.FEMALE, WorkerType.STAFF), //9
////        Worker("Μαλλού", Gender.FEMALE, WorkerType.STAFF), //10
////        Worker("Χατζοπούλου", Gender.FEMALE, WorkerType.STAFF) //11
////    )
////}
//
//val workersRemainingWorkTimes = List(12) { 5 } //Ο ορισμός της απλότητας
//
//
//private var latestId: Int = -1
//
//fun getWorkersLatestId(): Int {
//    if (latestId == 11) latestId = -1
//
//    latestId++
//    return latestId
//}
//
//fun combineIds(range: model.Range): StringBuilder {
//    val workersSize: Int = 20
//    val workerNames = StringBuilder()
//
//
//    for (i in 0 until workersSize) {
//        if (range.exists(i)) {
//            workerNames.append(i)
//        } else {
//            //If worker doesn't exist, add `space` with equal size if was existed
//            val idInStringSize = i.toString().length
//            workerNames.append(" ".repeat(idInStringSize))
//        }
//        //In the last worker don't add space (11|0)
//        if (i != workersSize - 1) {
//            workerNames.append(" ")
//        }
//    }
//    return workerNames
//}

//
////fun getSpaceEqualToCombineRow(): StringBuilder {
////    val range = model.Range()
////    val idsRow = combineIds(range)
////    val idSize = idsRow.length
////    val space = StringBuilder()
////
////    space.append(" ".repeat(idSize))
////    return space
////}
//
//
//fun weekPrinter(week: Week) {
//    weekPrinterMorning(week)
//}
//
//
//val printColorMap =
//    mapOf(Time.MORNING to ::printBlue, Time.AFTERNOON to ::printOrange, Time.NIGHT to ::printDef)
//
fun printColorTime(time: Time, str: StringBuilder) {

    when (time) {
        Time.MORNING -> ::printBlue
        Time.AFTERNOON -> ::printOrange
        Time.NIGHT -> ::printDef
    }.invoke(str.toString())
}

//
fun printBlue(text: String) {
    print("\u001B[34m$text")
    print("\u001B[0m")
}

//
fun printOrange(text: String) {
    print("\u001B[33m$text")
    print("\u001B[0m")
}

//
fun printDef(text: String) {
    print("\u001B[0m$text")
}
//
//fun printGreen(text: String) {
//    println("\u001B[32m$text")
//    print("\u001B[0m")
//}
//
//fun printRed(text: String) {
//    println("\u001B[31m$text")
//    print("\u001B[0m")
//}
//
//val findDayType = mapOf(
//    1 to Day.NORMAL,
//    2 to Day.NORMAL,
//    3 to Day.NORMAL,
//    4 to Day.NORMAL,
//    5 to Day.NORMAL,
//    6 to Day.WEEKEND,
//    7 to Day.WEEKEND,
//)
