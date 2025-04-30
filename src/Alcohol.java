/*
 * Class: CMSC203 
 * Instructor: Tarek Ahmed
 * Description: Represents an alcoholic beverage with a weekend surcharge.
 * Due: 04/29/2029
 * Platform/compiler: 
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Paulo Navia
*/

public class Alcohol extends Beverage {
    private boolean isWeekend;

    public static final double WEEKEND_PRICE = 0.6;

    public Alcohol(String name, Size size, boolean isWeekend) {
        super(name, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (isWeekend) price += WEEKEND_PRICE;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Weekend: " + isWeekend +
                ", Price: $" + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Alcohol other = (Alcohol) obj;
        return isWeekend == other.isWeekend;
    }

    public boolean isWeekend() { return isWeekend; }

    public void setWeekend(boolean isWeekend) { this.isWeekend = isWeekend; }
}
