//package rules.one_time
//
//import model.Range
//import Week
//import helper_functions.Gender
//import helper_functions.Time
//import printGreen
//
///**
// * This one-time rule sets a male and female worker in every morning shift
// *
// * @param week The week for which the morning shifts are to be set
// * @param showMessages A boolean to show the debug messages or not
// * @return Nothing
// */
//fun setBothGenderInMorningShifts(week: Week, showMessages: Boolean) {
//    val morningShifts = week.collectShiftsWith(Time.MORNING)
//
//    val shiftsWithoutMaleFixed = morningShifts.filter { !it.isFixed(Gender.MALE) }
//    val idsOfMales = model.Range().collectWorkersWithGender(Gender.MALE)
//    fixWorkersToShiftsRandomly(idsOfMales, shiftsWithoutMaleFixed)
//
//    val shiftsWithoutFemaleFixed = morningShifts.filter { !it.isFixed(Gender.FEMALE) }
//    val idsOfFemales = model.Range().collectWorkersWithGender(Gender.FEMALE)
//    fixWorkersToShiftsRandomly(idsOfFemales, shiftsWithoutFemaleFixed)
//
//    if (showMessages) {
//        printGreen("\nEvery morning shift has both genders")
//        week.print()
//    }
//}
