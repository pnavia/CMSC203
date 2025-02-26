/*
 * Class: CMSC203 31274
 * Instructor:
 * Description: This class shows the medical procedure performed on a patient
 * Due: 02/25/2025
 * Platform/compiler: Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Paulo Navia 
*/

public class Procedure {
    // Attributes
    private String name;
    private String date;
    private String practitioner;
    private double charges;
    
    /**
     * No-arg constructor
     */
    public Procedure() {
        this.name = "";
        this.date = "";
        this.practitioner = "";
        this.charges = 0.0;
    }

    public Procedure(String name, String date) {
        this.name = name;
        this.date = date;
        this.practitioner = "";
        this.charges = 0.0;
    }
    

    public Procedure(String name, String date, String practitioner, double charges) {
        this.name = name;
        this.date = date;
        this.practitioner = practitioner;
        this.charges = charges;
    }
    
    // Accessors (getters)

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getPractitioner() {
        return practitioner;
    }
    

    public double getCharges() {
        return charges;
    }
    
    // Mutators (setters)

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public void setPractitioner(String practitioner) {
        this.practitioner = practitioner;
    }
    
    public void setCharges(double charges) {
        this.charges = charges;
    }
    
    @Override
    public String toString() {
        return "Procedure: " + name + "\t" +
               "Date: " + date + "\t" +
               "Practitioner: " + practitioner + "\t" +
               "Charge: $" + String.format("%.2f", charges);
    }
}