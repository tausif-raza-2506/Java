package algorithms.sorting;
import algorithms.ArrayUtils;
import java.util.*;

public class QuickSort {

    public static void sort(int[] arr) {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = ArrayUtils.readArray(in);
        System.out.println("Before sort: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("After Sort: " + Arrays.toString(arr));
    }
}
