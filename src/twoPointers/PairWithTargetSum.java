package twoPointers;


import java.util.HashMap;

public class PairWithTargetSum {
    // input array is sorted, so we take advatnatge of that and place pointers at 0th and last index,
    // compare with this sum and move low++ if sum<target or move high-- if sum> target
    public static int[] searchWithPointers(int[] arr, int targetSum) {
        int low = 0;
        int high = arr.length - 1;
        int sum = 0;
        while (low < high) {
            sum = arr[low] + arr[high];
            if (sum < targetSum) {
                low++;
            } else if (sum > targetSum) {
                high--;
            } else {
                return new int[]{low, high};
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] searchWithHashMap(int[] arr, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(targetSum - arr[i])) {
                return new int[]{map.get(targetSum - arr[i]), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.searchWithHashMap(new int[]{1, 2, 3, 4, 6}, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.searchWithPointers(new int[]{2, 5, 9, 11}, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
