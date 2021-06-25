package topK;

import java.util.*;

public class TopKFrequentNumbers {
    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        List<Integer> topNumbers =new ArrayList(k);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
           map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> minheap = new PriorityQueue<>( (e1,e2)-> e1.getValue()-e2.getValue());
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            minheap.add(pair);
            if(minheap.size()>k)
                minheap.poll();
        }

        while(minheap.size()>0)
            topNumbers.add(minheap.poll().getKey());
        return  topNumbers;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
