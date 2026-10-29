package algorithms;
import java.util.*;

public class Sorting {

    /** In Bubble Sort, we compare adjacent elements. If they are not sorted, we perform a swap.
     * The target is to move the largest element to the end.
     * Time Complexity -> O(N^2). For optimization, we add a swapped boolean to check whether any
     * swapping has been done in the inner loop or not. If not, we terminate the outer loop.
     */
    public static int[] bubbleSort(int[] arr) {
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
        return arr;
    }

    /** In selection sort, we first find the minimum element and then swap it with the first element.
     *  The target is to move the smallest element to the start.
     *  Time Complexity -> O(N^2)
     */
    public static int[] selectionSort(int[] arr) {

        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] quickSort(int[] arr) {

        return arr;
    }

    public static int[] mergeSort(int[] arr) {

        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = ArrayUtils.readArray(in);
        System.out.println("Before Sort: " + Arrays.toString(arr) + "\nAfter sort: " + Arrays.toString(bubbleSort(arr)));
    }
}
