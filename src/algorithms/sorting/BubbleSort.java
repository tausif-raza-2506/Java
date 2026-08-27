package algorithms.sorting;
import algorithms.ArrayUtils;
import java.util.*;

public class BubbleSort {

    public static void sort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            // If no elements were swapped in the inner loop, the array is already sorted
            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int arr[] = ArrayUtils.readArray(in);
        System.out.println("Before Sort: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("After sort: " + Arrays.toString(arr));
    }
}