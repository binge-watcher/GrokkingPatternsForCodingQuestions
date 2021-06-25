package cyclicSort;

public class FindDuplicate {
    public static int findNumber(int[] nums) {
        int i=0;
        while(i<nums.length){
            // is number at index the correct one?
          //  if(nums[i]!=i+1){
                // is the number at index equal to the number at its correct index
                if(nums[i]!=nums[nums[i]-1]){
                    swap(nums, i, nums[i]-1);
               // }else{
            //        return nums[i];
              //  }
            }
            else{
                i++;
            }
        }

        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1)
                return nums[j];
        }
        return -1;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b]= temp;

    }
    public static void main(String[] args) {
        System.out.println(FindDuplicate.findNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 2, 4, 1, 4, 4 }));
    }
}
