package models;

public class Employee {
    private int id;
    private String lastName;
    private String firstName;
    private int phoneNumber;
    private int age;
    private double salary;
    private String title;

    public Employee() {
    }

    public Employee(String lastName, String firstName, int phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }
}
