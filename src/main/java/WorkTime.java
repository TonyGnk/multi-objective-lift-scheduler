import java.util.ArrayList;
import java.util.List;

public class WorkTime {
	private int shifts;
	List<WorkSet> workList;

	public WorkTime(int shifts) {
		this.shifts = shifts;
		this.workList = new ArrayList<>();
		for (int i = 0; i < shifts; i++) {
			this.workList.add(new WorkSet());
		}
	}

	public void printShifts() {
		for (WorkSet workSet : workList) {
			workSet.printVariable();
		}
		System.out.println();
	}

	public void setWorkerInASet(int workerId) {
		for (WorkSet workSet : workList) {
			if (!workSet.hasOnlyOneValue()) {
				workSet.removeAllExcept(workerId);
				break;
			}
		}
	}

	public void optimizeSet() {
		for (int i = 0; i < shifts; i++) {
			if (workList.get(i).hasOnlyOneValue()) {
				int singleMemberId = workList.get(i).singleMemberId();
				for (WorkSet workSet : workList) {
					if (workSet != workList.get(i) && workSet.workerExists(singleMemberId)) {
						workSet.removeWorker(singleMemberId);
					}
				}
			}
		}
	}
}