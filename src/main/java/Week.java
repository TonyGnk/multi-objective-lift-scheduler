import helper_functions.Day;
import helper_functions.Time;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static manager_blocks.RangesNumberKt.findNextTime;
import static manager_blocks.RangesNumberKt.getListTimeFrom;

public class Week {
    public final List<Shift> solutionList = new ArrayList<>();
    public final int days;

    public Week(Time startFrom, Time endTime, int startDay, int days) {
        List<Time> times = getListTimeFrom(startFrom);
        endTime = findNextTime(endTime);

        for (int i = startDay; i < days; i++) {
            for (Time time : times) {
                if (i == days - 1 && time == endTime) continue;

                solutionList.add(new Shift(i, time));
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
        for (Shift sift : solutionList) {
            if (sift.hasEmptyRange()) return true;
        }
        return false;
    }

    public <T> List<Shift> collectShiftsWith(T attribute) {
        if (attribute instanceof Day) {
            return solutionList.stream().filter(sift -> sift.day == attribute)
                    .collect(Collectors.toList());
        } else if (attribute instanceof Time) {
            return solutionList.stream().filter(sift -> sift.time == attribute)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

//    public boolean checkIfExistSeniorWorkerInMorningTime() {
//        return collectShiftsWithTime(Time.MORNING).stream()
//                .anyMatch(sift -> sift.exists());
//    }


    public void print() {
        AskKotlinForHelpKt.weekPrinter(this);
    }
}