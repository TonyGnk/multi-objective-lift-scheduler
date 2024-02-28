import java.util.Arrays;
import java.util.List;

public class Search {
	private List<WorkTime> solutionList;

	public Search() {
		this.solutionList = Arrays.asList(
				new WorkTime(1),
				new WorkTime(3),
				new WorkTime(2),
				new WorkTime(1)
		);
	}

	public void printSolution() {
		for (WorkTime workTime : solutionList) {
			for (WorkSet workSet : workTime.workList) {
				workSet.printVariable();
			}
		}
	}
}