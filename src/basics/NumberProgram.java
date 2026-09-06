package basics;
import algorithms.NumUtils;

public class NumberProgram {

    /**
     * Reads the same forwards and backwards.
     */
    public static boolean palindrome(int num) {
        return NumUtils.reverseNum(num) == num;
    }

    /**
     * Sum of digits raised to number of digits equals the number.
     */
    public static boolean armstrong(int num) {
        int size = NumUtils.countDigits(num), sum = 0;
        for (int i = num; i > 0; i /= 10)
            sum += (int) Math.pow(i % 10, size);
        return sum == num;
    }

    /**
     * Divisible by 7 or ends with 7.
     */
    public static boolean buzz(int num) {
        return num % 7 == 0 || num % 10 == 7;
    }

    /**
     * Sum of digits equals product of digits.
     */
    public static boolean spy(int num) {
        return NumUtils.sumOfDigits(num) == NumUtils.productOfDigits(num);
    }

    /**
     * Positive number containing at least one non-leading zero.
     */
    public static boolean duck(int num) {
        return NumUtils.freqOfDigits(num)[0] > 0;
    }

    /**
     * Number divisible by the sum of its digits.
     */
    public static boolean niven(int num) {
        return num % NumUtils.sumOfDigits(num) == 0;
    }

    /**
     * Sum of digits of its square equals the number.
     */
    public static boolean neon(int num) {
        return NumUtils.sumOfDigits(num * num) == num;
    }

    /**
     * Square ends with the number itself.
     */
    public static boolean automorphic(int num) {
        int size = NumUtils.countDigits(num);
        return (num * num) % (NumUtils.POWERS_OF_10[size]) == num;
    }

    /**
     * Number can be represented as product of two consecutive integers n(n+1).
     */
    public static boolean pronic(int num) {
        int n = (int) Math.sqrt(num);
        return n * (n + 1) == num;
    }

    /**
     * Sum of proper divisors equals the number.
     */
    public static boolean perfect(int num) {
        return NumUtils.sumOfDivisors(num) - num == num;
    }

    /**
     * Sum of proper divisors is greater than the number.
     */
    public static boolean abundant(int num) {
        return NumUtils.sumOfDivisors(num) - num > num;
    }

    /**
     * Sum of proper divisors is less than the number.
     */
    public static boolean deficient(int num) {
        return NumUtils.sumOfDivisors(num) - num < num;
    }

    /**
     * Sum of factorials of digits equals the number.
     */
    public static boolean krishnamurthy(int num) {
        int sum = 0;
        for (int i = num; i > 0; i /= 10)
            sum += NumUtils.factorial(i % 10);
        return sum == num;
    }

    /**
     * Sum of digits raised to their positions equals the number.
     */
    public static boolean disarium(int num) {
        int sum = 0, k = NumUtils.countDigits(num);
        for (int i = num; i > 0; i /= 10) {
            sum += (int) Math.pow(i % 10, k);
            k--;
        }
        return sum == num;
    }

    /**
     * Repeated sum of digits eventually reaches 1.
     */
    public static boolean magic(int num) {
        int sum = NumUtils.sumOfDigits(num);
        return sum < 10 ? sum == 1 : magic(sum);
    }

    /**
     * Repeated sum of squares of digits eventually reaches 1.
     */
    public static boolean happy(int num) {
        int sum = 0;
        for (int i = num; i > 0; i /= 10)
            sum += (i % 10) * (i % 10);
        return sum < 10 ? sum == 1 || sum == 7 : happy(sum);
    }

    /** All digits are distinct with no repetitions. */
    public static boolean unique(int num) {
        int[] arr = NumUtils.freqOfDigits(num);
        for (int n : arr)
            if (n > 1) return false;
        return true;
    }

    /**
     * Two prime numbers differing by 2.
     */
    public static boolean twinPrime(int num1, int num2) {
        boolean b1 = NumUtils.checkPrime(num1), b2 = NumUtils.checkPrime(num2);
        return b1 && b2 && Math.abs(num1 - num2) == 2;
    }

    /**
     * A number that is both prime and palindrome.
     */
    public static boolean palPrime(int num) {
        return NumUtils.checkPrime(num) && palindrome(num);
    }

    /**
     * Square can be split into two parts summing to the number.
     */
    public static boolean kaprekar(int num) {
        if (num == 1) return true;
        int sq = num * num, right, left;
        for (int i = 10; i < sq; i *= 10) {
            right = sq % i;
            left = sq / i;
            if (right > 0 && (left + right == num)) return true;
        }
        return false;
    }

    /**
     * All cyclic rotations of the number are prime.
     */
    public static boolean circularPrime(int num) {
        if (!NumUtils.checkPrime(num)) return false;
        int size = NumUtils.countDigits(num);
        for (int i = 1; i < size; i++) {
            int x = NumUtils.leftRotate(num, i);
            if (!NumUtils.checkPrime(x)) return false;
        }
        return true;
    }

    /**
     * Positive integer whose only prime factors are 2, 3, or 5.
     */
    public static boolean ugly(int num) {
        for (int n : NumUtils.primeFactors(num)) {
            if (n > 5) return false;
        }
        return true;
    }

    /**
     * Two numbers where proper divisors of each sums up to the other number.
     */
    public static boolean amicablePair(int num1, int num2) {
        return NumUtils.sumOfDivisors(num1) == num2 && NumUtils.sumOfDivisors(num2) == num1;
    }

    /**
     * Sum of digits equals sum of digits of its prime factors.
     */
    public static boolean smith(int num) {
        int sum = 0;
        for (int n : NumUtils.primeFactors(num))
            sum += NumUtils.sumOfDigits(n);
        return sum == NumUtils.sumOfDigits(num);
    }

    /**
     * Concatenating num, num*2, num*3 contains digits 1 to 9 once.
     */
    public static boolean fascinating(int num) {
        if (num < 100 || num > 333) return false;
        String s = "" + num + (num * 2) + (num * 3);
        int x = Integer.parseInt(s);
        if (duck(x)) return false;
        int[] arr = NumUtils.freqOfDigits(x);
        for (int i = 1; i <= 9; i++) {
            if (arr[i] != 1) return false;
        }
        return true;
    }

    /**
     * Binary representation has an even number of 1s.
     */
    public static boolean evil(int num) {
        return Integer.bitCount(num) % 2 == 0;
    }

    /**
     * Binary representation has an odd number of 1s.
     */
    public static boolean odious(int num) {
        return !evil(num);
    }

    /**
     * Digits neither strictly increasing nor strictly decreasing.
     */
    public static boolean bouncy(int num) {
        boolean inc = false, dec = false;
        int curr;
        for (int prev = num % 10; (num /= 10) > 0; prev = curr) {
            curr = num % 10;
            inc |= (curr < prev);
            dec |= (curr > prev);
            if (inc && dec) return true;
        }
        return false;
    }

    /**
     * Even number > 2 expressible as sum of two primes.
     */
    public static boolean goldbach(int num) {
        if (num <= 2 || num % 2 != 0) return false;
        if (num == 4) {
            System.out.println(num + " = " + '2' + " + " + '2');
            return true;
        }
        for (int p1 = 3; p1 <= num / 2; p1 += 2) {
            int p2 = num - p1;
            if (NumUtils.checkPrime(p1) && NumUtils.checkPrime(p2)) {
                System.out.println(num + " = " + p1 + " + " + p2);
                return true;
            }
        }
        return false;
    }

    /**
     * Prime number of the form 2^p - 1.
     */
    public static boolean mersennePrime(int num) {
        if (!NumUtils.checkPrime(num))
            return false;

        // Using String Only
        String binary = Integer.toBinaryString(num);
        return !binary.contains("0");

//        Using Bitwise AND operator
//        int next = num + 1;
//        if ((next & (next - 1)) != 0)
//            return false;
    }
}