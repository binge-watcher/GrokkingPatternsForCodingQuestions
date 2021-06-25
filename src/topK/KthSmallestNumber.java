package topK;

import java.util.PriorityQueue;

public class KthSmallestNumber {

    public static int findKthSmallestNumber(int[] nums, int k) {
         PriorityQueue<Integer> maxheap = new PriorityQueue<>((n1,n2)-> n2-n1);

        for(int i=0;i<nums.length;i++){
            add(maxheap,nums[i],k);
        }
        return maxheap.poll();
    }

    private static void add(PriorityQueue<Integer> maxheap,int num, int k){
        if(maxheap.size()<k)
            maxheap.add(num);
        else{
            if(maxheap.peek()>num){
                maxheap.poll();
                maxheap.add(num);
            }
        }
    }

    public static void main(String[] args) {
        int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
