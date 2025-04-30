/*
 * Class: CMSC203 
 * Instructor: Tarek Ahmed
 * Description: Driver class that simulates the functionality of the BevShop with sample orders.
 * Due: 04/29/2029
 * Platform/compiler: 
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Paulo Navia
*/

public class BevShopDriverApp {
    public static void main(String[] args) {
        BevShop bevShop = new BevShop();

        System.out.println("The current order in process can have at most " +
                bevShop.getMaxOrderForAlcohol() + " alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is " +
                bevShop.getMinAgeForAlcohol());

        System.out.println("Start please a new order:");
        bevShop.startNewOrder(12, Day.MONDAY, "John", 23);

        System.out.println("Your Total Order for now is " +
                bevShop.getCurrentOrder().calcOrderTotal());

        System.out.println("Would you please add an alcohol drink");
        bevShop.processAlcoholOrder("Whiskey", Size.LARGE);

        System.out.println("The current order of drinks is " +
                bevShop.getCurrentOrder().getTotalItems());
        System.out.println("The Total price on the Order is " +
                bevShop.getCurrentOrder().calcOrderTotal());

        bevShop.processAlcoholOrder("Vodka", Size.MEDIUM);
        bevShop.processAlcoholOrder("Tequila", Size.SMALL);

        System.out.println("Total price on the Order: " +
                bevShop.getCurrentOrder().calcOrderTotal());

        System.out.println("\nWould you please start a new order:");
        bevShop.startNewOrder(14, Day.FRIDAY, "Ray", 18);
        bevShop.processSmoothieOrder("Banana Smoothie", Size.LARGE, 3, true);
        bevShop.processSmoothieOrder("Berry Blend", Size.MEDIUM, 2, false);
        bevShop.processCoffeeOrder("Espresso", Size.SMALL, true, false);

        System.out.println("Total price on the second Order: " +
                bevShop.getCurrentOrder().calcOrderTotal());

        System.out.println("Total amount for all Orders: " +
                bevShop.totalMonthlySale());
    }
}
