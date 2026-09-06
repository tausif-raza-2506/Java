package algorithms;
import java.util.*;
public class NumUtils {

    public static final int[] POWERS_OF_10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    public static int countDigits(int num) {
        if (num == 0)
            return 1;
        return (int) Math.log10(Math.abs(num)) + 1;
    }

    public static int[] getDigits(int num) {
        num = Math.abs(num);
        int size = countDigits(num), digits[] = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            digits[i] = (num % 10);
            num /= 10;
        }
        return digits;
    }

    public static int getNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int num = 0;
        for (int digit : arr) {
            num = (num * 10) + digit;
        }
        return num;
    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        for (int n : getDigits(num))
            sum += n;
        return sum;
    }

    public static int productOfDigits(int num) {
        int prod = 1;
        for (int n : getDigits(num))
            prod *= n;
        return prod;
    }

    public static int reverseNum(int num) {
        int org = num;
        num = Math.abs(num);
        int rev = 0;
        for (int i = num; i > 0; i /= 10)
            rev = (rev * 10) + (i % 10);
        return org < 0 ? -rev : rev;
    }

    public static ArrayList<Integer> getDivisors(int num) {
        ArrayList<Integer> divisors = new ArrayList<>();
        num = Math.abs(num);
        if (num == 0)
            return divisors;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                divisors.add(i);
                if (i * i != num)
                    divisors.add(num / i);
            }
        }
        Collections.sort(divisors);
        return divisors;
    }

    public static int sumOfDivisors(int num) {
        int sum = 0;
        for (int d : getDivisors(num)) {
            sum += d;
        }
        return sum;
    }

    public static boolean checkPrime(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        int divisors = getDivisors(num).size();
        return divisors == 2 ? true : false;
    }

    public static int factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        int fac = 1;
        if (num <= 1)
            return 1;
        return num * factorial(num - 1);
    }

    public static int[] Nbonacci(int n, int m) {
        if (n <= 0 || m <= 0)
            return new int[0];

        int series[] = new int[m];

        if (n - 1 < m)
            series[n - 1] = 1;

        if (n < m)
            series[n] = 1;

        for (int i = n + 1; i < m; i++) {
            series[i] = 2 * series[i - 1] - series[i - n - 1];
        }

        return series;
    }

    public static int digitalSum(int num) {
        if (num == 0)
            return 0;
        return 1 + (num - 1) % 9;
    }

    public static int leftRotate(int num, int k) {
        if (num == 0)
            return 0;
        int size = countDigits(num);
        k %= size;
        if (k < 0)
            k += size;
        if (k == 0)
            return num;
        int div = POWERS_OF_10[k];
        int mult = POWERS_OF_10[size - k];
        return (num % div) * mult + (num / div);
    }

    public static int rightRotate(int num, int k) {
        return leftRotate(num, -k);
    }

    public static ArrayList<Integer> primeFactors(int num) {
        ArrayList<Integer> factors = new ArrayList<>();
        num = Math.abs(num);
        if (num <= 1)
            return factors;
        while (num % 2 == 0) {
            factors.add(2);
            num /= 2;
        }
        for (int i = 3; i * i <= num; i += 2) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }
        if (num > 2)
            factors.add(num);
        return factors;
    }

    public static int[] freqOfDigits(int num) {
        int freq[] = new int[10];
        if (num == 0) {
            freq[0] = 1;
            return freq;
        }
        num = Math.abs(num);
        for (int i = num; i > 0; i /= 10)
            freq[i % 10]++;
        return freq;
    }

    public static int gcd(int a, int b) {
        return (b == 0) ? Math.abs(a) : gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return (a == 0 || b == 0) ? 0 : Math.abs(a / gcd(a, b) * b);
    }
}