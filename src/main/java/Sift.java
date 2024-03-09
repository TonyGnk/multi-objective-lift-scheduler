import helper_functions.Gender;
import helper_functions.WorkerType;

import java.util.ArrayList;
import java.util.List;


public class Sift {
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
            if (currentRange.exists(Gender.MALE)) {
                existMale = true;
            }
            if (currentRange.exists(Gender.FEMALE)) {
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
                    && otherRange.exists(idOfFixedWorker)) {
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
        if (positionInWeek < WeekScheduler.CurrentWeek.solutionList.size() - 1) {
            removeWorkersFromContinuousShift(WeekScheduler.CurrentWeek.solutionList.get(positionInWeek + 1));
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

    public void setRandomSeniorWorkerInRandomRangeOfMorningSift(int positionInWeek) {
        for (Range range : ranges) {
            if (!range.isFixed() && range.exists(WorkerType.SENIOR)) {
                List<Worker> seniorWorkers = range.getSeniorWorkers();

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
        System.out.println(getRangeIds());
    }

    public StringBuilder getRangeIds() {
        StringBuilder rang = new StringBuilder();
        for (Range range : ranges) {
            rang.append(range.getIds());
        }
        rang.append("\n");
        return rang;
    }
}