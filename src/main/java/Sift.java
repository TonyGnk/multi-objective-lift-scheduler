import helper_functions.Day;
import helper_functions.Gender;
import helper_functions.Time;
import helper_functions.WorkerType;
import manager_blocks.RangesNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static manager_blocks.RangesNumberKt.getDayType;


public class Sift {
    public final List<Range> ranges = new ArrayList<>();
    public final Time time;
    public final Day day;


    public Sift(int day, Time time) {
        this.day = getDayType(day);
        this.time = time;

        int numberOfRanges = new RangesNumber().get(time, getDayType(day));
        IntStream.range(0, numberOfRanges).forEach(i -> ranges.add(new Range()));
    }

    public Sift() {
        this(1, Time.MORNING);
    }

    public void solve(int workerId) {
        for (Range range : ranges) {
            if (!range.isFixed()) {
                //Copy the current range in a copy variable
                Range copy = new Range(range.workers);
                range.tryToSolve();

                //range.setFixedWorker(workerId);
                break;
            }
        }
    }

    public void applyRules() {
        // 4 | 2,4 | 2,3
        // 4 | 2 | 2,3
    }

//    public void setWorkerInAnyNotFixedRange(int workerId) {
//        for (Range range : ranges) {
//            if (!range.isFixed()) {
//                range.setFixedWorker(workerId);
//                break;
//            }
//        }
//    }

    public boolean setWorkerInAnyNotFixedRange(int workerId) {
        for (Range range : ranges) {
            if (!range.isFixed() && range.canBeFixedWorker(workerId)) {
                range.setFixedWorker(workerId);
                return true;
            }
        }
        return false;
    }


    public <T> boolean exists(T attribute) {
        return ranges.stream().anyMatch(range -> {
            if (attribute instanceof WorkerType) {
                return range.exists(attribute);
            } else if (attribute instanceof Gender) {
                return range.exists(attribute);
            }
            return false;
        });
    }

    public int getFirstGenderId(Gender gender) {
        for (Range range : ranges) {
            if (range.exists(gender)) {
                return range.getFirstGenderId(gender);
            }
        }
        return -1;
    }

    public boolean onlyOneGender(Gender gender) {
        int count = 0;
        for (Range range : ranges) {
            count += range.getNumberGender(gender);
        }
        return count == 1;
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
                removeWorker(ranges.indexOf(otherRange), idOfFixedWorker);
            }
        }
    }

    private void removeWorker(int range, int idForRemove) {
        ranges.get(range).removeWorker(idForRemove);
        applyRules();
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


    public boolean isFixed() {
        return ranges.stream().allMatch(Range::isFixed);
    }
//
//    public void setRandomWorkerInAnyNotFixedRangeAndApplyLPs(int positionInWeek) {
//        int randomIndex;
//        int workerId;
//        for (Range range : ranges) {
//            if (!range.isFixed()) {
//                randomIndex = (int) (Math.random() * range.workers.size());
//                workerId = range.workers.get(randomIndex).id;
//                range.setFixedWorker(workerId);
//                //LP1
//                applyOneWorkerInSift();
//                //LP2
//                CheckIfSiftIsLastOfWeekAndApplyLP2(positionInWeek);
//
//                break;
//            }
//        }
//    }
//    public void setRandomSeniorWorkerInRandomRangeOfMorningSift(int positionInWeek) {
//        for (Range range : ranges) {
//            if (!range.isFixed() && range.exists(WorkerType.SENIOR)) {
//                List<Worker> seniorWorkers = range.getSeniorWorkers();
//
//                int randomIndex = (int) (Math.random() * seniorWorkers.size());
//                range.setFixedWorker(seniorWorkers.get(randomIndex).id);
//                //seniorWorkers.get(randomIndex).id
//                //LP1
//                applyOneWorkerInSift();
//                //LP2
//                CheckIfSiftIsLastOfWeekAndApplyLP2(positionInWeek);
//                break;
//            }
//        }
//    }
//
//    public boolean hasEmptyRange() {
//        for (Range range : ranges) {
//            if (range.workers.isEmpty()) return true;
//        }
//        return false;
//    }
//public void CheckIfSiftIsLastOfWeekAndApplyLP2(int positionInWeek) {
//    if (positionInWeek < WeekScheduler.CurrentWeek.solutionList.size() - 1) {
//        removeWorkersFromContinuousShift(WeekScheduler.CurrentWeek.solutionList.get(positionInWeek + 1));
//    }
//}


    public void print() {
        System.out.println(getRangesInLines());
    }

    public StringBuilder getRangesInLines() {
        StringBuilder string = new StringBuilder();
        for (Range range : ranges) {
            string.append(range.getIds());
            string.append("\n");
        }
        return string;
    }
}