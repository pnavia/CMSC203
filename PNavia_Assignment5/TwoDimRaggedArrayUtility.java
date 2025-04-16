package application;

/*
 * Class: CMSC203 
 * Instructor:
 * Description: A utility class for working with two-dimensional ragged arrays of doubles.
 * Due: MM/DD/YYYY
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: __________
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
    
    /**
     * Reads from a file and returns a ragged array of doubles
     * @param file - the file to read from
     * @return - a two-dimensional ragged array of doubles
     * @throws FileNotFoundException if the file cannot be found
     */
    public static double[][] readFile(File file) throws FileNotFoundException {
        // Count the number of rows in the file
        int rowCount = 0;
        Scanner rowCounter = new Scanner(file);
        while (rowCounter.hasNextLine()) {
            rowCounter.nextLine();
            rowCount++;
        }
        rowCounter.close();
        
        // Create the ragged array with the correct number of rows
        double[][] data = new double[rowCount][];
        
        // Read each line of the file
        Scanner fileReader = new Scanner(file);
        for (int i = 0; i < rowCount; i++) {
            if (fileReader.hasNextLine()) {
                String[] values = fileReader.nextLine().trim().split("\\s+");
                data[i] = new double[values.length];
                
                for (int j = 0; j < values.length; j++) {
                    data[i][j] = Double.parseDouble(values[j]);
                }
            }
        }
        fileReader.close();
        
        return data;
    }
    
    /**
     * Writes the ragged array of doubles to a file
     * @param data - the two dimensional ragged array of doubles
     * @param outputFile - the file to write to
     * @throws FileNotFoundException if the file cannot be created
     */
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(outputFile);
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                writer.print(data[i][j] + " ");
            }
            writer.println();
        }
        
        writer.close();
    }
    
    /**
     * Returns the total of all the elements in the two dimensional array
     * @param data - the two dimensional array
     * @return the sum of all the elements in the array
     */
    public static double getTotal(double[][] data) {
        double total = 0;
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                total += data[i][j];
            }
        }
        
        return total;
    }
    
    /**
     * Returns the average of all the elements in the two dimensional array
     * @param data - the two dimensional array
     * @return the average of all the elements in the array
     */
    public static double getAverage(double[][] data) {
        double total = 0;
        int count = 0;
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                total += data[i][j];
                count++;
            }
        }
        
        return total / count;
    }
    
    /**
     * Returns the total of the selected row in the two dimensional array
     * @param data - the two dimensional array
     * @param row - the row index to take the total of
     * @return the total of the row
     */
    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        
        for (int j = 0; j < data[row].length; j++) {
            total += data[row][j];
        }
        
        return total;
    }
    
    /**
     * Returns the total of the selected column in the two dimensional array
     * @param data - the two dimensional array
     * @param col - the column index to take the total of
     * @return the total of the column
     */
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                total += data[i][col];
            }
        }
        
        return total;
    }
    
    /**
     * Returns the largest element of the selected row in the two dimensional array
     * @param data - the two dimensional array
     * @param row - the row index to find the largest element of
     * @return the largest element of the row
     */
    public static double getHighestInRow(double[][] data, int row) {
        if (data[row].length == 0) {
            return 0;
        }
        
        double highest = data[row][0];
        
        for (int j = 1; j < data[row].length; j++) {
            if (data[row][j] > highest) {
                highest = data[row][j];
            }
        }
        
        return highest;
    }
    
    /**
     * Returns the index of the largest element of the selected row in the two dimensional array
     * @param data - the two dimensional array
     * @param row - the row index to find the largest element of
     * @return the index of the largest element of the row
     */
    public static int getHighestInRowIndex(double[][] data, int row) {
        if (data[row].length == 0) {
            return -1;
        }
        
        double highest = data[row][0];
        int index = 0;
        
        for (int j = 1; j < data[row].length; j++) {
            if (data[row][j] > highest) {
                highest = data[row][j];
                index = j;
            }
        }
        
        return index;
    }
    
    /**
     * Returns the smallest element of the selected row in the two dimensional array
     * @param data - the two dimensional array
     * @param row - the row index to find the smallest element of
     * @return the smallest element of the row
     */
    public static double getLowestInRow(double[][] data, int row) {
        if (data[row].length == 0) {
            return 0;
        }
        
        double lowest = data[row][0];
        
        for (int j = 1; j < data[row].length; j++) {
            if (data[row][j] < lowest) {
                lowest = data[row][j];
            }
        }
        
        return lowest;
    }
    
    /**
     * Returns the index of the smallest element of the selected row in the two dimensional array
     * @param data - the two dimensional array
     * @param row - the row index to find the smallest element of
     * @return the index of the smallest element of the row
     */
    public static int getLowestInRowIndex(double[][] data, int row) {
        if (data[row].length == 0) {
            return -1;
        }
        
        double lowest = data[row][0];
        int index = 0;
        
        for (int j = 1; j < data[row].length; j++) {
            if (data[row][j] < lowest) {
                lowest = data[row][j];
                index = j;
            }
        }
        
        return index;
    }
    
    /**
     * Returns the largest element of the selected column in the two dimensional array
     * @param data - the two dimensional array
     * @param col - the column index to find the largest element of
     * @return the largest element of the column
     */
    public static double getHighestInColumn(double[][] data, int col) {
        double highest = Double.NEGATIVE_INFINITY;
        boolean found = false;
        
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                if (!found) {
                    highest = data[i][col];
                    found = true;
                } else if (data[i][col] > highest) {
                    highest = data[i][col];
                }
            }
        }
        
        return found ? highest : 0;
    }
    
    /**
     * Returns the index of the largest element of the selected column in the two dimensional array
     * @param data - the two dimensional array
     * @param col - the column index to find the largest element of
     * @return the index of the largest element of the column
     */
    public static int getHighestInColumnIndex(double[][] data, int col) {
        double highest = Double.NEGATIVE_INFINITY;
        int index = -1;
        
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                if (index == -1 || data[i][col] > highest) {
                    highest = data[i][col];
                    index = i;
                }
            }
        }
        
        return index;
    }
    
    /**
     * Returns the smallest element of the selected column in the two dimensional array
     * @param data - the two dimensional array
     * @param col - the column index to find the smallest element of
     * @return the smallest element of the column
     */
    public static double getLowestInColumn(double[][] data, int col) {
        double lowest = Double.POSITIVE_INFINITY;
        boolean found = false;
        
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                if (!found) {
                    lowest = data[i][col];
                    found = true;
                } else if (data[i][col] < lowest) {
                    lowest = data[i][col];
                }
            }
        }
        
        return found ? lowest : 0;
    }
    
    /**
     * Returns the index of the smallest element of the selected column in the two dimensional array
     * @param data - the two dimensional array
     * @param col - the column index to find the smallest element of
     * @return the index of the smallest element of the column
     */
    public static int getLowestInColumnIndex(double[][] data, int col) {
        double lowest = Double.POSITIVE_INFINITY;
        int index = -1;
        
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                if (index == -1 || data[i][col] < lowest) {
                    lowest = data[i][col];
                    index = i;
                }
            }
        }
        
        return index;
    }
    
    /**
     * Returns the largest element in the two dimensional array
     * @param data - the two dimensional array
     * @return the largest element in the array
     */
    public static double getHighestInArray(double[][] data) {
        if (data.length == 0) {
            return 0;
        }
        
        double highest = Double.NEGATIVE_INFINITY;
        boolean found = false;
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (!found) {
                    highest = data[i][j];
                    found = true;
                } else if (data[i][j] > highest) {
                    highest = data[i][j];
                }
            }
        }
        
        return found ? highest : 0;
    }
    
    /**
     * Returns the smallest element in the two dimensional array
     * @param data - the two dimensional array
     * @return the smallest element in the array
     */
    public static double getLowestInArray(double[][] data) {
        if (data.length == 0) {
            return 0;
        }
        
        double lowest = Double.POSITIVE_INFINITY;
        boolean found = false;
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (!found) {
                    lowest = data[i][j];
                    found = true;
                } else if (data[i][j] < lowest) {
                    lowest = data[i][j];
                }
            }
        }
        
        return found ? lowest : 0;
    }
}
