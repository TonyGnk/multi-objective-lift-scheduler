//import java.util.List;
//
//public class WeekScheduler {
//    public static Week CurrentWeek;
//
//    public WeekScheduler() {
//        CurrentWeek = new Week();
//    }
//
//    public Week ProgramGenerator() {
//        int i = 0;
//        Week initialWeek = new Week();
//        List<model.Shift> ShiftsList = CurrentWeek.solutionList;
//        //When i=SolutionList.size then every sift has a worker
//        while (i < ShiftsList.size()) {
//            checkForMorningSiftAndApplyLP5(i, ShiftsList.get(i));
//            if (ShiftsList.get(i).isFixed()) {
//                i++;
//            } else {
//                while (!ShiftsList.get(i).isFixed()) {
//                    //Set a Worker in a Sift and apply LP1
//                    ShiftsList.get(i).setRandomWorkerInAnyNotFixedRangeAndApplyLPs(i);
//                    //Apply LP2
//                    //If there is a range that is empty restart the process
//                    if (CurrentWeek.CheckForUnsolvableWeek()) {
//                        System.out.println("Unsolvable situation");
//                        i = 0;
//                        ShiftsList = initialWeek.solutionList;
//                    }
//                }
//
//            }
//
//        }
//        return CurrentWeek;
//    }
//
//    public void checkForMorningSiftAndApplyLP5(int positionInWeek, model.Shift MorningSift) {
//        if (positionInWeek % 3 == 0) MorningSift.setRandomSeniorWorkerInRandomRangeOfMorningShift(positionInWeek);
//    }
//
////    public Week try1(List<Sift> SiftsList, int i, Week initialWeek) {
////        while (!SiftsList.get(i).isSet()) {
////            //Set a Worker in a Sift and apply LP1
////            SiftsList.get(i).setRandomWorkerInAnyNotFixedRangeAndApplyLPs(i);
////            //If there is a range that is empty restart the process
////            if (this.CurrentWeek.CheckForUnsolvableWeek()) {
////                System.out.println("Unsolvable situation");
////                i = 0;
////                SiftsList = initialWeek.getSolutionList();
////
////
////            }
////
////        }
////        return CurrentWeek;
////
////    }
//
//}
