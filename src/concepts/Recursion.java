package concepts;

public class Recursion {

    /** To find the sum of first n natural numbers. */
    public static int sum(int n) {
        if(n==0) return 0;
        return n + sum(n-1);
    }

    /** To find the factorial of a number. */
    public static int factorial(int n) {
        if(n==0 || n==1) return 1;
        return n * factorial(n-1);
    }

    /** To find sum of array elements. */
    public static int sumArray(int[] arr, int index) {
        if (index >= arr.length) return 0;
        return arr[index] + sumArray(arr, index + 1);
    }

    /** To reverse an array. */
    public static int[] revArray(int[] arr, int left, int right) {
        if(left>right) return arr;
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        return revArray(arr, left + 1, right - 1);
    }

    /** To reverse a string. */
    public static String reverseString(String s, int index){
        if(index < 0) return "";
        return s.charAt(index) + reverseString(s,index - 1);
    }

    /** To rotate a string anti-clockwise. */
    public static String rotateString(String s, int k) {
        if (s == null) return null;
        int n = s.length();
        k = k % n;
        return s.substring(n - k) + s.substring(0, n - k);
    }

    /** To return the sum of digits. */
    public static int sumOfDigits(int num) {
        if (num <= 0) return 0;
        return (num % 10) + sumOfDigits(num / 10);
    }

    /** To print the kth term of fibonacci series. */
    public static int fibonacci(int k) {
        if(k==0) return 0;
        if(k==1) return 1;
        return fibonacci(k-1) + fibonacci(k-2);
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        return isPrime(num, 2);
    }

    /** To check whether the number is prime or not. */
    public static boolean isPrime(int num, int i) {
        if (i * i > num) return true;
        if (num % i == 0) return false;
        return isPrime(num, i + 1);
    }

    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length <= 1) return true;
        return isSorted(arr, 0);
    }

    /** To check if the array is sorted or not. */
    public static boolean isSorted(int[] arr, int index) {
        if (index == arr.length - 1) return true;
        if(arr[index] > arr[index + 1]) return false;
        return isSorted(arr, index + 1);
    }

}
