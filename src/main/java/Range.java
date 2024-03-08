import helper_functions.DefaultStruct;
import helper_functions.Gender;
import helper_functions.WorkerType;

import java.util.List;
import java.util.stream.Collectors;

public class Range implements DefaultStruct {
    public List<Worker> workers;

    public Range() {
        workers = GetWorkersKt.getWorkers();
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
        boolean dayOfRule = GetWorkLimitsKt.getWorkLimit().get(id) > 0;
        boolean genderRuleA = genderExists(Gender.MALE);
        boolean genderRuleB = genderExists(Gender.FEMALE);

        return (dayOfRule && genderRuleA && genderRuleB);
    }

    public void setFixedWorker(int fixedWorkerId) {
        workers = workers
                .stream().filter(worker -> worker.id == fixedWorkerId)
                .collect(Collectors.toList());
        int currentTimes = GetWorkLimitsKt.getWorkLimit().get(fixedWorkerId);
        GetWorkLimitsKt.getWorkLimit().set(fixedWorkerId, currentTimes - 1);
    }

    public boolean workerExists(int id) {
        return workers.stream().anyMatch(worker -> worker.id == id);
    }

    public List<Worker> returnSeniorWorkers() {
        return workers.stream().filter(worker -> worker.type == WorkerType.SENIOR)
                .collect(Collectors.toList());
    }

    public boolean seniorWorkerExists() {
        return workers.stream().anyMatch(worker -> worker.type == WorkerType.SENIOR);
    }

    public boolean genderExists(Gender gender) {
        return workers.stream().anyMatch(worker -> worker.gender == gender);
    }


    public String workerNamesInOneLine() {
        StringBuilder workerNamesInOneLine = new StringBuilder();
        for (Worker worker : workers) {
            workerNamesInOneLine.append(worker.id).append(" ");
        }
        return workerNamesInOneLine.toString();
    }


    public void print() {
        System.out.println(getAllNames());
    }

    public String getAllNames() {
        int workersSize = GetWorkersKt.getWorkers().size();
        StringBuilder workerNames = new StringBuilder();

        for (int i = 0; i < workersSize; i++) {
            if (workerExists(i)) {
                workerNames.append(i);
            } else {
                //If worker doesn't exist, add `space` with equal size if was exist
                int idInStringSize = Integer.toString(i).length();
                workerNames.append(" ".repeat(idInStringSize));
            }
            //In the last worker don't add space (11|0)
            if (i != workersSize - 1) {
                workerNames.append(" ");
            }
        }
        return workerNames.toString();
    }
}

