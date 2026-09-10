package concepts;

@FunctionalInterface
interface A {
    void greet();
}

public class Lambda {
    public static void main(String[] args) {

        // Without using Lambda
        A obj = new A() {
            @Override
            public void greet() {
                System.out.println("Hello!");
            }
        };

        // Using Lambda
        A obj1 = () -> System.out.println("Hello!");

        /*
        --> If one parameter is given
        A obj = int i -> System.out.println("Hello!" + i);
        obj.greet();

        --> If two parameters are given
        A obj = (int i + int j) -> System.out.println("Hello!" + (i+j));
        obj.greet();

        --> If the function returns something
        A obj = (int i + int j) -> i+j;
        int sum = obj.add(2,3);
        System.out.println(sum);

        */
    }
}
