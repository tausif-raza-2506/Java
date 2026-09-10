package concepts;
import algorithms.NumUtils;
import java.util.*;

public class NumberProgram {

    /** Returns the definition along with one example of the number program. */
    public static String getDefinition(int choice) {
        return switch (choice) {
            case 1 -> """
            A number that reads the same forwards and backwards.
            Example: 121 (Reverse of 121 is 121).
            """;
            case 2 -> """
            Sum of its digits raised to the power of number of digits equals the number.
            Example: 153 (1³ + 5³ + 3³ = 1 + 125 + 27 = 153).
            """;
            case 3 -> """
            A number that ends with 7 or is divisible by 7.
            Example: 49 (Divisible by 7) or 27 (Ends with 7).
            """;
            case 4 -> """
            The sum of its digits equals the product of its digits.
            Example: 1124 (1 + 1 + 2 + 4 = 8, and 1 * 1 * 2 * 4 = 8).
            """;
            case 5 -> """
            A positive number containing at least one zero, but not starting with zero.
            Example: 1023 (Contains '0' and does not start with 0).
            """;
            case 6 -> """
            A number divisible by the sum of its digits.
            Example: 18 (Sum of digits = 1 + 8 = 9; 18 % 9 == 0).
            """;
            case 7 -> """
            The sum of digits of the square of the number equals the number itself.
            Example: 9 (9² = 81, and 8 + 1 = 9).
            """;
            case 8 -> """
            A number whose square ends with the number itself.
            Example: 25 (25² = 625, ends in 25).
            """;
            case 9 -> """
            A number that is the product of two consecutive integers n * (n + 1).
            Example: 42 (6 * 7 = 42).
            """;
            case 10 -> """
            A positive integer equal to the sum of its proper positive divisors.
            Example: 28 (Divisors: 1, 2, 4, 7, 14 -> 1 + 2 + 4 + 7 + 14 = 28).
            """;
            case 11 -> """
            Sum of proper divisors is strictly greater than the number.
            Example: 12 (Divisors: 1, 2, 3, 4, 6 -> sum = 16 > 12).
            """;
            case 12 -> """
            Sum of proper divisors is strictly less than the number.
            Example: 15 (Divisors: 1, 3, 5 -> sum = 9 < 15).
            """;
            case 13 -> """
            The sum of factorials of digits equals the number itself.
            Example: 145 (1! + 4! + 5! = 1 + 24 + 120 = 145).
            """;
            case 14 -> """
            Sum of its digits powered to their respective positions equals the number.
            Example: 135 (1¹ + 3² + 5³ = 1 + 9 + 125 = 135).
            """;
            case 15 -> """
            Repeated sum of digits eventually reduces to 1.
            Example: 19 (1 + 9 = 10 -> 1 + 0 = 1).
            """;
            case 16 -> """
            Replacing the number with sum of squares of digits repeatedly leads to 1.
            Example: 19 (1² + 9² = 82 -> 8² + 2² = 68 -> 6² + 8² = 100 -> 1² + 0² + 0² = 1).
            """;
            case 17 -> """
            A number with no repeating digits.
            Example: 1234 (All digits 1, 2, 3, 4 are distinct).
            """;
            case 18 -> """
            A pair of prime numbers that differ by 2.
            Example: (11, 13) or (17, 19).
            """;
            case 19 -> """
            A number that is simultaneously prime and a palindrome.
            Example: 131 (Prime and reads 131 backwards).
            """;
            case 20 -> """
            Square of number can be split into two parts that add up to the original.
            Example: 45 (45² = 2025 -> 20 + 25 = 45).
            """;
            case 21 -> """
            A prime number whose all cyclic rotations are also primes.
            Example: 197 (Rotations: 197, 971, 719 are all prime).
            """;
            case 22 -> """
            Positive numbers whose only prime factors are 2, 3, or 5.
            Example: 12 (Prime factorization: 2 * 2 * 3).
            """;
            case 23 -> """
            Two numbers where sum of proper divisors of each equals the other.
            Example: 220 and 284 (Divisors of 220 sum to 284; divisors of 284 sum to 220).
            """;
            case 24 -> """
            Composite number where sum of digits equals sum of digits of its prime factors.
            Example: 666 (6+6+6 = 18; Factors: 2 * 3 * 3 * 37 -> 2 + 3 + 3 + 3 + 7 = 18).
            """;
            case 25 -> """
            Multiplying by 2 and 3 and concatenating with original contains digits 1-9 once.
            Example: 192 (192, 192*2=384, 192*3=576 -> "192384576" contains 1 through 9).
            """;
            case 26 -> """
            A positive number whose binary representation has an even count of 1s.
            Example: 9 (Binary: 1001₂ -> contains two '1's).
            """;
            case 27 -> """
            A positive number whose binary representation has an odd count of 1s.
            Example: 11 (Binary: 1011₂ -> contains three '1's).
            """;
            case 28 -> """
            A number whose digits are neither strictly increasing nor decreasing.
            Example: 153 (Increases from 1 to 5, then decreases from 5 to 3).
            """;
            case 29 -> """
            An even integer greater than 2 that can be written as sum of two primes.
            Example: 28 (28 = 5 + 23 or 11 + 17).
            """;
            case 30 -> """
            A prime number of the form 2ᵖ - 1 where p is also a prime.
            Example: 31 (2⁵ - 1 = 31, where 5 is prime).
            """;
            default -> "Invalid choice. Please pick a number from 1 to 30.";
        };
    }

    /** Reads the same forwards and backwards. */
    public static boolean palindrome(int num) {
        return NumUtils.reverseNum(num) == num;
    }

    /** Sum of digits raised to number of digits equals the number. */
    public static boolean armstrong(int num) {
        int size = NumUtils.countDigits(num), sum = 0;
        for (int i = num; i > 0; i /= 10)
            sum += (int) Math.pow(i % 10, size);
        return sum == num;
    }

    /** Divisible by 7 or ends with 7. */
    public static boolean buzz(int num) {
        return num % 7 == 0 || num % 10 == 7;
    }

    /** Sum of digits equals product of digits. */
    public static boolean spy(int num) {
        return NumUtils.sumOfDigits(num) == NumUtils.productOfDigits(num);
    }

    /** Positive number containing at least one non-leading zero. */
    public static boolean duck(int num) {
        return NumUtils.freqOfDigits(num)[0] > 0;
    }

    /** Number divisible by the sum of its digits. */
    public static boolean niven(int num) {
        return num % NumUtils.sumOfDigits(num) == 0;
    }

    /** Sum of digits of its square equals the number. */
    public static boolean neon(int num) {
        return NumUtils.sumOfDigits(num * num) == num;
    }

    /** Square ends with the number itself. */
    public static boolean automorphic(int num) {
        int size = NumUtils.countDigits(num);
        return (num * num) % (NumUtils.POWERS_OF_10[size]) == num;
    }

    /** Number can be represented as product of two consecutive integers n(n+1). */
    public static boolean pronic(int num) {
        int n = (int) Math.sqrt(num);
        return n * (n + 1) == num;
    }

    /** Sum of proper divisors equals the number. */
    public static boolean perfect(int num) {
        return NumUtils.sumOfDivisors(num) - num == num;
    }

    /** Sum of proper divisors is greater than the number. */
    public static boolean abundant(int num) {
        return NumUtils.sumOfDivisors(num) - num > num;
    }

    /** Sum of proper divisors is less than the number. */
    public static boolean deficient(int num) {
        return NumUtils.sumOfDivisors(num) - num < num;
    }

    /** Sum of factorials of digits equals the number. */
    public static boolean krishnamurthy(int num) {
        int sum = 0;
        for (int i = num; i > 0; i /= 10)
            sum += NumUtils.factorial(i % 10);
        return sum == num;
    }

    /** Sum of digits raised to their positions equals the number. */
    public static boolean disarium(int num) {
        int sum = 0, k = NumUtils.countDigits(num);
        for (int i = num; i > 0; i /= 10) {
            sum += (int) Math.pow(i % 10, k);
            k--;
        }
        return sum == num;
    }

    /** Repeated sum of digits eventually reaches 1. */
    public static boolean magic(int num) {
        int sum = NumUtils.sumOfDigits(num);
        return sum < 10 ? sum == 1 : magic(sum);
    }

    /** Repeated sum of squares of digits eventually reaches 1. */
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

    /** Two prime numbers differing by 2. */
    public static boolean twinPrime(int num1, int num2) {
        boolean b1 = NumUtils.checkPrime(num1), b2 = NumUtils.checkPrime(num2);
        return b1 && b2 && Math.abs(num1 - num2) == 2;
    }

    /** A number that is both prime and palindrome. */
    public static boolean palPrime(int num) {
        return NumUtils.checkPrime(num) && palindrome(num);
    }

    /** Square can be split into two parts summing to the number. */
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

    /** All cyclic rotations of the number are prime. */
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

    /** Two numbers where proper divisors of each sums up to the other number. */
    public static boolean amicablePair(int num1, int num2) {
        return NumUtils.sumOfDivisors(num1) == num2 && NumUtils.sumOfDivisors(num2) == num1;
    }

    /** Sum of digits equals sum of digits of its prime factors. */
    public static boolean smith(int num) {
        int sum = 0;
        for (int n : NumUtils.primeFactors(num))
            sum += NumUtils.sumOfDigits(n);
        return sum == NumUtils.sumOfDigits(num);
    }

    /** Concatenating num, num*2, num*3 contains digits 1 to 9 once. */
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

    /** Binary representation has an even number of 1s. */
    public static boolean evil(int num) {
        return Integer.bitCount(num) % 2 == 0;
    }

    /** Binary representation has an odd number of 1s. */
    public static boolean odious(int num) {
        return !evil(num);
    }

    /** Digits neither strictly increasing nor strictly decreasing. */
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

    /** Even number > 2 expressible as sum of two primes. */
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

    /** Prime number of the form 2^p - 1. */
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, choice, k;
        do {
            System.out.println("""
                    1. palindrome
                    2. armstrong
                    3. buzz
                    4. spy
                    5. duck
                    6. niven
                    7. neon
                    8. automorphic
                    9. pronic
                    10. perfect
                    11. abundant
                    12. deficient
                    13. krishnamurthy
                    14. disarium
                    15. magic
                    16. happy
                    17. unique
                    18. twinPrime
                    19. palPrime
                    20. kaprekar
                    21. circularPrime
                    22. ugly
                    23. amicablePair
                    24. smith
                    25. fascinating
                    26. evil
                    27. odious
                    28. bouncy
                    29. goldbach
                    30. mersennePrime
                    """);
            System.out.println("Enter choice");
            choice = in.nextInt();
            System.out.println(getDefinition(choice));
            System.out.println("Enter number(s)");
            num = in.nextInt();
            System.out.println(switch (choice) {
                case 1 -> palindrome(num);
                case 2 -> armstrong(num);
                case 3 -> buzz(num);
                case 4 -> spy(num);
                case 5 -> duck(num);
                case 6 -> niven(num);
                case 7 -> neon(num);
                case 8 -> automorphic(num);
                case 9 -> pronic(num);
                case 10 -> perfect(num);
                case 11 -> abundant(num);
                case 12 -> deficient(num);
                case 13 -> krishnamurthy(num);
                case 14 -> disarium(num);
                case 15 -> magic(num);
                case 16 -> happy(num);
                case 17 -> unique(num);
                case 18 -> twinPrime(num, in.nextInt());
                case 19 -> palPrime(num);
                case 20 -> kaprekar(num);
                case 21 -> circularPrime(num);
                case 22 -> ugly(num);
                case 23 -> amicablePair(num, in.nextInt());
                case 24 -> smith(num);
                case 25 -> fascinating(num);
                case 26 -> evil(num);
                case 27 -> odious(num);
                case 28 -> bouncy(num);
                case 29 -> goldbach(num);
                case 30 -> mersennePrime(num);
                default -> "Invalid choice";
            });
            System.out.println("Enter 1 to continue or any other number to terminate");
            k = in.nextInt();
        } while (k == 1);
    }
}