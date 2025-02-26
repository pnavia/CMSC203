/*
 * Class: CMSC203 31274
 * Instructor:
 * Description: This is the driver class that uses Patient and Procedure classes
 * respectively
 * Due: 02/25/2025
 * Platform/compiler: Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Paulo Navia 
*/

public class PatientDriverApp {
    
    /**
     * Displays information about a patient
     * @param patient The patient whose information to display
     */
    public static void displayPatient(Patient patient) {
        System.out.println(patient.toString());
    }
    
    /**
     * Displays information about a procedure
     * @param procedure The procedure whose information to display
     */
    public static void displayProcedure(Procedure procedure) {
        System.out.println(procedure.toString());
    }
    
    /**
     * Calculates the total charges for three procedures
     * @param procedure1 The first procedure
     * @param procedure2 The second procedure
     * @param procedure3 The third procedure
     * @return The sum of the charges for all three procedures
     */
    public static double calculateTotalCharges(Procedure procedure1, Procedure procedure2, Procedure procedure3) {
        return procedure1.getCharges() + procedure2.getCharges() + procedure3.getCharges();
    }
    
    /**
     * Main method that demonstrates the functionality of the Patient and Procedure classes
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Display developer information
        System.out.println("The program was developed by a Student: Paulo Navia <02/25/25>\n");
        
        // Test Case 1: Basic functionality with sample data
        System.out.println("*** Test Case 1: Basic Functionality ***");
        
        // Create a patient with full constructor
        Patient patient = new Patient("John", "M", "Doe", 
                                     "123 Main St", "Anytown", "MD", "12345", 
                                     "301-123-4567", "Jane Doe", "301-987-6543");
        
        // Create procedures using different constructors
        Procedure procedure1 = new Procedure(); // No-arg constructor
        procedure1.setName("Physical Exam");
        procedure1.setDate("09/27/2023");
        procedure1.setPractitioner("Dr. Irvine");
        procedure1.setCharges(250.00);
        
        Procedure procedure2 = new Procedure("X-Ray", "09/27/2023"); // Two-arg constructor
        procedure2.setPractitioner("Dr. Smith");
        procedure2.setCharges(500.00);
        
        Procedure procedure3 = new Procedure("Blood Test", "09/27/2023", "Dr. Johnson", 200.00); // Full constructor
        
        // Display patient information
        System.out.println("Patient Information:");
        displayPatient(patient);
        
        // Display procedure information
        System.out.println("\nProcedure Information:");
        displayProcedure(procedure1);
        displayProcedure(procedure2);
        displayProcedure(procedure3);
        
        // Calculate and display the total charges
        double totalCharges = calculateTotalCharges(procedure1, procedure2, procedure3);
        System.out.println("\nTotal Charges: $" + String.format("%,.2f", totalCharges));
        
        System.out.println("\n----------------------------------------\n");
        
        // Test Case 2: Patient with empty middle name and procedures with high charges
        System.out.println("*** Test Case 2: Empty Middle Name and High Charges ***");
        
        Patient patient2 = new Patient("Jane", "", "Smith", 
                                     "456 Pine St", "Othertown", "VA", "54321", 
                                     "571-123-4567", "Bob Smith", "571-987-6543");
        
        Procedure proc2_1 = new Procedure("Major Surgery", "02/25/2025", "Dr. Jones", 15000.00);
        Procedure proc2_2 = new Procedure("ICU Stay", "02/26/2025", "Dr. Miller", 8500.00);
        Procedure proc2_3 = new Procedure("Physical Therapy", "03/01/2025", "Dr. Chen", 1200.00);
        
        // Display patient information
        System.out.println("Patient Information:");
        displayPatient(patient2);
        
        // Display procedure information
        System.out.println("\nProcedure Information:");
        displayProcedure(proc2_1);
        displayProcedure(proc2_2);
        displayProcedure(proc2_3);
        
        // Calculate and display the total charges
        double totalCharges2 = calculateTotalCharges(proc2_1, proc2_2, proc2_3);
        System.out.println("\nTotal Charges: $" + String.format("%,.2f", totalCharges2));
        
        System.out.println("\n----------------------------------------\n");
        
        // Test Case 3: Create with minimal info and update with setters
        System.out.println("*** Test Case 3: Using Setters to Update Information ***");
        
        // Create patient with name-only constructor
        Patient patient3 = new Patient("Robert", "B", "Johnson");
        // Update with setters
        patient3.setStreetAddress("789 Elm St");
        patient3.setCity("Springfield");
        patient3.setState("IL");
        patient3.setZipCode("62701");
        patient3.setPhoneNumber("217-555-1234");
        patient3.setEmergencyContactName("Sarah Johnson");
        patient3.setEmergencyContactPhone("217-555-5678");
        
        // Create procedures and set values
        Procedure proc3_1 = new Procedure(); // No-arg constructor
        proc3_1.setName("Consultation");
        proc3_1.setDate("02/10/2025");
        proc3_1.setPractitioner("Dr. Adams");
        proc3_1.setCharges(150.00);
        
        Procedure proc3_2 = new Procedure("Lab Work", "02/10/2025"); // Two-arg constructor
        proc3_2.setPractitioner("Dr. Wilson");
        proc3_2.setCharges(325.50);
        
        Procedure proc3_3 = new Procedure("Follow-up", "02/17/2025", "Dr. Adams", 0.0); // Full constructor with zero charge
        
        // Display patient information
        System.out.println("Patient Information:");
        displayPatient(patient3);
        
        // Display procedure information
        System.out.println("\nProcedure Information:");
        displayProcedure(proc3_1);
        displayProcedure(proc3_2);
        displayProcedure(proc3_3);
        
        // Calculate and display the total charges
        double totalCharges3 = calculateTotalCharges(proc3_1, proc3_2, proc3_3);
        System.out.println("\nTotal Charges: $" + String.format("%,.2f", totalCharges3));
        
        System.out.println("\n----------------------------------------\n");
        
        // Test Case 4: Special characters and different date formats
        System.out.println("*** Test Case 4: Special Characters and Different Date Formats ***");
        
        Patient patient4 = new Patient("O'Brien", "D'Arcy", "Smith-Jones", 
                                     "123 Main St. #456", "San José", "CA", "90210-1234", 
                                     "213-555-1234", "María Rodríguez", "213-555-4321");
        
        Procedure proc4_1 = new Procedure("Exam", "2/5/2025", "Dr. Wong", 150.00);
        Procedure proc4_2 = new Procedure("Test", "02-10-2025", "Dr. Kim", 275.50);
        Procedure proc4_3 = new Procedure("Consultation", "February 15, 2025", "Dr. Lee", 125.00);
        
        // Display patient information
        System.out.println("Patient Information:");
        displayPatient(patient4);
        
        // Display procedure information
        System.out.println("\nProcedure Information:");
        displayProcedure(proc4_1);
        displayProcedure(proc4_2);
        displayProcedure(proc4_3);
        
        // Calculate and display the total charges
        double totalCharges4 = calculateTotalCharges(proc4_1, proc4_2, proc4_3);
        System.out.println("\nTotal Charges: $" + String.format("%,.2f", totalCharges4));
    }
}