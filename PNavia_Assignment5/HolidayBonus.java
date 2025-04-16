package application;

/*
 * Class: CMSC203 
 * Instructor:
 * Description: A utility class for calculating holiday bonuses for stores.
 * Due: MM/DD/YYYY
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: __________
 */

public class HolidayBonus {
    // Constant bonus amounts
    private static final double HIGHEST_BONUS = 5000.0;
    private static final double LOWEST_BONUS = 1000.0;
    private static final double OTHER_BONUS = 2000.0;
    
    /**
     * Calculates the holiday bonus for each store
     * @param data - the two dimensional array of store sales
     * @return an array of the bonus for each store
     */
    public static double[] calculateHolidayBonus(double[][] data) {
        // Create array to hold bonuses for each store
        double[] bonuses = new double[data.length];
        
        // Find maximum number of columns
        int maxColumns = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].length > maxColumns) {
                maxColumns = data[i].length;
            }
        }
        
        // For each category (column)
        for (int col = 0; col < maxColumns; col++) {
            // Count stores with valid (positive) sales in this category
            int validStores = 0;
            for (int i = 0; i < data.length; i++) {
                if (col < data[i].length && data[i][col] > 0) {
                    validStores++;
                }
            }
            
            if (validStores == 0) {
                // No store had positive sales in this category
                continue;
            }
            
            // Get highest and lowest indices for this column
            int highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
            int lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);
            
            // Check if highest value is positive (if not, no bonus for this category)
            if (highestIndex != -1 && col < data[highestIndex].length && data[highestIndex][col] <= 0) {
                continue;
            }
            
            // Assign bonuses for each store in this category
            for (int store = 0; store < data.length; store++) {
                // Check if store has this category and has positive sales
                if (col < data[store].length && data[store][col] > 0) {
                    if (validStores == 1) {
                        // If only one store had positive sales in this category
                        bonuses[store] += HIGHEST_BONUS;
                    } else if (store == highestIndex) {
                        // Store with highest sales gets highest bonus
                        bonuses[store] += HIGHEST_BONUS;
                    } else if (store == lowestIndex) {
                        // Store with lowest sales gets lowest bonus
                        bonuses[store] += LOWEST_BONUS;
                    } else {
                        // All other stores get other bonus
                        bonuses[store] += OTHER_BONUS;
                    }
                }
            }
        }
        
        return bonuses;
    }
    
    /**
     * Calculates the total holiday bonuses for all stores
     * @param data - the two dimensional array of store sales
     * @return the total of all holiday bonuses
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        double[] bonuses = calculateHolidayBonus(data);
        double total = 0;
        
        for (double bonus : bonuses) {
            total += bonus;
        }
        
        return total;
    }
}
