package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {


    public static List<List<Integer>> searchTriplets(int[] arr) {
        // a + b + c =0 , then a + b = -c
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            //skip all elements which are equal to the previous element as we have already finished computing
            // arr[i]>0 , a+b+c=0 can't be achieved with 'c' being a positive integer, as the array is sorted, we cant have sum=0 with all positive integers
            if (i > 0 && arr[i] == arr[i - 1] || arr[i] > 0) // i>0 as for i=0, i-1 is -1
                continue;
            searchPair(arr, -arr[i], i + 1, triplets);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int target, int low, List<List<Integer>> triplets) {
        int high = arr.length - 1;

        while (low < high) {
            // if the sum is equla to target
            if (arr[low] + arr[high] == target) {
                triplets.add(Arrays.asList(-target, arr[low], arr[high]));
                low++;
                high--;
                // if duplicates exist, skip them
                while (low < high && arr[low] == arr[low - 1])
                    low++;
                while (low < high && arr[high] == arr[high + 1])
                    high--;
            } else if (arr[low] + arr[high] > target) {
                high--;
            } else {
                low++;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println("----");
        System.out.println(TripletSumToZero.searchTriplets(new int[]{0, 0, 0, 0}));
        System.out.println("---");
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-5, 2, -1, -2, 3}));
        System.out.println("---");
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-5, 4, 3, 2, 1}));
    }
}
