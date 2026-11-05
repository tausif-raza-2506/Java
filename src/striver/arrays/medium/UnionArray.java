package striver.arrays.medium;
import striver.ArrayUtils;
import java.util.*;

public class UnionArray {

    /** Brute force approach: Traverse one array at a time. Add elements to the arraylist.
     * To prevent duplicates, we run a linear search in the arraylist before adding the new element.
     * After elements from both arrays are added, we sort the array to get the final result.
     * Time Complexity -> O((N+M)^2)
     */
    public static List<Integer> brute(int[] arr1, int[] arr2) {
        List<Integer> union = new ArrayList<>();

        // Traverse array 1
        for (int value : arr1) {
            boolean isPresent = false;

            // To check whether the element already exists or not
            for(int j : union) {
                if (j == value) {
                    isPresent = true;
                    break;
                }
            }

            if (!isPresent) union.add(value);
            }

        // Traverse array 2
        for (int value : arr1) {
            boolean isPresent = false;

            // To check whether the element already exists or not
            for(int j : union) {
                if (j == value) {
                    isPresent = true;
                    break;
                }
            }

            if (!isPresent) union.add(value);
        }

        Collections.sort(union);
        return union;
    }

    /** Better approach: Use a TreeSet. It avoids duplicates and maintains the elements in the sorted order.
     * Time Complexity -> O((N+M) log (N+M))
     */
    public static Set<Integer> better(int[] arr1, int[] arr2) {
        Set<Integer> union = new TreeSet<>();
        for (int i : arr1) union.add(i);
        for (int i : arr2) union.add(i);
        return union;
    }

    /** Optimal approach: Using two pointer method. Assign a pointer to the start of each array
     * and compare elements of both pointers and add accordingly to the arraylist.
     * Then we add the rest of the elements if any one array gets exhausted.
     * Time Complexity -> O(N+M)
     */
    public static List<Integer> optimal(int[] arr1, int[] arr2) {
        List<Integer> union = new ArrayList<>();
        int n = arr1.length, m = arr2.length, left = 0, right = 0, currVal;

        while (left < n && right < m) {
            if (arr1[left] < arr2[right]) currVal = arr1[left++];
            else if (arr1[left] > arr2[right]) currVal = arr2[right++];
            else {
                currVal = arr1[left++];
                right++;
            }
            if (union.isEmpty() || union.getLast() != currVal) union.add(currVal);
        }

        while (left < n) {
            if (union.isEmpty() || union.getLast() != arr1[left]) union.add(arr1[left]);
            left++;
        }

        while (right < m) {
            if (union.isEmpty() || union.getLast() != arr2[right]) union.add(arr2[right]);
            right++;
        }

        return union;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr1 = ArrayUtils.readArray(in);
        int[] arr2 = ArrayUtils.readArray(in);
        List<Integer> union = optimal(arr1, arr2);
        System.out.println(union);
    }
}
