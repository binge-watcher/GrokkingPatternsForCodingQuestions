package cyclicSort;

public class CyclicSort {

    //check if number at a[i] == i+1
    //if not then swap a[i] with the number at its correct position which is - a [ a[i] -1 ]

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 1, 5, 6, 4, 3, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void sort(int[] nums) {
        int i=0;
        while(i<nums.length){
        //EG - nums[1] =5, is 5 at its correct place?
            // ie, at index 4?
            //check value at nums[ num[i] -1] = nums[5-1]
            if(nums[i]!= nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }else{
                i++;
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b]= temp;
    }

}
