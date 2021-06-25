package cyclicSort;

public class MissingNumber {
    public static int findMissingNumber(int[] nums) {
        int i=0;
        // we only work with numbers less than nums.length-1, since the last number os going to exceed the index
        // check if the nums[i] is equal to i
        while(i<nums.length){
            if(nums[i]<=nums.length-1 && nums[i]!=nums[nums[i]]){
                swap(nums, i, nums[i]);
            }else{
                i++;
            }
        }
        for(int j=0;j<nums.length;j++){
            if(j!=nums[j]){
                return j;
            }
        }
            return -1;
    }
    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b]= temp;

    }
    public static void main(String[] args) {
        System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
