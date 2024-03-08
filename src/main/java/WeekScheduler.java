import java.util.List;

public class WeekScheduler {
    public static Week CurrentWeek;

    public WeekScheduler() {
        this.CurrentWeek = new Week();
    }

    public Week ProgrammGenerator() {
        int i = 0;
        Week initialWeek = new Week();
        List<Sift> SiftsList = CurrentWeek.getSolutionList();
        //When i=SolutionList.size then every sift has a worker
        while (i < SiftsList.size()) {
            if (SiftsList.get(i).isSet()) {
                i++;
            } else {
                while (!SiftsList.get(i).isSet()) {
                    //Set a Worker in a Sift and apply LP1
                    SiftsList.get(i).setRandomWorkerInAnyNotFixedRangeAndApplyLPs(i);
                    //Apply LP2
                    //If there is a range that is empty restart the process
                    if (this.CurrentWeek.CheckForUnsolvableWeek()) {
                        System.out.println("Unsolvable situation");
                        i = 0;
                        SiftsList = initialWeek.getSolutionList();


                    }
                }

            }

        }
        return CurrentWeek;
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




