package twoPointers;

public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int cur = squares.length - 1;

        int low = 0, high = arr.length - 1;

        while (low < high) {
            int lowSquare = arr[low] * arr[low];
            int highSquare = arr[high] * arr[high];
            if (lowSquare > highSquare) {
                squares[cur--] = lowSquare;
                low++;
            } else {
                squares[cur--] = highSquare;
                high--;
            }
        }
        return squares;
    }


    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[]{-2, -1, 0, 2, 3});
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[]{-3, -1, 0, 1, 2});
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}
