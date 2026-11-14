package striver.arrays.easy;
import striver.*;
import java.util.*;

public class SumHighLowFreq {

    public static int optimal(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int max = 0, min = Integer.MAX_VALUE;
        for (int i : arr) freq.put(i, freq.getOrDefault(i, 0) + 1);

        for (int count : freq.values()) {
            if (count > max) max = count;
            if(count < min) min = count;
        }
        return max + min;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = ArrayUtils.readArray(in);
        System.out.println("Sum of lowest and highest frequency is: " + optimal(arr));
    }
}
