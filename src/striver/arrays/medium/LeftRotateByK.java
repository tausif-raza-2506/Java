package striver.arrays.medium;
import striver.ArrayUtils;
import java.util.*;

public class LeftRotateByK {

    /** Brute force approach: Rotating by k places is the same as rotating by one place k times.
     * Time Complexity -> O(N x k)
     */
    public static int[] brute(int[] arr, int k) {
        int temp = arr[0], n = arr.length;
        k %= n;
        if (n==1 || k==0) return arr;
        for (int rotate = 1; rotate <= k; rotate++) {
            for (int i = 0; i < n - 1; i++) arr[i] = arr[i + 1];
            arr[n - 1] = temp;
        }
        return arr;
    }

    /** Better approach: Copy the k elements from start in a temp array.
     * Shift the elements k places forward.
     * Copy the temp array elements back to the original array.
     * Time Complexity -> O(N), Space Complexity -> O(k)
     */
    public static int[] better(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        if (n==1 || k==0) return arr;
        int[] temp = new int[k];

        System.arraycopy(arr, 0, temp, 0, k);
        for (int i = 0; i < n - k; i++) arr[i] = arr[i + k];
        System.arraycopy(temp, 0, arr, n - k, k);
        return arr;
    }

    /** Optimal approach: Left rotate can also be visualized as exchange of two contiguous parts of the array.
     * We reverse the individual sub arrays and then finally reverse the whole array
     * to get the desired rotated array.
     * Time Complexity -> O(N)
     */
    public static void reverseRange(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static int[] optimal(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        if (n == 1 || k == 0) return arr;
        reverseRange(arr, 0, k - 1);
        reverseRange(arr, k, n - 1);
        ArrayUtils.revArray(arr);
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = ArrayUtils.readArray(in);
        System.out.println("Enter number of places you want to shift");
        System.out.println(Arrays.toString(optimal(arr, in.nextInt())));
    }
}
