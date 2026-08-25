package algorithms.sorting;
import java.util.Scanner;

public class Bubble_Sort {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int i, j, size, a[], temp;

        System.out.println("Enter array size");
        size = in.nextInt();
        a = new int[size];

        System.out.println("Enter array elements");
        for (i = 0; i < size; i++)
            a[i] = in.nextInt();

        for (i = 0; i < size; i++) {
            for (j = 0; j < size - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}