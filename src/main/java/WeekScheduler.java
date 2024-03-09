import java.util.List;

public class WeekScheduler {
    public static Week CurrentWeek;

    public WeekScheduler() {
        CurrentWeek = new Week();
    }

    public Week ProgramGenerator() {
        int i = 0;
        Week initialWeek = new Week();
        List<Sift> SiftsList = CurrentWeek.solutionList;
        //When i=SolutionList.size then every sift has a worker
        while (i < SiftsList.size()) {
            checkForMorningSiftAndApplyLP5(i, SiftsList.get(i));
            if (SiftsList.get(i).isSet()) {
                i++;
            } else {
                while (!SiftsList.get(i).isSet()) {
                    //Set a Worker in a Sift and apply LP1
                    SiftsList.get(i).setRandomWorkerInAnyNotFixedRangeAndApplyLPs(i);
                    //Apply LP2
                    //If there is a range that is empty restart the process
                    if (CurrentWeek.CheckForUnsolvableWeek()) {
                        System.out.println("Unsolvable situation");
                        i = 0;
                        SiftsList = initialWeek.solutionList;
                    }
                }

            }

        }
        return CurrentWeek;
    }

    public void checkForMorningSiftAndApplyLP5(int positionInWeek, Sift MorningSift) {
        if (positionInWeek % 3 == 0) MorningSift.setRandomSeniorWorkerInRandomRangeOfMorningSift(positionInWeek);
    }

//    public Week try1(List<Sift> SiftsList, int i, Week initialWeek) {
//        while (!SiftsList.get(i).isSet()) {
//            //Set a Worker in a Sift and apply LP1
//            SiftsList.get(i).setRandomWorkerInAnyNotFixedRangeAndApplyLPs(i);
//            //If there is a range that is empty restart the process
//            if (this.CurrentWeek.CheckForUnsolvableWeek()) {
//                System.out.println("Unsolvable situation");
//                i = 0;
//                SiftsList = initialWeek.getSolutionList();
//
//
//            }
//
//        }
//        return CurrentWeek;
//
//    }

}