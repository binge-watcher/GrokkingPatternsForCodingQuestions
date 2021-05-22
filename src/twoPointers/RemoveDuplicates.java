package twoPointers;

public class RemoveDuplicates {


    public static int remove(int[] arr) {
        //keeps track of all the unique numbers seen so far.
        // nextUnique is where is put the next unique number
        // nextUnique-1 will be the latest and greatest unique number seen so far
        // we start with 1 , as the element at 0 is unique so far.
        int nextUnique = 1;

        for (int next = 1; next < arr.length; next++) {
            // compare each element with last seen unique number, which will be at index nextUnique-1
            // since the array is sorted we are assured all element ts the right of next are greater or equal
            if (arr[next] != arr[nextUnique - 1]) {
                int temp = arr[nextUnique];
                arr[nextUnique] = arr[next];
                arr[next] = temp;
                nextUnique++;
            }
        }

        return nextUnique;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 3, 3, 6, 9, 9};
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[]{2, 2, 2, 11};
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[]{3, 2, 3, 6, 3, 10, 9, 3};
        System.out.println(RemoveDuplicates.removeTarget(arr, 3));

        arr = new int[]{2, 11, 2, 2, 1};
        System.out.println(RemoveDuplicates.removeTarget(arr, 2));

    }

    public static int removeTarget(int[] arr, int target) {
        int nextUnique = 0;
        for (int next = 0; next < arr.length; next++) {
            if (arr[next] != target) {
                arr[nextUnique] = arr[next];
                nextUnique++;
            }
        }
        return nextUnique;
    }

}
