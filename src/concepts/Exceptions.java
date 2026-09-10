package concepts;
import java.util.*;

class MyException extends Exception {
    public MyException(String str) {
        super(str);
    }
}

public class Exceptions {

    public static void withoutTry(int a, int b) {
        System.out.println("Integral part of a/b is " + a / b);
        // Program breaks here, does not execute further.

        System.out.println("End of program");
    }

    public static void withTry(int a, int b) {
        try {
            System.out.println("Integral part of a/b is " + a / b);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("End of Program");
        }
    }

    public static void custom(int age) {
        try {
            if (age < 0)
                throw new MyException("Age cannot be negative");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        withoutTry(12,0);
        withTry(12,0);
        custom(-12);
    }
}