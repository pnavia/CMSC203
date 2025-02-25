/* Class: CMSC203 CRN 31274
 Program: Lab 1
 Instructor: Tarek Ahmed
 Summary of Description: Code prompts the user to enter info. from a movie and then implements it 
 to the object movie.
 Due Date: 02/25/2025
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Paulo Navia
*/

import java.util.Scanner;

public class MovieDriver_task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String Response; 
        
        do {
            Movie movie = new Movie();

       
            System.out.print("Enter the title of the movie: ");
            String title = scanner.nextLine();
            movie.setTitle(title);

        
            System.out.print("Enter the rating of the movie: ");
            String rating = scanner.nextLine();
            movie.setRating(rating);

        
            System.out.print("Enter the number of tickets sold at a theater: ");
            int ticketsSold = scanner.nextInt();
            scanner.nextLine(); 

            movie.setSoldTickets(ticketsSold);

            System.out.println(movie.toString());

            System.out.print("Do you want to enter another movie? (yes/no): ");
            Response = scanner.nextLine();

        } while (Response.equalsIgnoreCase("yes")); 
     
        scanner.close();
    }
}
