package algorithms.searching;
import algorithms.ArrayUtils;
import java.util.*;

public class BinarySearch {

    public static int search(int[] arr, int target) {
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

        int arr[] = ArrayUtils.readArray(in), target = ArrayUtils.readTarget(in);
        Arrays.sort(arr);
        int result = search(arr, target);

        System.out.println(result != -1 ? "Element found at index " + result : "Element not found");
    }
}