import helper_functions.Gender;
import helper_functions.WorkerType;

import java.util.List;
import java.util.stream.Collectors;


public class Range {
    public List<Worker> workers;

    public Range() {
        workers = AskKotlinForHelpKt.getWorkers();

    }


    public boolean isFixed() {
        return workers.size() == 1;
    }

    public int getFirstWorkerId() {
        return workers.getFirst().id;
    }

    public void removeWorker(int idForRemove) {
        workers = workers.stream().filter(worker -> worker.id != idForRemove)
                .collect(Collectors.toList());
    }

    public boolean canBeFixedWorker(int id) {
        boolean dayOfRule = AskKotlinForHelpKt.getWorkLimit().get(id) > 0;
        boolean genderRuleA = exists(Gender.MALE);
        boolean genderRuleB = exists(Gender.FEMALE);

        return (dayOfRule && genderRuleA && genderRuleB);
    }

    public void setFixedWorker(int fixedWorkerId) {
        workers = workers
                .stream().filter(worker -> worker.id == fixedWorkerId)
                .collect(Collectors.toList());
        int currentTimes = AskKotlinForHelpKt.getWorkLimit().get(fixedWorkerId);
        AskKotlinForHelpKt.getWorkLimit().set(fixedWorkerId, currentTimes - 1);
    }


    public List<Worker> getSeniorWorkers() {
        return workers.stream().filter(worker -> worker.type == WorkerType.SENIOR)
                .collect(Collectors.toList());
    }


    public <T> boolean exists(T attribute) {
        return workers.stream().anyMatch(worker -> {
            if (attribute instanceof Gender) {
                return worker.gender == attribute;
            } else if (attribute instanceof WorkerType) {
                return worker.type == attribute;
            } else if (attribute instanceof Integer) {
                return worker.id == (Integer) attribute;
            }
            return false;
        });
    }

    public void print() {
        System.out.println(getIds());
    }

    public StringBuilder getIds() {
        return AskKotlinForHelpKt.combineIds(this);
    }
}