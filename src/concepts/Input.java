package concepts;
import java.io.*;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) throws IOException {

        // Using Scanner Class
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        sc.close();

        // Using BufferedReader Class
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        try (br) {
            System.out.println("Enter a number");
            int num = Integer.parseInt(br.readLine());
            System.out.println(num);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            br.close();
        }
    }
}