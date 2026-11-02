package striver.arrays.easy;
import striver.Sorting;
import striver.ArrayUtils;

import java.util.Scanner;

public class SecondLargest {

    /** First sort the array then find second largest from end.
     * Time Complexity -> O(N log N + N) */
    public static int brute(int[] arr) {
        if(arr.length < 2) return -1;
        Sorting.mergeSort(arr);
        int n = arr.length;
        int largest = arr[n - 1], secLargest = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] != largest) secLargest = arr[i];
        }

        return secLargest;
    }

    /** Find the largest element in the first pass -> O(N).
     * Then find the second largest in the second pass.
     * Time Complexity -> O(2N)
     */
    public static int better(int[] arr) {
        if(arr.length < 2) return -1;
        int largest = Largest.max(arr);
        int secLargest = -1;
        for (int j : arr) {
            if (j > secLargest && j != largest) secLargest = j;
        }
        return secLargest;
    }

    /** We set the largest as first element of array and secLargest as -1.
     * When we find a number greater than largest, then we assign secLargest as largest
     * and the new number as largest.
     * Time Complexity -> O(N)
     */
    public static int optimal(int[] arr) {
        if(arr.length < 2) return -1;
        int largest = arr[0], secLargest = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secLargest = largest;
                largest = arr[i];
            }
        }
        return secLargest;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = ArrayUtils.readArray(in);
        System.out.println("Largest: " + Largest.max(arr) + "\nSecond largest: " + optimal(arr));
    }
}
