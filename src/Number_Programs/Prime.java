package Number_Programs;
import java.util.*;
public class Prime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, i, c = 0;
        System.out.println("Enter a number");
        num = in.nextInt();
        for (i = 2; i < num; i++) {
            if (num % i == 0)
                c++;
        }
        System.out.println(c == 0 ? "Prime" : "Not a Prime");
    }
}