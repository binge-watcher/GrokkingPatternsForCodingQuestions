package mergeIntervals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Job {
    int start;
    int end;
    int load;

    Job(int start, int end, int load) {
        this.start = start;
        this.end = end;
        this.load = load;
    }
}

public class MaximumCPULoad {

    public static int findMaxCPULoad(List<Job> jobs) {
        int sumLoad = 0, maxLoad = 0;
        jobs.sort((job1, job2) -> Integer.compare(job1.start, job2.start));
        PriorityQueue<Job> minheap = new PriorityQueue<Job>(jobs.size(), (job1, job2) -> Integer.compare(job1.end, job2.end));
        for (Job job : jobs) {

            //remove all jobs ended before current job
            while (!minheap.isEmpty() && job.start >= minheap.peek().end) {
                Job removedjob = minheap.poll();
                sumLoad -= removedjob.load;
            }

            minheap.offer(job);
            sumLoad += job.load;
            maxLoad = Math.max(maxLoad, sumLoad);
        }


        return maxLoad;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>() {
            {
                add(new Job(1, 4, 3));
                add(new Job(2, 5, 4));
                add(new Job(7, 9, 6));
            }
        };

        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));


    }

}
