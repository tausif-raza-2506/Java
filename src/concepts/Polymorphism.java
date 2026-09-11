package concepts;

class Phone {
    public void turnOn() {
        System.out.println("Turning on phone...");
    }
}

class Smartphone extends Phone {
    @Override
    public void turnOn() {
        System.out.println("Turning on smartphone...");
    }

    public void music() {
        System.out.println("Playing music");
    }
}

public class Polymorphism {
    public static void main(String[] args) {

        Phone a = new Smartphone();        // Only overridden methods can be accessed.
        Smartphone b = new Smartphone();   // To access other methods of subclass
        // Smartphone c = new Phone();        -> Child class cannot reference Parent class

        a.turnOn();     // Dynamic Method Dispatch: calls Smartphone's overridden method
        // a.music(); -> shows error
        b.music();

    }
}
