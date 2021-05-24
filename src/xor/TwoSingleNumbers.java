package xor;

// xor all elements in nums[]
// we get xor of the 2 nunmsn that dont repeat
//find one bit where they differ by doing & operation with 1
// why 1? n1 xor n2 where they differ will be 1 and doing & operation of that bit with 1 will give us 1
// perform & operation with all elements in nums[]
// divide the element into categories one which are set at that bit
// and second which are not set at that bit
// xor all nums in their own category
// by xor-ing we remove all the duplicates and get our unique number



public class TwoSingleNumbers {
    public static int[] findSingleNumbers(int[] nums) {

        // get the XOR of the all the numbers
        int n1xn2 = 0;
        for (int num : nums) {
            n1xn2 ^= num;
        }
        // get the rightmost bit that is '1'
        int rightmostSetBit = 1;
        while ((rightmostSetBit & n1xn2) == 0) {
            rightmostSetBit = rightmostSetBit << 1;
        }
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) // the bit is set
                num1 ^= num;
            else // the bit is not set
                num2 ^= num;
        }
        return new int[] { num1, num2 };
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };
        int[] result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);

        arr = new int[] { 2, 1, 3, 2 };
        result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);


    }
}
