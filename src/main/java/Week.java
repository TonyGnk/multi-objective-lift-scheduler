import java.util.ArrayList;
import java.util.List;

public class Week {
    public final List<Sift> solutionList = new ArrayList<>();

    public Week(Integer days) {

        for (int i = 0; i < days; i++) {
            this.solutionList.add(new Sift(i, 3));
            this.solutionList.add(new Sift(i, 2));
            this.solutionList.add(new Sift(i, 1));
        }
    }

    public Week() {

        for (int i = 0; i < 5; i++) {
            this.solutionList.add(new Sift(i, 3));
            this.solutionList.add(new Sift(i, 2));
            this.solutionList.add(new Sift(i, 1));
        }
        for (int i = 0; i < 2; i++) {
            this.solutionList.add(new Sift(i, 2));
            this.solutionList.add(new Sift(i, 2));
            this.solutionList.add(new Sift(i, 1));
        }
    }

    public boolean CheckForUnsolvableWeek() {
        for (Sift sift : solutionList) {
            if (sift.hasEmptyRange()) return true;
        }
        return false;

    }


    public void print() {
        WeekPrinterKt.weekPrinter(solutionList);
    }
}