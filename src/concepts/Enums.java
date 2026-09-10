package concepts;

enum Laptop {
    Macbook("Apple", 2000),
    SurfacePro("Microsoft", 1800),
    GalaxyBook("Samsung", 1900),
    ThinkPad("Lenovo", 1700);

    private final String companyName;
    private final int price;

    Laptop(String companyName, int price) {
        this.companyName = companyName;
        this.price = price;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getPrice() {
        return price;
    }
}

public class Enums {
    public static void main(String[] args) {

        Laptop lap = Laptop.GalaxyBook;
        System.out.println(lap + " : " + lap.getPrice());

        // For printing all values
        Laptop[] lappy = Laptop.values();
        for (Laptop l : lappy) {
            System.out.println(l.getCompanyName() + " : " + l.getPrice());
        }

        // Enum using switch case
        Laptop lap2 = Laptop.SurfacePro;
        String s = switch(lap) {
            case Macbook -> "I don't like Apple";
            case GalaxyBook -> "Buy it";
            case SurfacePro -> "Too expensive";
            case ThinkPad -> "Nice choice";
            default -> "Will see";
        };
        System.out.println(s);

    }
}
