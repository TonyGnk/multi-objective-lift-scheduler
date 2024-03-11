import helper_functions.Time;

import java.util.ArrayList;
import java.util.List;

import static manager_blocks.RangesNumberKt.getListTimeFrom;

public class Week {
    public final List<Sift> solutionList = new ArrayList<>();

    public Week(Time startFrom, int startDay, int days) {
        List<Time> times = getListTimeFrom(startFrom);

        for (int i = startDay; i < days; i++) {
            for (Time time : times) {
                solutionList.add(new Sift(i, time));
            }
            times = getListTimeFrom(Time.MORNING);
        }
    }

    public Week() {
        //Default constructor | Day 0 is sunday
        this(Time.MORNING, 0, 8);
    }

    public Week(int days) {
        this(Time.MORNING, 1, days);
    }

    public boolean CheckForUnsolvableWeek() {
        for (Sift sift : solutionList) {
            if (sift.hasEmptyRange()) return true;
        }
        return false;

    }


    public void print() {
        AskKotlinForHelpKt.weekPrinter(solutionList);
    }
}