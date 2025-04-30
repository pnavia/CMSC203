/*
 * Class: CMSC203 
 * Instructor: Tarek Ahmed
 * Description: Represents an order containing beverages, customer info, and order metadata.
 * Due: 04/29/2029
 * Platform/compiler: 
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code  
 * from a student or any source. I have not given my code  
 * to any student.
   Print your Name here: Paulo Navia
*/

import java.util.ArrayList;
import java.util.Random;

public class Order implements Comparable<Order> {
    private int orderNo;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer); // Deep copy
        this.beverages = new ArrayList<>();
        this.orderNo = generateOrderNumber();
    }

    private int generateOrderNumber() {
        return new Random().nextInt(80001) + 10000; // random between 10000-90000
    }

    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    public void addNewBeverage(String bevName, Size size) {
        boolean isWeekend = (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY);
        beverages.add(new Alcohol(bevName, size, isWeekend));
    }

    public double calcOrderTotal() {
        double total = 0.0;
        for (Beverage b : beverages) {
            total += b.calcPrice();
        }
        return total;
    }

    public Beverage getBeverage(int index) {
        if (index >= 0 && index < beverages.size()) {
            return beverages.get(index);
        }
        return null;
    }

    public int getTotalItems() {
        return beverages.size();
    }

    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage b : beverages) {
            if (b.getType() == type) count++;
        }
        return count;
    }

    public int compareTo(Order other) {
        return Integer.compare(this.orderNo, other.orderNo);
    }

    public String toString() {
        String result = "Order Number: " + orderNo +
                        ", Time: " + orderTime +
                        ", Day: " + orderDay +
                        ", Customer: " + customer.toString() +
                        "\nBeverages:\n";
        for (Beverage b : beverages) {
            result += b.toString() + "\n";
        }
        return result;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public Day getOrderDay() {
        return orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer);
    }

    public ArrayList<Beverage> getBeverages() {
        return beverages;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public void setOrderDay(Day orderDay) {
        this.orderDay = orderDay;
    }

    public void setCustomer(Customer customer) {
        this.customer = new Customer(customer);
    }
}
