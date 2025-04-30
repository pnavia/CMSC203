/*
 * Class: CMSC203 
 * Instructor: Tarek Ahmed
 * Description: Represents a customer with a name and age, including a copy constructor.
 * Due: 04/29/2029
 * Platform/compiler: 
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Paulo Navia
*/

public class Customer {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Customer(Customer other) {
        this.name = other.name;
        this.age = other.age;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
}
