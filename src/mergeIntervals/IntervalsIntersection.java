package mergeIntervals;

import java.util.ArrayList;
import java.util.List;


//find intersecting bits of 2 lists SORTED by START TIME
//iterate over both the lists, i1, i2
// check if they overlap - does start time of i1 < end time of i2 or vice versa
// if yes then get the merges interval - min of start and max of end
// increment the iterator for interval with smaller end time


public class IntervalsIntersection {
    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<Interval>();

        int i1 = 0, i2 = 0;
        int start = 0, end = 0;
        while (i1 < arr1.length && i2 < arr2.length) {

            //check for overlap
            if (arr1[i1].start <= arr2[i2].end && arr1[i1].start >= arr2[i2].start ||
                    arr2[i2].start <= arr1[i1].end && arr2[i2].start >= arr1[i1].start) {
                start = Math.min(arr1[i1].start, arr2[i2].start);
                end = Math.max(arr1[i1].end, arr2[i2].end);

                intervalsIntersection.add(new Interval(start, end));
            }
            // go next
            if (arr1[i1].end < arr2[i2].end)
                i1++;
            else
                i2++;


        }
        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[]{new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
        Interval[] input2 = new Interval[]{new Interval(2, 3), new Interval(5, 7)};
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[]{new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)};
        input2 = new Interval[]{new Interval(5, 10)};
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}