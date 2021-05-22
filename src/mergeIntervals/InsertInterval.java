package mergeIntervals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InsertInterval {

    // Given a list of non-overlapping intervals sorted by their start time
    // insert a given interval at the correct position and merge all necessary intervals to produce a list that has only mutually exclusive intervals.

    // skip intervals whose end time is less than the newintervals start time
    // to merge or not to merge
    // if start time of the next interval is less than start time


    static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        int start = newInterval.start;
        int end = newInterval.end;

        Iterator<Interval> itr = intervals.iterator();

        // skip intervals that come before newInterval
        // end < start of newIterval
        Interval currentInterval = itr.next();

        while (currentInterval.end < start) {
            result.add(currentInterval);
            currentInterval = itr.next();
        }


        while (itr.hasNext() && currentInterval.start <= end) {
            start = Math.min(start, currentInterval.start);
            end = Math.max(end, currentInterval.end);
            currentInterval = itr.next();
        }

        result.add(new Interval(start, end));
        result.add(currentInterval);

        while (itr.hasNext()) {
            currentInterval = itr.next();
            result.add(currentInterval);
        }


        return result;

    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        input.add(new Interval(13, 15));
        input.add(new Interval(16, 18));

        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

      /*  input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();*/
    }
}

//waliczek nell ---
// reema chugani backend
//yalabik ismet
//holmlund mattias
//sam lecuyer - intenal tools for amazon studio
//cimpoias dane
//primevideo-events@amazon.com