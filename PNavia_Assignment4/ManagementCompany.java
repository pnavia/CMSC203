package application;

/*
 * Class: CMSC203 
 * Instructor: Tarek, Ahmed
 * Description: This class manages a list of Property objects, handles rent calculations, validates plots, and ensures no overlaps.
 * Due: 04/04/2025
 * Platform/compiler: Eclipse  
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Paulo Navia
*/

public class ManagementCompany {
    private String name;
    private String taxID;
    private double mgmtFee;
    private Property[] properties;
    private Plot plot;

    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    private int propertyCount;

    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.mgmtFee = 0;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.propertyCount = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmtFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmtFee = mgmtFee;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.propertyCount = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmtFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmtFee = mgmtFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.propertyCount = 0;
    }

    public int addProperty(Property property) {
        if (property == null) return -2;
        if (propertyCount >= MAX_PROPERTY) return -1;
        if (!plot.encompasses(property.getPlot())) return -3;

        for (int i = 0; i < propertyCount; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }

        properties[propertyCount] = new Property(property);
        propertyCount++;
        return propertyCount - 1;
    }

    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    public double getTotalRent() {
        double total = 0;
        for (int i = 0; i < propertyCount; i++) {
            total += properties[i].getRentAmount();
        }
        return total;
    }

    public Property getHighestRentProperty() {
        if (propertyCount == 0) return null;
        Property highest = properties[0];
        for (int i = 1; i < propertyCount; i++) {
            if (properties[i].getRentAmount() > highest.getRentAmount()) {
                highest = properties[i];
            }
        }
        return highest;
    }

    public void removeLastProperty() {
        if (propertyCount > 0) {
            properties[propertyCount - 1] = null;
            propertyCount--;
        }
    }

    public boolean isPropertiesFull() {
        return propertyCount >= MAX_PROPERTY;
    }

    public int getPropertiesCount() {
        return propertyCount;
    }

    public boolean isManagementFeeValid() {
        return mgmtFee >= 0 && mgmtFee <= 100;
    }

    public String getName() {
        return name;
    }

    public Plot getPlot() {
        return new Plot(plot);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n");
        sb.append("______________________________________________________\n");
        for (int i = 0; i < propertyCount; i++) {
            sb.append(properties[i].toString()).append("\n");
        }
        sb.append("______________________________________________________\n\n");
        sb.append(" total management Fee: ").append(String.format("%.2f", (getTotalRent() * mgmtFee) / 100));
        return sb.toString();
    }
}
