/*
 * Class: CMSC203 
 * Instructor: Tarek Ahmed
 * Description: Represents a smoothie beverage with optional protein and fruit count.
 * Due: 04/29/2029
 * Platform/compiler: 
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Paulo Navia
*/

public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;

    public static final double PROTEIN_PRICE = 1.5;
    public static final double FRUIT_PRICE = 0.5;

    public Smoothie(String name, Size size, int numOfFruits, boolean addProtein) {
        super(name, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (addProtein) price += PROTEIN_PRICE;
        price += numOfFruits * FRUIT_PRICE;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Number of Fruits: " + numOfFruits +
                ", Protein: " + addProtein +
                ", Price: $" + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Smoothie other = (Smoothie) obj;
        return numOfFruits == other.numOfFruits && addProtein == other.addProtein;
    }

    public int getNumOfFruits() { return numOfFruits; }
    public boolean getAddProtein() { return addProtein; }

    public void setNumOfFruits(int numOfFruits) { this.numOfFruits = numOfFruits; }
    public void setAddProtein(boolean addProtein) { this.addProtein = addProtein; }
}
