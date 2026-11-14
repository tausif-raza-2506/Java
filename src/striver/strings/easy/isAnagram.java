package striver.strings.easy;
import java.util.*;

public class isAnagram {

    /** Brute force approach: Sort both the strings alphabetically.
     * So, after sorting both the strings will be equal and can be compared.
     * Time Complexity -> O(N log N)
     */
    public static boolean brute(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] arr1 = s.toCharArray(), arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    /** Optimal approach: Do hashing of both strings.
     * For two strings to be an anagram, their frequency of letters will be same.
     * Time complexity -> O(N)
     */
    public static boolean optimal(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] tHash = new int[26], sHash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            tHash[t.charAt(i) - 'a']++;
            sHash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < sHash.length; i++) {
            if (sHash[i] != tHash[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(optimal("anagram", "nagaram"));
    }
}
