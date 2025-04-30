/*
 * Class: CMSC203 
 * Instructor: Tarek Ahmed
 * Description: Represents a coffee beverage with optional extra shot and syrup.
 * Due: 04/29/2029
 * Platform/compiler: 
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Paulo Navia
*/

public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;

    public static final double EXTRA_SHOT_PRICE = 0.5;
    public static final double EXTRA_SYRUP_PRICE = 0.5;

    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
        super(name, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (extraShot) price += EXTRA_SHOT_PRICE;
        if (extraSyrup) price += EXTRA_SYRUP_PRICE;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Extra Shot: " + extraShot +
                ", Extra Syrup: " + extraSyrup +
                ", Price: $" + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Coffee other = (Coffee) obj;
        return extraShot == other.extraShot && extraSyrup == other.extraSyrup;
    }

    public boolean getExtraShot() { return extraShot; }
    public boolean getExtraSyrup() { return extraSyrup; }

    public void setExtraShot(boolean extraShot) { this.extraShot = extraShot; }
    public void setExtraSyrup(boolean extraSyrup) { this.extraSyrup = extraSyrup; }
}
