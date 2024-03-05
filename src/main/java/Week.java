import helper_functions.DefaultStruct;

import java.util.ArrayList;
import java.util.List;

public class Week implements DefaultStruct {
    private final List<Sift> solutionList = new ArrayList<>();

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
        for (Sift sift : this.getSolutionList()) {
            if (sift.hasEmptyRange()) return true;
        }
        return false;

    }

    public List<Sift> getSolutionList() {
        return solutionList;
    }

    public void print() {
        for (int i = 0; i < solutionList.size(); i++) {
            //In every 3 I print 1
            if (i % 3 == 0) {
                System.out.println("Day " + (i / 3 + 1));
                System.out.println("Morning");
            }
            if ((i - 1) % 3 == 0) {

                System.out.println("Evening");
            }
            if ((i - 2) % 3 == 0) {

                System.out.println("Night");
            }
            solutionList.get(i).print();
        }
    }

    public void printNew() {
        WeekPrinterKt.weekPrinter(solutionList);
    }
}