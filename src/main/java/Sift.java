import helper_functions.DefaultStruct;

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

	public void removeWorkersFromSecondShift(List<Sift> solutionList) {
		List<Integer> tempWorkersIDs = new ArrayList<>();
		for (Range range : this.ranges) {
			if (range.isFixed()) {
				tempWorkersIDs.add(range.getFirstWorkerId());
			}
		}
		for (Sift sift : solutionList) {
			if (sift.day == this.day && sift.ranges.size() + 1 == this.ranges.size()) {
				for (Range range : sift.ranges) {
					for (Integer id : tempWorkersIDs) {
						range.removeWorker(id);
					}
				}
			}
		}
	}

	public void print() {
		for (Range range : ranges) {
			range.print();
		}
		System.out.println();//\n
	}

	public void printNew() {
		for (Range range : ranges) {
			range.printNew();
		}
		System.out.println();//\n
	}
}