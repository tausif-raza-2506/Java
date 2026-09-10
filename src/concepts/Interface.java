package concepts;

interface Laptop {

    /* 1. ABSTRACT METHOD
    Every laptop MUST have a power-on mechanism, but each model handles it differently
    e.g. power button, fingerprint sensor, etc, so it will be overridden. */
    void pressPowerButton();

    /* 2. DEFAULT METHOD
    Built-in behavior that works for ALL laptops.
    Individual models can use it directly or override it if required. */
    default void enableBatterySaver() {
        System.out.println("Enabling Battery Saver Mode...");
        // Uses private method to clean up background processes
        optimizeHardware();
    }

    /* 3. STATIC METHOD
    A utility helper attached to the "Laptop" concept itself.
    Converts battery percentage into estimated hours left.
    Call it directly using: Laptop.estimateBatteryHours(75). */
    static int estimateBatteryHours(int batteryPercent) {
        return batteryPercent / 10;     // Simple estimate: 10% = 1 hour
    }

    /* 4. PRIVATE METHOD
    Hidden background logic inside the motherboard/OS.
    Used inside the interface to share internal features.
    External code CANNOT access or call this directly. */
    private void optimizeHardware() {
        System.out.println("Closing background apps...");
    }
}

class GamingLaptop implements Laptop {
    @Override
    public void pressPowerButton() {
        // Gaming laptop has its own power-on behavior
        System.out.println("Powering ON: RGB lights on");
    }
    // It gets default methods without extra code!
}

public class Interface {
    public static void main(String[] args) {

        // Calling static method directly
        int hoursLeft = Laptop.estimateBatteryHours(80);
        System.out.println("Battery remaining: " + hoursLeft + " hours");

        GamingLaptop myAsus = new GamingLaptop();
        myAsus.pressPowerButton();  // abstract method
        myAsus.enableBatterySaver(); // default method
    }
}
