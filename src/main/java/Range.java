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

	//? New method
	public boolean canBeFixedWorker(int id) {
		return GetWorkLimitsKt.getWorkLimit().get(id) > 0;
	}

	public void setFixedWorker(int fixedWorkerId) {
		workers = workers
				.stream().filter(worker -> worker.id == fixedWorkerId)
				.collect(Collectors.toList());
		int currentTimes = GetWorkLimitsKt.getWorkLimit().get(fixedWorkerId);
		GetWorkLimitsKt.getWorkLimit().set(fixedWorkerId, currentTimes - 1);

		//
	}

	public boolean workerExists(int id) {
		return workers.stream().anyMatch(worker -> worker.id == id);
	}

	public String workerNamesInOneLine() {
		StringBuilder workerNamesInOneLine = new StringBuilder();
		for (Worker worker : workers) {
			workerNamesInOneLine.append(worker.id).append(" ");
		}
		return workerNamesInOneLine.toString();
	}

	public void print() {
		StringBuilder workerNamesInOneLine = new StringBuilder();
		for (Worker worker : workers) {
			workerNamesInOneLine.append(worker.id).append(" ");
		}
		System.out.println(workerNamesInOneLine);
	}

	public void printNew() {
		System.out.println(returnNew());
	}

	public String returnNew() {
		StringBuilder workerNamesInOneLine = new StringBuilder();
		for (int i = 0; i < GetWorkersKt.getWorkers().size(); i++) {
			if (workerExists(i)) {
				workerNamesInOneLine.append(i);
			} else {
				int idInStringSize = Integer.toString(i).length();
				workerNamesInOneLine.append(" ".repeat(idInStringSize));
			}
			if (i != GetWorkersKt.getWorkers().size() - 1) {
				workerNamesInOneLine.append(" ");
			}
		}
		return workerNamesInOneLine.toString();
	}
}