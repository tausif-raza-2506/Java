package striver.arrays.easy;
import striver.ArrayUtils;
import java.util.*;

public class MaxConsecutiveOnes {

    public static int maxCount(int[] arr) {
        int max = 0, temp = 0;
        for (int i : arr) {
            if (i == 1) {
                temp++;
                max = Math.max(temp, max);
            } else temp = 0;
        }
        return temp == 0 && max == 0 ? -1 : max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = ArrayUtils.readArray(in);
        System.out.println(maxCount(arr));
    }
}
