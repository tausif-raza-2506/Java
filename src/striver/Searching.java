package striver;
import java.util.Scanner;

public class Searching {

    /** In Linear search, we compare each element of array from start to end until the target element is found.
     * Time Complexity -> O(N)
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    /** In Binary search, we compare the target element by comparing it with the middle element of the array
     *  discarding the half where the target cannot exist, and repeating the split until the element is found.
     *  Note: Binary search only works in sorted array.
     *  Time Complexity -> O(log N)
     */
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = ArrayUtils.readArray(in), target = ArrayUtils.readTarget(in), result = linearSearch(arr, target);
        System.out.println(result != -1 ? "Element found at index " + result : "Element not found");
    }
}
