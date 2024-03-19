package rules.one_time

import Range
import Week
import helper_functions.Gender
import helper_functions.Time
import printGreen
import kotlin.random.Random.Default.nextInt

/**
 * This one-time rule sets a male and female worker in every morning shift
 *
 * @param week The week for which the morning shifts are to be set
 * @param showMessages A boolean to show the debug messages or not
 * @return Nothing
 */
fun setBothGenderInMorningShifts(week: Week, showMessages: Boolean) {
    val morningShifts = week.collectShiftsWith(Time.MORNING)
    val shiftsWithoutMaleFixed = morningShifts.filter { !it.isFixed(Gender.MALE) }
    val shiftsWithoutFemaleFixed = morningShifts.filter { !it.isFixed(Gender.FEMALE) }
    val idsOfMales = Range().collectWorkersWithGender(Gender.MALE)
    val idsOfFemales = Range().collectWorkersWithGender(Gender.FEMALE)

    var indexOfListMales = nextInt(0, idsOfMales.size)
    var indexOfListFemales = nextInt(0, idsOfFemales.size)

    for (sift in shiftsWithoutMaleFixed) {
        do {
            val maleIdForSet = idsOfMales[indexOfListMales]
            indexOfListMales = (indexOfListMales + 1) % idsOfMales.size

            val isFixSuccessful = sift.setWorkerInAnyNotFixedRange(maleIdForSet)
        } while (!isFixSuccessful)
    }

    for (sift in shiftsWithoutFemaleFixed) {
        do {
            val femaleIdForSet = idsOfFemales[indexOfListFemales]
            indexOfListFemales = (indexOfListFemales + 1) % idsOfFemales.size

            val isFixSuccessful = sift.setWorkerInAnyNotFixedRange(femaleIdForSet)
        } while (!isFixSuccessful)
    }


    if (showMessages) {
        printGreen("\nEvery morning shift has both genders")
        week.print()
    }
}