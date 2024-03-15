import helper_functions.Time

fun weekPrinterMorning(week: Week) {
    weekPrinterPerTime(week, Time.MORNING)
    weekPrinterPerTime(week, Time.AFTERNOON)
    weekPrinterPerTime(week, Time.NIGHT)
}

fun weekPrinterPerTime(week: Week, time: Time) {
    val sifts = week.solutionList.filter { it.time == time }.toList()
    //println("Shifts with time $time are: ${sifts.size}")


    //Find the max size of the ranges
    val maxNumberOfRows = sifts.maxOf { it.ranges.size }

    //Create a list of StringBuild with size maxNumberOfRows
    val listSB2 = MutableList(maxNumberOfRows) { StringBuilder() }

    for (i in sifts.indices) {
        for (j in 0 until maxNumberOfRows) {
            //If morningShifts[i].ranges[j] exists, append the id of the worker else add \n
            if (sifts[i].ranges.size > j) {
                listSB2[j].append(sifts[i].ranges[j].ids)
            } else {
                listSB2[j].append(getSpaceEqualToCombineRow())
            }
            if (i != sifts.size - 1) {
                listSB2[j].append("|")
            }
        }
    }

    if (sifts.size != week.days && time != Time.NIGHT) {
        //Insert at the start of every row a getSpaceEqualToCombineRow()
        for (i in 0 until maxNumberOfRows) {
            listSB2[i].insert(0, "|")
            listSB2[i].insert(0, getSpaceEqualToCombineRow())

        }
    }

    printResult(listSB2, maxNumberOfRows, time)
}

private fun printResult(
    listSB2: MutableList<StringBuilder>, maxNumberOfRows: Int, time: Time
) {
    for (i in 0 until maxNumberOfRows) {
        printColorMap[time]?.invoke(listSB2[i].toString())
    }
}