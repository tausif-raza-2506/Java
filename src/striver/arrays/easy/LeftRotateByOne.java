package striver.arrays.easy;
import striver.ArrayUtils;
import java.util.*;

public class LeftRotateByOne {

    /** Brute force approach: Create a temporary array and copy all elements from index 1 to last.
     * Manually copy the first element in arr to last index in temp.
     * Copy the temp arr back to original array.
     * Time Complexity -> O(N), Space Complexity -> O(N)
     */
    public static int[] brute(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        System.arraycopy(arr, 1, temp, 0, n - 1);
        temp[n - 1] = arr[0];
        System.arraycopy(temp, 0, arr, 0, n);
        return arr;
    }

    /** Optimal approach: Make a copy of the first element of the array.
     * Now shift each element from index 1 to last.
     * Overwrite the element at the last index with the first one.
     * Time Complexity -> O(N), Space Complexity -> O(1)
     */
    public static int[] optimal(int[] arr) {
        int temp = arr[0], n = arr.length;
        for (int i = 0; i < n - 1; i++) arr[i] = arr[i + 1];
        arr[n - 1] = temp;
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = ArrayUtils.readArray(in);
        System.out.println(Arrays.toString(optimal(arr)));
    }
}
