package algorithms.sorting;
import algorithms.ArrayUtils;
import java.util.*;

public class InsertionSort {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = ArrayUtils.readArray(in);
        System.out.println("Before sort: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("After Sort: " + Arrays.toString(arr));
    }
}
