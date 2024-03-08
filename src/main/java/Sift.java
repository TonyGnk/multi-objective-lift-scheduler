import helper_functions.DefaultStruct;
import helper_functions.Gender;

import java.util.ArrayList;
import java.util.List;


public class Sift implements DefaultStruct {
    public final List<Range> ranges = new ArrayList<>();
    private int day;

    public Sift(int day, int numberOfRanges) {
        for (int i = 0; i < numberOfRanges; i++) {
            this.ranges.add(new Range());
            this.day = day;
        }
    }
    //generate a random worker for a range

    public void setWorkerInAnyNotFixedRange(int workerId) {
        for (Range range : ranges) {
            if (!range.isFixed()) {
                range.setFixedWorker(workerId);
                break;
            }
        }
    }

    public boolean canSetWorkerInAnyNotFixedRange(int workerId) {
        for (Range range : ranges) {
            if (!range.isFixed() && range.canBeFixedWorker(workerId)) {
                return true;
            }
        }
        return false;
    }

    private boolean existAtLeastOneGender() {
        boolean existMale = false;
        boolean existFemale = false;
        for (Range currentRange : ranges) {
            if (currentRange.genderExists(Gender.MALE)) {
                existMale = true;
            }
            if (currentRange.genderExists(Gender.FEMALE)) {
                existFemale = true;
            }
        }
        return existFemale && existMale;

    }

    public void applyOneWorkerInSift() {
        for (Range currentRange : ranges) {
            if (currentRange.isFixed()) {
                int idOfFixedWorker = currentRange.getFirstWorkerId();
                removeFixedWorkerFromRanges(idOfFixedWorker, currentRange);
            }
        }
    }

    private void removeFixedWorkerFromRanges(
            int idOfFixedWorker, Range workersRange
    ) {
        for (Range otherRange : ranges) {
            if (otherRange != workersRange
                    && otherRange.workerExists(idOfFixedWorker)) {
                otherRange.removeWorker(idOfFixedWorker);
            }
        }
    }

    public void removeWorkersFromContinuousShift(Sift ContinousSift) {
        List<Integer> tempWorkersIDs = new ArrayList<>();
        for (Range range : this.ranges) {
            if (range.isFixed()) {
                tempWorkersIDs.add(range.getFirstWorkerId());
            }
        }
        for (Range range : ContinousSift.ranges) {
            for (Integer id : tempWorkersIDs) {
                range.removeWorker(id);
            }
        }
    }

    public void CheckIfSiftIsLastOfWeekAndApplyLP2(int positionInWeek) {
        if (positionInWeek < WeekScheduler.CurrentWeek.getSolutionList().size() - 1) {
            removeWorkersFromContinuousShift(WeekScheduler.CurrentWeek.getSolutionList().get(positionInWeek + 1));
        }

    }


    public boolean isSet() {
        for (Range range : this.ranges) {
            if (!range.isFixed()) {
                return false;
            }
        }
        return true;
    }

    public void setRandomWorkerInAnyNotFixedRangeAndApplyLPs(int positionInWeek) {
        int randomIndex;
        int workerId;
        for (Range range : ranges) {
            if (!range.isFixed()) {
                randomIndex = (int) (Math.random() * range.workers.size());
                workerId = range.workers.get(randomIndex).id;
                range.setFixedWorker(workerId);
                //LP1
                applyOneWorkerInSift();
                //LP2
                CheckIfSiftIsLastOfWeekAndApplyLP2(positionInWeek);


                break;
            }
        }
    }

    public void setRandomSeniorWorkerInRadomRangeOfMorningSift(int positionInWeek) {
        for (Range range : ranges) {
            if (!range.isFixed() && range.seniorWorkerExists()) {
                List<Worker> seniorWorkers = range.returnSeniorWorkers();

                int randomIndex = (int) (Math.random() * seniorWorkers.size());
                range.setFixedWorker(seniorWorkers.get(randomIndex).id);
                //seniorWorkers.get(randomIndex).id
                //LP1
                applyOneWorkerInSift();
                //LP2
                CheckIfSiftIsLastOfWeekAndApplyLP2(positionInWeek);
                break;


            }
        }


    }

    public boolean hasEmptyRange() {
        for (Range range : ranges) {
            if (range.workers.isEmpty()) return true;

        }
        return false;
    }


    public void print() {
        for (Range range : ranges) {
            range.print();
        }
        System.out.println();//\n
    }
}