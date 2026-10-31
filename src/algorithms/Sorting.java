package algorithms;
import java.util.*;

public class Sorting {

    /** In Bubble Sort, we compare adjacent elements and swap if they are not in sorted order.
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
            if (!swapped) break;
        }
        return arr;
    }

    public static int[] recBubbleSort(int[] arr, int size) {
        if (size <= 1) return arr;
        for (int i = 0; i < size - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        recBubbleSort(arr, size - 1);
        return arr;
    }

    /** In selection sort, we first find the minimum element from the whole array
     *  and then swap it with the first element. The target is to move the smallest element to the start.
     *  Time Complexity -> O(N^2)
     */
    public static int[] selectionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    /** In Insertion Sort, we traverse the array by increasing the size by one each time
     * and place the element in the correct position for that particular sub-array
     * by comparing with adjacent element and swapping until it reaches its correct position.
     * Time Complexity -> O(N^2)
     */
    public static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
            }
        }
        return arr;
    }

    public static int[] recInsertionSort(int[] arr, int i) {
        if (i >= arr.length) return arr;
        for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
            int temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
        }
        return recInsertionSort(arr, i + 1);
    }

    /** In Quick Sort, we assign an arbitrary pivot and place it in its correct position of sorted order.
     * Then we recursively sort the right anf left sub arrays.
     * Time Complexity -> O(N log N)
     */

    // To find the partition index
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low], i = low, j = high;

        while (i < j) {

            // Find the first element larger than the pivot
            while (arr[i] <= pivot && i < high) i++;

            // Find the first element smaller than the pivot
            while (arr[j] > pivot && j > low) j++;

            // Swap these elements
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // Swap pivot with element at index j
        int temp = arr[j];
        arr[j] = low;
        low = temp;

        // Return partition index
        return j;
    }

    public static int[] quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pIndex = partition(arr, low, high);
            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
        return arr;
    }

    /** In Merge Sort, we continuously divide the array into two until we get isolated elements.
     * After that, we merge them back in sorted order to get the final sorted array.
     * Time Complexity -> O(N log N)
     */
    public static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();

        // Pointers for two subarrays for merging
        int left = low, right = mid + 1;

        // This loop adds elements to the arraylist until elements of any ony sub array is exhausted
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) temp.add(arr[left++]);
            else temp.add(arr[right++]);
        }

        // Adds rest of the elements from subarray in which elements are left
        while (left <= mid) temp.add(arr[left++]);
        while (right <= high) temp.add(arr[right++]);

        // Copy contents of arraylist back to the original array
        for (int i = 0; i < temp.size(); i++) arr[low + i] = temp.get(i);
    }

    public static int[] mergeSort(int[] arr, int low, int high) {
        if(low >= high) return arr;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = ArrayUtils.readArray(in);
        int[] test = {13, 46, 24, 52, 33, 9, 89, 73, 99, 65};
        System.out.println("Before Sort: " + Arrays.toString(arr) + "\nAfter sort: " + Arrays.toString(bubbleSort(arr)));
    }
}