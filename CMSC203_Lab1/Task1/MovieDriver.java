/* Class: CMSC203 CRN XXXX
 Program: Lab 1
 Instructor: 
 Summary of Description: (Give a brief description for each Program) 
 Due Date: MM/DD/YYYY 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
*/



import java.util.Scanner;
public class MovieDriver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		
		Movie movie = new Movie();
		
		System.out.println("Enter the title of a movie: ");
		String title = scanner.nextLine();
		movie.setTitle(title);
		
		System.out.println("Enter the rating of the movie: ");
		String rating = scanner.nextLine();
		movie.setRating(rating);
		
		System.out.println("Enter the number of tickets sold at a theater: ");
        int ticketsSold = scanner.nextInt();
        movie.setSoldTickets(ticketsSold);
        
        System.out.println(movie.toString());
        
        scanner.close();
        
        
		
		
		

	}

}
