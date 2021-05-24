package xor;

public class SingleNumber {


    // xor property - 0 xor 0 and 1 xor 1 = 0  like with like is 0
    //  0 xor 1 and 1 xor 0 is 1, unlike is 1
    public static int findSingleNumber(int[] arr) {
        int xor= arr[0];
        for(int i=1;i<arr.length;i++){
            xor = xor ^ arr[i];
        }
        return xor;
    }

    public static void main( String args[] ) {
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
    }
}
