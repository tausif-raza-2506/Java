package striver.arrays.easy;
import striver.*;
import java.util.*;

public class SecHighestFreqElement {

    // Using hash array is also optimal when arr[i] <= 10^5
    // Hashmap will be useful when arr[i] are either negative or too larger than 10^5
    public static int optimal(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if(i > max) max = i;
        }

        int[] hash = new int[max + 1];
        for (int i : arr) hash[i]++;

        int largest = 0, secLargest = 0, index = -1, firstIndex = -1;
        for (int i = 1; i < hash.length; i++) {
            if (hash[i] > largest) {
                secLargest = largest;
                index = firstIndex;
                
                largest = hash[i];
                firstIndex = i;
            } else if (hash[i] < largest && hash[i] > secLargest) {
                secLargest = hash[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = ArrayUtils.readArray(in);
        System.out.println("element with second highest frequency is: " + optimal(arr));
    }
}
