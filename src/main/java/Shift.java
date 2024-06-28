//import helper_functions.Day;
//import helper_functions.Time;
//import helper_functions.WorkerType;
//import manager_blocks.RangesNumber;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.IntStream;
//
//import static manager_blocks.RangesNumberKt.getDayType;
//
//
//public class model.Shift {
//    public final List<model.Range> ranges = new ArrayList<>();
//    public final Time time;
//    public final Day day;
//
//    public model.Shift(int day, Time time) {
//        this.day = getDayType(day);
//        this.time = time;
//
//        int numberOfRanges = new RangesNumber().get(time, getDayType(day));
//        IntStream.range(0, numberOfRanges).forEach(i -> ranges.add(new model.Range()));
//    }
//
//    public model.Shift() {
//        this(1, Time.MORNING);
//    }
//
//    public boolean setWorkerInAnyNotFixedRange(int workerId) {
//        for (model.Range range : ranges) {
//            if (!range.isFixed() && range.canBeFixedWorker(workerId)) {
//                range.setFixedWorker(workerId);
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    public void applyOneWorkerInShift() {
//        for (model.Range currentRange : ranges) {
//            if (currentRange.isFixed()) {
//                removeFixedWorkerFromRanges(currentRange);
//            }
//        }
//    }
//
//    private void removeFixedWorkerFromRanges(model.Range workersRange
//    ) {
//        int idOfFixedWorker = workersRange.getFirstWorkerId();
//        for (model.Range otherRange : ranges) {
//            if (otherRange != workersRange
//                    && otherRange.exists(idOfFixedWorker)) {
//                removeWorker(ranges.indexOf(otherRange), idOfFixedWorker);
//            }
//        }
//    }
//
//    private void removeWorker(int range, int idForRemove) {
//        ranges.get(range).removeWorker(idForRemove);
//    }
//
//    public void removeWorkersFromContinuousShift(model.Shift ContinousShift) {
//        List<Integer> tempWorkersIDs = new ArrayList<>();
//        for (model.Range range : this.ranges) {
//            if (range.isFixed()) {
//                tempWorkersIDs.add(range.getFirstWorkerId());
//            }
//        }
//        for (model.Range range : ContinousShift.ranges) {
//            for (Integer id : tempWorkersIDs) {
//                range.removeWorker(id);
//            }
//        }
//    }
//
//    public boolean hasAnyFixedWorker() {
//        return ranges.stream().anyMatch(model.Range::isFixed);
//    }
//
//
//    public boolean isFixed() {
//        return ranges.stream().allMatch(model.Range::isFixed);
//    }
//
//    public <T> boolean isFixed(T attribute) {
//        return ranges.stream().anyMatch(range -> range.exists(attribute) && range.isFixed());
//    }
//
//
//    public void setRandomWorkerInAnyNotFixedRangeAndApplyLPs(int positionInWeek) {
//        int randomIndex;
//        int workerId;
//        for (model.Range range : ranges) {
//            if (!range.isFixed()) {
//                randomIndex = (int) (Math.random() * range.workers.size());
//                workerId = range.workers.get(randomIndex).id;
//                range.setFixedWorker(workerId);
//                //LP1
//                applyOneWorkerInShift();
//                //LP2
//                CheckIfShiftIsLastOfWeekAndApplyLP2(positionInWeek);
//
//                break;
//            }
//        }
//    }
//
//    public void setRandomSeniorWorkerInRandomRangeOfMorningShift(int positionInWeek) {
//        for (model.Range range : ranges) {
//            if (!range.isFixed() && range.exists(WorkerType.SENIOR)) {
//                List<Worker> seniorWorkers = range.getSeniorWorkers();
//
//                int randomIndex = (int) (Math.random() * seniorWorkers.size());
//                range.setFixedWorker(seniorWorkers.get(randomIndex).id);
//                //seniorWorkers.get(randomIndex).id
//                //LP1
//                applyOneWorkerInShift();
//                //LP2
//                CheckIfShiftIsLastOfWeekAndApplyLP2(positionInWeek);
//                break;
//            }
//        }
//    }
//
//    public boolean hasEmptyRange() {
//        for (model.Range range : ranges) {
//            if (range.workers.isEmpty()) return true;
//        }
//        return false;
//    }
//
//    public void CheckIfShiftIsLastOfWeekAndApplyLP2(int positionInWeek) {
//        if (positionInWeek < WeekScheduler.CurrentWeek.solutionList.size() - 1) {
//            removeWorkersFromContinuousShift(WeekScheduler.CurrentWeek.solutionList.get(positionInWeek + 1));
//        }
//    }
//
//
//    public void print() {
//        AskKotlinForHelpKt.printColorTime(time, getRangesInLines());
//    }
//
//    public StringBuilder getRangesInLines() {
//        StringBuilder string = new StringBuilder();
//        for (model.Range range : ranges) {
//            string.append(range.getIds());
//            string.append("\n");
//        }
//        return string;
//    }
//}
