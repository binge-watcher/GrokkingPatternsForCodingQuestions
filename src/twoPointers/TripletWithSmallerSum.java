package twoPointers;

import java.util.Arrays;

public class TripletWithSmallerSum {

    public static int searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int newTarget = target - arr[i];
            count += search(arr, newTarget, i + 1);
        }
        return count;
    }

    private static int search(int[] arr, int newTarget, int low) {
        int high = arr.length - 1;
        int count = 0;
        while (low < high) {
            if (arr[low] + arr[high] < newTarget) {
                count += high - low;
                low++;
            } else {
                high--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[]{-1, 0, 2, 3}, 3));     //2
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));  //4
    }
}
