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
                listSB[j].append(weekList[i].ranges[j].getIds())
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