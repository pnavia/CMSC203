/*
 * Class: CMSC203 
 * Instructor: Tarek Ahmed
 * Description: Abstract class that defines common properties and methods for all beverages.
 * Due: 04/29/2029
 * Platform/compiler: 
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Paulo Navia
*/

public abstract class Beverage {
    private String name;
    private Type type;
    private Size size;

    public static final double BASE_PRICE = 2.0;
    public static final double SIZE_PRICE = 0.5;

    public Beverage(String name, Type type, Size size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public double addSizePrice() {
        switch (size) {
            case MEDIUM:
                return BASE_PRICE + SIZE_PRICE;
            case LARGE:
                return BASE_PRICE + 2 * SIZE_PRICE;
            default:
                return BASE_PRICE;
        }
    }

    public abstract double calcPrice();

    public String toString() {
        return "Name: " + name + ", Size: " + size;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Beverage) {
            Beverage other = (Beverage) obj;
            return name.equals(other.name) && type == other.type && size == other.size;
        }
        return false;
    }

    public String getName() { return name; }
    public Type getType() { return type; }
    public Size getSize() { return size; }
    public double getBasePrice() { return BASE_PRICE; }
    public double getSizePrice() { return SIZE_PRICE; }

    public void setName(String name) { this.name = name; }
    public void setType(Type type) { this.type = type; }
    public void setSize(Size size) { this.size = size; }
}
