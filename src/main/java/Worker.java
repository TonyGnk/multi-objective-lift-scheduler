import helper_functions.DefaultStruct;
import helper_functions.Gender;
import helper_functions.WorkerType;

import java.util.List;

public class Worker implements DefaultStruct {
    public static List<Worker> ListOfWorkers = GetWorkersKt.getWorkers();
    public final String name;
    public final int id;
    public final WorkerType type;
    public final Gender gender;

    public Worker(String name, Gender gender, WorkerType type) {
        int latestId = GetWorkersKt.getWorkersLatestId();

        this.name = name;
        this.gender = gender;
        this.id = latestId;
        this.type = type;
    }

    public void print() {
        System.out.println(id);
    }
}