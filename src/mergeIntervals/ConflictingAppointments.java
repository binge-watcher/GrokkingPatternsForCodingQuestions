package mergeIntervals;

// Given array of intervals, find if one can attend all the meets
// true if no overlaps
// false if overlap present

// iterate over ll intervals , compare if start time of next interval lies before end time of current interval


import java.util.Arrays;

public class ConflictingAppointments {
    public static boolean canAttendAllAppointments(Interval[] intervals) {
        Arrays.sort(intervals, (Interval i1, Interval i2) -> Integer.compare(i1.start, i2.start));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)};
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = {new Interval(6, 7), new Interval(2, 4), new Interval(8, 12)};
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = {new Interval(4, 5), new Interval(2, 3), new Interval(3, 6)};
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }
}
