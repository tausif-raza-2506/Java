package algorithms;
import java.util.*;
public class ArrayUtils {

    // To take size of array and its elements fron user
    public static int[] readArray(Scanner in) {
        System.out.println("Enter array size");
        int size = in.nextInt(), arr[] = new int[size];

        System.out.println("Enter " + size + " elements");
        for (int i = 0; i < size; i++)
            arr[i] = in.nextInt();
        return arr;
    }

    // To take search element from the user
    public static int readTarget(Scanner in) {
        System.out.println("Enter search element");
        return in.nextInt();
    }

    // For printing the array elements
    public static void printArray(int arr[]) {
        for (int n : arr)
            System.out.print(n + " ");
        System.out.println();
    }
}