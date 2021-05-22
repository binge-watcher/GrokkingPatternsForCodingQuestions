package twoPointers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {

        List<List<Integer>> subarrays = new ArrayList<>();
        int product = 1;
        int low = 0, high = 0, counter = 0;
        while (high < arr.length) {
            product *= arr[high];
            counter++;
            while (product >= target && low < arr.length && counter > 0) {
                product /= arr[low];
                low++;
                counter--;
            }
            if (product < target) {
                // starting from end, moving towards start.
                List<Integer> list = new LinkedList<>();
                for (int i = high; i >= low; i--) {
                    list.add(0, arr[i]);
                    subarrays.add(new ArrayList<>(list));
                }
            }


            high++;


        }

        return subarrays;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[]{2, 5, 3, 10}, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[]{8, 2, 6, 5}, 50));
    }
}

