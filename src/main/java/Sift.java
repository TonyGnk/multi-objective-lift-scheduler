import helper_functions.DefaultStruct;

import java.util.ArrayList;
import java.util.List;

public class Sift implements DefaultStruct {
	private List<Range> ranges;

	public Sift(int numberOfRanges) {
		this.ranges = new ArrayList<>();
		for (int i = 0; i < numberOfRanges; i++) {
			this.ranges.add(new Range());
		}
	}

	public void removeAllWorkersInAnyNotFixedRangeExcept(int workerId) {
		for (Range range : ranges) {
			if (!range.isFixed()) {
				range.removeAllWorkersExcept(workerId);
				break;
			}
		}
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

	public void print() {
		for (Range range : ranges) {
			range.print();
		}
		System.out.println();
	}
}