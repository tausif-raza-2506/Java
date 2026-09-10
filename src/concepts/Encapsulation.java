package concepts;

class Student {
     private String name;
     private int roll;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }
}

public class Encapsulation {
    public static void main(String[] args) {

        /* Setting directly when variables are public
        Student s1 = new Student();
        s1.name = "Alex";
        s1.roll = 12;
        System.out.println("Name: " + s1.name + "Roll: " + s1.roll);
        */

        // When variables are private
        Student s2 = new Student();
        s2.setName("Alex");
        s2.setRoll(12);
        System.out.println("Name: " + s2.getName() + "Roll: " + s2.getRoll());

    }
}