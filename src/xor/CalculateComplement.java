package xor;

public class CalculateComplement {
    public static int bitwiseComplement(int n) {

        int bitcount=0;
        int num = n;
        while(num>0){
            bitcount++;
            num = num >> 1;
        }

        int allBitsSet = (int) (Math.pow(2, bitcount) -1);
        return n ^ allBitsSet;
    }

    public static void main( String args[] ) {
        //System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(Integer.MAX_VALUE));
        //System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(10));
        System.out.println(4^7);

    }
}
