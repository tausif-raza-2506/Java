package algorithms.sorting;
import algorithms.ArrayUtils;
import java.util.*;

public class SelectionSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int arr[] = ArrayUtils.readArray(in);
        System.out.println("Before sort: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("After sort: " + Arrays.toString(arr));
    }
}
