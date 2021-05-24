package xor;



// to flip something only traverse halfway
// find the other half by len-i
public class FlipandInvert {
    public static int[][] flipAndInvertImage(int[][] arr) {

        int len = arr[0].length;
        for(int[] row: arr){

            for(int i=0; i<(len+1)/2; i++ ){
                int temp = row[i]^1;
                row[i] = row[len-1-i]^1;
                row[len-1-i]=temp;
            }
        }

        return arr;
    }

    public static void print(int[][] arr) {
        for(int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
        print(flipAndInvertImage(arr));

        int[][]arr2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        print(flipAndInvertImage(arr2));
    }
}
