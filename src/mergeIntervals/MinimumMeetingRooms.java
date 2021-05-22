package mergeIntervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

// find the minimum number of rooms required to hold all the meetings.
// rephrased - find the max number of meets happening at the same time

// to assign rooms
// sort the meets by start time
// pick first meet - room1
// second meet if overlap assign room2 if second.start > first.end then room1
// criteria for assigning new room is if start time of next meet is less than end time of all currently live meets

// data strucute to hold all live meets - min heap
// min heap priortized by end times

public class MinimumMeetingRooms {
    public static int findMinimumMeetingRooms(List<Meeting> meetings) {

        if (meetings == null || meetings.size() == 0)
            return 0;
        meetings.sort((m1, m2) -> Integer.compare(m1.start, m2.start));
        PriorityQueue<Meeting> minheap = new PriorityQueue<>(meetings.size(), (m1, m2) -> Integer.compare(m1.end, m2.end));
        int count = 0;
        for (Meeting meeting : meetings) {

            // remove meetings that have ended
            while (!minheap.isEmpty() && meeting.start >= minheap.peek().end) {
                minheap.poll();
            }
            minheap.offer(meeting);
            count = Math.max(count, minheap.size());
        }
        return count;
    }

    public static void main(String[] args) {
        List<Meeting> input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 5));
                add(new Meeting(7, 9));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    }

}
