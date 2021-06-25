package topK;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestNumbers {
    private static PriorityQueue<Integer> minheap = new PriorityQueue<>((n1,n2)-> n1-n2);

    public static List<Integer> findKLargestNumbers(int[] nums, int k) {

        for(int i=0;i<nums.length;i++){
            add(nums[i],k);
        }
        return new ArrayList<>(minheap);
    }

    private static void add(int num, int k) {
        if(minheap.size()<k)
            minheap.add(num);
        else{
            if(minheap.peek()<num){
                minheap.poll();
                minheap.add(num);
            }
        }
    }

    public static void main(String[] args) {
        //List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        //System.out.println("Here are the top K numbers: " + result);

        List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}
