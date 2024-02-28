import helper_functions.DefaultStruct;

import java.util.List;
import java.util.stream.Collectors;

public class Range implements DefaultStruct {
	public List<Worker> workers;

	public Range() {
		//Get the workers from a Kotlin file
		workers = GetWorkersKt.getWorkers();
	}

	// The range does not have options
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

	public void removeAllWorkersExcept(int idToStay) {
		workers = workers.stream()
				.filter(worker -> worker.id == idToStay)
				.collect(Collectors.toList());
	}

	public boolean workerExists(int id) {
		return workers.stream().anyMatch(worker -> worker.id == id);
	}

	public void print() {
		StringBuilder workerNamesInOneLine = new StringBuilder();
		for (Worker worker : workers) {
			workerNamesInOneLine.append(worker.name).append(" ");
		}
		System.out.println(workerNamesInOneLine);
	}
}