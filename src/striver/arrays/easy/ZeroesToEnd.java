package striver.arrays.easy;
import striver.ArrayUtils;
import java.util.*;

public class ZeroesToEnd {

    /** Brute force method: Create a new array and copy the non xero elements to it
     * while the rest of the elements are already zero.
     * Time Complexity -> O(N), Space Complexity -> O(N)
     */
    public static int[] brute(int[] arr) {
        int[] temp = new int[arr.length];
        int index = 0;

        for (int i : arr) {
            if (i != 0) temp[index++] = i;
        }

        System.arraycopy(temp, 0, arr, 0, arr.length);
        return arr;
    }

    /** Better approach: We overwrite the elements of original array with the non-zero elements
     * and then fill the rest of the array with zeroes.
     * Time Complexity -> O(N), Space Complexity -> O(1)
     */
    public static int[] better(int[] arr) {
        int index = 0;
        for (int i : arr) {
            if(i != 0) arr[index++] = i;
        }
        for (int i = index; i < arr.length; i++) arr[i] = 0;
        return arr;
    }

    /** Optimal approach: Swap the first non-zero element with the element at the start and so on.
     * Time Complexity -> O(N), Space Complexity -> O(1)
     */
    public static int[] optimal(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index++] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = ArrayUtils.readArray(in);
        System.out.println(Arrays.toString(optimal(arr)));
    }
}
