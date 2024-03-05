import java.util.List;

public class WeekScheduler {
    private Week CurrentWeek;

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
                    SiftsList.get(i).setRandomWorkerInAnyNotFixedRange();
                    //Apply LP2
                    if (i < SiftsList.size() - 1) {
                        SiftsList.get(i).removeWorkersFromContinuousShift(SiftsList.get(i + 1));
                    }
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

}
