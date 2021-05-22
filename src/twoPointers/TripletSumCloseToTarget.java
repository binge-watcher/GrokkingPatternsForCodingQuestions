package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumCloseToTarget {


    /*
    a+b+c = target ---- targetSum  <- smallest difference
    targetSum - target  == smallest difference
    if more than one then sum up the triplets and return smallest sum
    */

    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        List<List> result = new ArrayList<>();
        int smallestDifference = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {
            int low = i + 1, high = arr.length - 1;

            // target == targetSum
            // target > targetSum  decrement high
            //target < targetSum  increment low
            int counter = 1;
            while (low < high) {
                counter++;
                int target = arr[i] + arr[low] + arr[high];
                int currentDifference = targetSum - target;

                if (currentDifference == 0)
                    return target;
                // Math.abs(currentDifference) < Math.abs(smallestDifference)
                // means you are closer to the targetSum
                // Math.abs(currentDifference) == Math.abs(smallestDifference)
                // more than one solution
                // target < targetSum  - eg target = 0,2 and targetsum = 1   ,
                // both are at an equal diff of 1 from the targetSum
                // we take the combo - target=0 and targetsum=1 as 0<2.

                if (Math.abs(currentDifference) < Math.abs(smallestDifference) ||
                        Math.abs(currentDifference) == Math.abs(smallestDifference) && target < targetSum)
                    smallestDifference = currentDifference;

                if (currentDifference > smallestDifference)
                    high--;
                else
                    low++;
            }
        }
        return targetSum - smallestDifference;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[]{-2, 0, 1, 2}, 2));        //1
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[]{-3, -1, 1, 2}, 1));       //0
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[]{1, 0, 1, 1}, 100));       //3
    }
}