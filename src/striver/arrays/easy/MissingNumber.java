package striver.arrays.easy;
import striver.*;
import java.util.*;

public class MissingNumber {
    
    /** Brute force approach: We run a loop from 0 to N and find each element in the given array.
     * If they are found, we break the array there itself and return the missing value.
     * Time Complexity -> O(N^2).
     */
    public static int brute(int[] arr) {
        int missing = 0, target;
        for (int i = 0; i <= arr.length; i++) {
            target = Searching.linearSearch(arr, i);
            if (target == -1) {
                missing = i;
                break;
            }
        }
        return missing;
    }

    /** Better approach: We first sort the given array.
     * Now we traverse the array and match the element with its index.
     * The first unmatched index will be the missing element.
     * Time Complexity -> O(N log N + N)
     */
    public static int better(int[] arr) {
        int missing = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != i) {
                missing = i;
                break;
            }
        }
        return missing;
    }

    /** Optimal approach 1 -> Hashing method
     *  We create a boolean type array of length arr + 1 to accommodate the missing value
     *  We traverse the original array and mark true for every element present in the original array.
     *  Now, in second traversal, we check which index is not flagged which gives us the missing element.
     *  Time Complexity -> O(N). This method requires two traversals.
     */
    public static int optimal1(int[] arr) {
        int missing = 0;
        boolean[] present = new boolean[arr.length + 1];
        for (int i : arr) present[i] = true;
        for (int i = 0; i < present.length; i++) {
            if (!present[i]) missing = i;
        }
        return missing;
    }

    /** Optimal approach 2 -> XOR method, we know a^a = 0 and a^1 = a
     * So we create a xor variable which does xor of all elements from 0 to N.
     * Another xor variable which does xor of all elements within the array.
     * To get our final answer, we do xor1 with xor2.
     * Time Complexity -> O(N)
     */
    public static int optimal2(int[] arr) {
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < arr.length; i++) {
            xor1 ^= i;
            xor2 ^= arr[i];
        }
        return (xor1 ^ arr.length) ^ xor2;
    }

    /** Optimal approach 3: Since we have all the elements from 0 to N, we find the sum using the formula n * (n + 1) / 2
     * Now, we traverse the array and find the actual sum of the elements present in the array.
     * The missing element is the difference of the expected sum and the actual sum.
     * Time Complexity -> O(N). Here we require only one array traversal.
     */
    public static int optimal3(int[] arr) {
        int expectedSum = 0, actualSum = 0, n = arr.length;

        expectedSum = n * (n + 1) / 2;
        for (int i : arr) actualSum += i;

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = ArrayUtils.readArray(in);

        System.out.println("Missing number is: " + optimal2(arr));
    }
}