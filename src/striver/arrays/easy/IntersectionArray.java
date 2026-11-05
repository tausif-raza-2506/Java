package striver.arrays.easy;
import striver.ArrayUtils;
import java.util.*;

public class IntersectionArray {

    /** Brute force approach: We compare each element of arr1 with each element of arr2.
     * If a match is found, we add it to the list after checking whether it is already present or not.
     * Time Complexity -> O(NxM)
     */
    public static List<Integer> brute(int[] arr1, int[] arr2) {
        List<Integer> intersection = new ArrayList<>();

        for(int i : arr1) {
            for(int j : arr2) {
                if(i == j && (intersection.isEmpty() || intersection.getLast() != i)) intersection.add(i);
            }
        }

        return intersection;
    }

    /** Better approach: Convert one array to a hashset, this removes the duplicates.
     * Now, we use .contains method to see whether an element of arr1 exists in arr2 or not.
     * And lastly, we sort the array because the order is not preserves in a hashset.
     * Time Complexity -> O(N + M + R log R)
     */
    public static List<Integer> better(int[] arr1, int[] arr2) {
        List<Integer> intersection = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();

        for (int i : arr1) set1.add(i);

        for (int i : arr2) {
            if (set1.contains(i)) intersection.add(i);
        }

        Collections.sort(intersection);
        return intersection;
    }

    /** Optimal approach: Using two pointer. Assign a pointer to the start of each array
     * and compare elements of both pointers. While comparing, the smaller element will always be smaller
     * than all the elements pointing and after in the second array. We only add elements which matches.
     * Time Complexity -> O(N+M)
     */
    public static List<Integer> optimal(int[] arr1, int[] arr2) {
        List<Integer> intersection = new ArrayList<>();
        int left = 0, right = 0, n = arr1.length, m = arr2.length;

        while (left < n && right < m) {
            if (arr1[left] < arr2[right]) left++;
            else if (arr1[left] > arr2[right]) right++;
            else {
                if (intersection.isEmpty() || intersection.getLast() != arr1[left]) {
                    intersection.add(arr1[left++]);
                    right++;
                }
            }
        }
        return intersection;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr1 = ArrayUtils.readArray(in);
        int[] arr2 = ArrayUtils.readArray(in);
        List<Integer> intersection = brute(arr1, arr2);
        System.out.println(intersection);
    }
}
