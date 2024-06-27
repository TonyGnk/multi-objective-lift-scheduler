//import helper_functions.WorkerType;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.stream.Collectors;
//
//public class Range {
//    public List<Worker> workers;
//
//    public Range() {
//        workers = AskKotlinForHelpKt.getWorkers();
//    }
//
//    public Range(List<Worker> workers) {
//        workers = new ArrayList<>(workers);
//    }
//
//    public boolean isFixed() {
//        return workers.size() == 1;
//    }
//
//    public int getFirstWorkerId() {
//        if (!workers.isEmpty()) {
//            return workers.get(0).id;
//        } else {
//            throw new NoSuchElementException("No elements in the workers list");
//        }
//    }
//
//    public void removeWorker(int idForRemove) {
//        workers = workers.stream().filter(worker -> worker.id != idForRemove)
//                .collect(Collectors.toList());
//    }
//
//    public boolean canBeFixedWorker(int id) {
//        boolean dayOfRule = AskKotlinForHelpKt.getWorkersRemainingWorkTimes().get(id) > 0;
//        boolean genderRuleA = exists(Gender.MALE);
//        boolean genderRuleB = exists(Gender.FEMALE);
//
//        return (dayOfRule && genderRuleA && genderRuleB);
//    }
//
//    public void setFixedWorker(int fixedWorkerId) {
//        workers = workers
//                .stream().filter(worker -> worker.id == fixedWorkerId)
//                .collect(Collectors.toList());
//        int currentTimes = AskKotlinForHelpKt.getWorkersRemainingWorkTimes().get(fixedWorkerId);
//        AskKotlinForHelpKt.getWorkersRemainingWorkTimes().set(fixedWorkerId, currentTimes - 1);
//    }
//
//
//    public List<Worker> getSeniorWorkers() {
//        return workers.stream().filter(worker -> worker.type == WorkerType.SENIOR)
//                .collect(Collectors.toList());
//    }
//
//
//    public <T> boolean exists(T attribute) {
//        return workers.stream().anyMatch(worker -> {
//            if (attribute instanceof Gender) {
//                return worker.gender == attribute;
//            } else if (attribute instanceof WorkerType) {
//                return worker.type == attribute;
//            } else if (attribute instanceof Integer) {
//                return worker.id == (Integer) attribute;
//            }
//            return false;
//        });
//    }
//
//    public List<Integer> collectWorkersWithGender(Gender gender) {
//        return workers.stream().filter(worker -> worker.gender == gender)
//                .map(worker -> worker.id)
//                .collect(Collectors.toList());
//    }
//
//    public void print() {
//        System.out.println(getIds());
//    }
//
//    public StringBuilder getIds() {
//        return AskKotlinForHelpKt.combineIds(this);
//    }
//
//
//}
