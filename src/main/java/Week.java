import helper_functions.Time;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static manager_blocks.RangesNumberKt.findNextTime;
import static manager_blocks.RangesNumberKt.getListTimeFrom;

public class Week {
    public final List<Sift> solutionList = new ArrayList<>();
    public final int days;

    public Week(Time startFrom, Time endTime, int startDay, int days) {
        List<Time> times = getListTimeFrom(startFrom);
        endTime = findNextTime(endTime);

        for (int i = startDay; i < days; i++) {
            for (Time time : times) {
                if (i == days - 1 && time == endTime) continue;

                solutionList.add(new Sift(i, time));
            }
            times = getListTimeFrom(Time.MORNING);
        }
        this.days = days;
    }

    public Week() {
        //Default constructor | Day 0 is sunday
        this(Time.NIGHT, Time.AFTERNOON, 0, 8);
    }

    public Week(int days) {
        this(Time.MORNING, Time.NIGHT, 1, days);
    }


    public boolean CheckForUnsolvableWeek() {
        for (Sift sift : solutionList) {
            if (sift.hasEmptyRange()) return true;
        }
        return false;
    }

    public List<Sift> collectSiftsWithTime(Time time) {
        return solutionList.stream()
                .filter(sift -> sift.time == time)
                .collect(Collectors.toList());
    }

//    public boolean checkIfExistSeniorWorkerInMorningTime() {
//        return collectSiftsWithTime(Time.MORNING).stream()
//                .anyMatch(sift -> sift.exists());
//    }


    public void print() {
        AskKotlinForHelpKt.weekPrinter(this);
    }
}