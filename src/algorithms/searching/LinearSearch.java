package algorithms.searching;
import algorithms.ArrayUtils;
import java.util.*;

public class LinearSearch {

    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = ArrayUtils.readArray(in),
                target = ArrayUtils.readTarget(in),
                result = search(arr, target);

        System.out.println(result != -1 ? "Element found at index " + result : "Element not found");
    }
}