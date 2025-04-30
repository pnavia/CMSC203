/*
 * Class: CMSC203 
 * Instructor: Tarek Ahmed
 * Description: Manages the overall beverage shop including orders, alcohol restrictions, and monthly sales.
 * Due: 04/29/2029
 * Platform/compiler: 
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Paulo Navia
 */

import java.util.ArrayList;
import java.util.Collections;

public class BevShop {
    private ArrayList<Order> orders;
    private int numOfAlcoholDrinks;

    public static final int MIN_AGE_FOR_ALCOHOL = 21;
    public static final int MAX_ALCOHOL_PER_ORDER = 3;
    public static final int MIN_TIME = 8;
    public static final int MAX_TIME = 23;
    public static final int MAX_FRUIT = 5;

    public BevShop() {
        orders = new ArrayList<>();
        numOfAlcoholDrinks = 0;
    }

    public boolean validTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    public boolean validAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Customer customer = new Customer(customerName, customerAge);
        Order order = new Order(time, day, customer);
        orders.add(order);
        numOfAlcoholDrinks = 0;
    }

    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    public void processAlcoholOrder(String bevName, Size size) {
        if (eligibleForMore()) {
            getCurrentOrder().addNewBeverage(bevName, size);
            numOfAlcoholDrinks++;
        }
    }

    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        if (validMaxFruit(numOfFruits)) {
            getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
        }
    }

    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo)
                return i;
        }
        return -1;
    }

    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0.0;
    }

    public double totalMonthlySale() {
        double total = 0;
        for (Order o : orders) {
            total += o.calcOrderTotal();
        }
        return total;
    }

    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    public Order getCurrentOrder() {
        if (orders.isEmpty()) return null;
        return orders.get(orders.size() - 1);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void sortOrders() {
        Collections.sort(orders);
    }

    public boolean eligibleForMore() {
        return numOfAlcoholDrinks < MAX_ALCOHOL_PER_ORDER;
    }

    public boolean validMaxFruit(int numOfFruits) {
        return numOfFruits <= MAX_FRUIT;
    }

    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    public int getNumOfAlcoholDrink() {
        return numOfAlcoholDrinks;
    }

    public int getMaxOrderForAlcohol() {
        return MAX_ALCOHOL_PER_ORDER;
    }

    public String toString() {
        String result = "Bradley Beverage Shop Monthly Orders:\n";
        for (Order o : orders) {
            result += o.toString() + "\n";
        }
        result += "Total Monthly Sale: $" + totalMonthlySale();
        return result;
    }
}
