package manager_blocks

import Week
import helper_functions.Gender
import helper_functions.Time

fun applyRules(week: Week) {
    var mustApplyAgain = 0

    //Apply the rules to the week
    mustApplyAgain += allGendersAtMorning(week)


    if (mustApplyAgain != 0) {
        applyRules(week)
    }
}

//This rule scan for the numbers of males and females
//in a morning sift and if the number is only 1, then
//will set the worker
fun allGendersAtMorning(week: Week): Int {
    var mustApplyAgain = 0

    val morningSifts = week.collectSiftsWithTime(Time.MORNING)

    for (sift in morningSifts) {
        val males = sift.onlyOneGender(Gender.MALE)
        val females = sift.onlyOneGender(Gender.FEMALE)

        //If males is 1 then set this male worker
        if (males) {
            val uniqueMale = sift.getFirstGenderId(Gender.MALE)
            sift.setWorkerInAnyNotFixedRange(uniqueMale)
        }

    }


    return mustApplyAgain
}