package striver.arrays.easy;
import striver.ArrayUtils;
import java.util.*;

public class UniqueNumber {

    /** Brute force approach: Count the occurrences of each element.
     * The only element with one occurrence will be the unique element.
     * Time Complexity -> O(N^2)
     */
    public static int brute(int[] arr) {
        int count;
        for (int num : arr) {
            count = 0;
            for (int j : arr) {
                if (j == num) count++;
            }
            if (count == 1) return num;
        }
        return -1;
    }

    /** Better approach: Perform hashing of the array and find the element having only 1 frequency.
     * Time Complexity -> O(N) or to be specific O(3N)
     */
    public static int better(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i>max) max = i;
        }
        int[] hash = new int[max];
        for (int i : arr) hash[i]++;
        for (int i : hash) {
            if (i == 1) return i;
        }
        return -1;
    }

    /** Optimal approach: XOR method, we know a^a = 0 and a^1 = a.
     * We will xor all the elements in the array. The final result will be the unique number;
     * Time Complexity -> O(N)
     */
    public static int optimal(int[] arr) {
        int xor = 0;
        for (int i : arr) xor ^= i;
        return xor;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = ArrayUtils.readArray(in);
    }
}
