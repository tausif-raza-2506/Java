package striver.arrays.easy;
import striver.ArrayUtils;
import java.util.*;

public class RemoveDuplicates {

    /** Better approach: We traverse through the whole array and
     * add only those elements to the arraylist which are unique.
     * Time Complexity -> O(N), Space Complexity -> O(N)
     */
    public static List<Integer> better(int[] arr) {
        List<Integer> unique = new ArrayList<>();
        for (int i : arr) {
            if(unique.isEmpty() || unique.getLast() != i) unique.add(i);
        }
        return unique;
    }

    /** Optimal approach: We use a pointer and update the original array preserving the use of an arraylist.
     * Time Complexity -> O(N), Space Complexity -> O(1)
     */
    public static int[] optimal(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }

        for (int j = i + 1; j < arr.length; j++) arr[j] = 0;

        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = ArrayUtils.readArray(in);
        int[] union = optimal(arr);
        System.out.println(Arrays.toString(union));
    }
}
