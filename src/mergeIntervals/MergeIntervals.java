package mergeIntervals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MergeIntervals {

    // merge all overlapping intervals
    // return mutually exclusive intervals

    // sort on basis on start time
    // overlap? if start time of next interval < end time of current interval

    // time - sorting + goingover each interval in the list o(nlogn) + o(n) = o(nlogn)
    //space  -

    static List<Interval> merge(List<Interval> intervals) {
        intervals.sort((Interval interval1, Interval interval2) -> Integer.compare(interval1.start, interval2.start));

        Iterator<Interval> itr = intervals.iterator();

        List<Interval> result = new ArrayList<>();
        Interval first = itr.next();
        int start = first.start;
        int end = first.end;

        while (itr.hasNext()) {
            Interval currentInterval = itr.next();
            //overlap
            if (end > currentInterval.start) {
                // change the end value to take the max of the two
                // TIP: changing max to min gives us mutually exclusive intervals , ie, it gets rid if the overlapping intervals
                end = Math.max(end, currentInterval.end);
                // Not adding to final list here cause the next interval could also be overlapped
            } else {
                //add s,e to final list here as we know current interval end < start
                result.add(new Interval(start, end));
                // last pair will not be added in this loop as hasNext will return false
                start = currentInterval.start;
                end = currentInterval.end;
            }
        }

        result.add(new Interval(start, end));
        return result;

    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

    }
}
