package basics;
import algorithms.NumUtils;
import java.util.*;
import static java.util.Map.entry;

public class NumberProgram {

    public static boolean palindrome(int num) {
        return NumUtils.reverseNum(num) == num;
    }

    public static boolean armstrong(int num) {
        int size = NumUtils.countDigits(num), sum = 0;
        for (int i = num; i > 0; i /= 10)
            sum += (int) Math.pow(i % 10, size);
        return sum == num;
    }

    public static boolean buzz(int num) {
        return num % 7 == 0 || num % 10 == 7;
    }

    public static boolean spy(int num) {
        return NumUtils.sumOfDigits(num) == NumUtils.productOfDigits(num);
    }

    public static boolean duck(int num) {
        return NumUtils.freqOfDigits(num)[0] > 0;
    }

    public static boolean niven(int num) {
        return num % NumUtils.sumOfDigits(num) == 0;
    }

    public static boolean neon(int num) {
        return NumUtils.sumOfDigits(num * num) == num;
    }

    public static boolean automorphic(int num) {
        int size = NumUtils.countDigits(num);
        return (num * num) % (NumUtils.POWERS_OF_10[size]) == num;
    }

    public static boolean pronic(int num) {
        int n = (int) Math.sqrt(num);
        return n * (n + 1) == num;
    }

    public static boolean perfect(int num) {
        return NumUtils.sumOfDivisors(num) - num == num;
    }

    public static boolean abundant(int num) {
        return NumUtils.sumOfDivisors(num) - num > num;
    }

    public static boolean deficient(int num) {
        return NumUtils.sumOfDivisors(num) - num < num;
    }

    public static boolean krishnamurthy(int num) {
        int sum = 0;
        for (int i = num; i > 0; i /= 10)
            sum += NumUtils.factorial(i % 10);
        return sum == num;
    }

    public static boolean disarium(int num) {
        int sum = 0, k = NumUtils.countDigits(num);
        for (int i = num; i > 0; i /= 10) {
            sum += (int) Math.pow(i % 10, k);
            k--;
        }
        return sum == num;
    }

    public static boolean magic(int num) {
        int sum = NumUtils.sumOfDigits(num);
        return sum < 10 ? sum == 1 : magic(sum);
    }

    public static boolean happy(int num) {
        int sum = 0;
        for (int i = num; i > 0; i /= 10)
            sum += (i % 10) * (i % 10);
        return sum < 10 ? sum == 1 || sum == 7 : happy(sum);
    }

    public static boolean unique(int num) {
        int[] arr = NumUtils.freqOfDigits(num);
        for (int n : arr)
            if (n > 1) return false;
        return true;
    }

    public static boolean twinPrime(int num1, int num2) {
        boolean b1 = NumUtils.checkPrime(num1), b2 = NumUtils.checkPrime(num2);
        return b1 && b2 && Math.abs(num1 - num2) == 2;
    }

    public static boolean palPrime(int num) {
        return NumUtils.checkPrime(num) && palindrome(num);
    }

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

    public static boolean circularPrime(int num) {
        if (!NumUtils.checkPrime(num)) return false;
        int size = NumUtils.countDigits(num);
        for (int i = 1; i < size; i++) {
            int x = NumUtils.leftRotate(num, i);
            if (!NumUtils.checkPrime(x)) return false;
        }
        return true;
    }

    public static boolean ugly(int num) {
        for (int n : NumUtils.primeFactors(num)) {
            if (n > 5) return false;
        }
        return true;
    }

    public static boolean amicablePair(int num1, int num2) {
        return NumUtils.sumOfDivisors(num1) == num2 && NumUtils.sumOfDivisors(num2) == num1;
    }

    public static boolean smith(int num) {
        int sum = 0;
        for (int n : NumUtils.primeFactors(num))
            sum += NumUtils.sumOfDigits(n);
        return sum == NumUtils.sumOfDigits(num);
    }

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

    public static boolean evil(int num) {
        return Integer.bitCount(num) % 2 == 0;
    }

    public static boolean odious(int num) {
        return !evil(num);
    }

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

    Map<String, String> definitions = Map.ofEntries(
            entry("palindrome",    "Reads the same forwards and backwards."),
            entry("armstrong",     "Sum of digits raised to digit count equals the number."),
            entry("buzz",          "Divisible by 7 or ends with 7."),
            entry("spy",           "Sum of digits equals product of digits."),
            entry("duck",          "Positive number containing at least one non-leading zero."),
            entry("niven",         "Divisible by the sum of its digits."),
            entry("neon",          "Sum of digits of its square equals the number."),
            entry("automorphic",   "Square ends with the number itself."),
            entry("pronic",        "Product of two consecutive integers n(n+1)."),
            entry("perfect",       "Sum of proper divisors equals the number."),
            entry("abundant",      "Sum of proper divisors is greater than the number."),
            entry("deficient",     "Sum of proper divisors is less than the number."),
            entry("krishnamurthy", "Sum of factorials of digits equals the number."),
            entry("disarium",      "Sum of digits powered to their positions equals the number."),
            entry("magic",         "Repeated sum of digits eventually reaches 1."),
            entry("happy",         "Repeated sum of squares of digits eventually reaches 1."),
            entry("unique",        "All digits are distinct with no repeats."),
            entry("twinPrime",     "Two prime numbers differing by 2."),
            entry("palPrime",      "A number that is both prime and palindrome."),
            entry("kaprekar",      "Square can be split into two parts summing to the number."),
            entry("circularPrime", "All cyclic rotations of its digits are prime."),
            entry("ugly",          "Positive integer whose only prime factors are 2, 3, or 5."),
            entry("amicablePair",  "Two numbers where proper divisors of each sum to the other."),
            entry("smith",         "Composite number where sum of digits equals sum of prime factor digits."),
            entry("fascinating",   "Concatenating num, num*2, num*3 contains digits 1-9 once."),
            entry("evil",          "Binary representation has an even count of 1s."),
            entry("odious",        "Binary representation has an odd count of 1s."),
            entry("bouncy",        "Digits neither strictly increase nor strictly decrease."),
            entry("goldbach",      "Even number > 2 expressible as sum of two primes."),
            entry("mersennePrime", "Prime number of the form 2^p - 1.")
    );
}