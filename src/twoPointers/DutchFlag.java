package twoPointers;

public class DutchFlag {

    public static void sort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
        for (int i = 0; i < high; ) {
            if (arr[i] == 0) {
                swap(arr, i, low);
                // increment 'i' and 'low'
                i++;
                low++;
            } else if (arr[i] == 1) {
                i++;
            } else { // the case for arr[i] == 2
                swap(arr, i, high);
                // decrement 'high' only, after the swap the number at index 'i' could be 0, 1 or 2
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int low) {
        int temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 0, 0};
        DutchFlag.sort(arr);
        System.out.println("----");
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[]{2, 2, 0, 1, 2, 0};
        DutchFlag.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }
}


//fails
//{ 2, 0, 2, 1, 0 };