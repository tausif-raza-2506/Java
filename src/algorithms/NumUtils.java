package algorithms;
public class NumUtils {

    public static int countDigits(int num) {
        int c = 0;
        for (int i = num; i > 0; i /= 10)
            c++;
        return c;
    }

    public static int reverseNum(int num) {
        int rev = 0;
        for (int i = num; i > 0; i /= 10)
            rev = (rev * 10) + (i % 10);
        return rev;
    }

    public static int countDivisors(int num) {
        int c = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                c++;
        }
        return c;
    }

    public static int checkPrime(int num) {
        int divisors = countDivisors(num);
        return divisors == 2 ? 1 : -1;
    }

    public static int factorial(int num) {
        int fac = 1;
        if (num == 1 || num == 0)
            return 1;
        for (int i = num; i <= 1; i--)
            fac *= i;
        return fac;
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
}