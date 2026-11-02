package striver.arrays.easy;
import striver.ArrayUtils;
import java.util.*;

public class Largest {

    // Time Complexity -> O(N)
    public static int max(int[] arr) {
        int largest = arr[0];
        for (int j : arr) {
            if (j > largest) largest = j;
        }
        return largest;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = ArrayUtils.readArray(in);
        System.out.println("Largest element: " + max(arr));
    }
}
