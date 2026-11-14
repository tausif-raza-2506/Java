package striver.arrays.easy;
import java.util.*;
import striver.*;

public class HighestFreqElement {

    /** Brute force approach: Find the frequency of each element in a nested for loop and compare it with max.
     *  Time Complexity -> O(N^2)
     */
    public static int brute(int[] arr) {
        int maxFreq = 0, answer = arr[0];

        for (int i : arr) {
            int currentFreq = 0;
            for (int j : arr) {
                if (i == j) currentFreq++;
            }

            if (currentFreq > maxFreq || (currentFreq == maxFreq && i < answer)) {
                maxFreq = currentFreq;
                answer = arr[i];
            }
        }
        return answer;
    }

    /** Better approach: Sort the array, then the repeating will form a group.
     *  So, the group with maximum size will be the highest frequency element.
     *  Time Complexity ->  O(N log N)
     */
    public static int better(int[] arr) {
        Sorting.mergeSort(arr);

        int currCount = 1, maxCount = 1, answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) currCount++;
            else currCount = 1;

            if (currCount > maxCount) {
                maxCount = currCount;
                answer = arr[i];
            }
        }
        return answer;
    }

    /** Optimal approach: Use hash array is arr[i] are small, i.e. <= 10^5.
     * If arr[i] > 10^5 or more, then we use hashmap.
     * Time complexity -> O(N)
     */
    // Hash array method
    public static int optimal1(int[] arr) {
        // Find the maximum element in the array
        int max = -1;
        for (int i : arr) {
            if (i > max) max = i;
        }

        // Create hash array of size max + 1 and do hashing find the maximum frequency simultaneously
        int[] hash = new int[max + 1];
        int index = -1, maxFreq = 0;
        for (int i : arr) {
            hash[i]++;
            if (hash[i] > maxFreq || (hash[i] == maxFreq && i < index)) {
                maxFreq = hash[i];
                index = i;
            }
        }
        return index;
    }

    // Hash Map method
    public static int optimal2(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int index = -1, maxFreq = 0;
        for (int i : arr) {
            int count = freq.getOrDefault(i, 0) + 1;
            freq.put(i, count);
            if (count > maxFreq || (count == maxFreq && i < index)) {
                maxFreq = count;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = ArrayUtils.readArray(in);
        System.out.println(optimal2(arr));
    }
}
