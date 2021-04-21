package models;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Date;

public class Employee {
    private int id;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private long birthDay;
    private int posteId;
    private String title;
    private int vacancy_days_remaining;

    public Employee() {
    }

    public Employee(String lastName, String firstName, String phoneNumber, LocalDate employeeBirthBay) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.birthDay = employeeBirthBay.toEpochDay();
    }

    public Employee(int id, String lastName, String firstName, String phoneNumber, long birthDay, int posteId, String title, int vacancy_days_remaining) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.posteId = posteId;
        this.title = title;
        this.vacancy_days_remaining = vacancy_days_remaining;
    }

    public Employee(String lastName, String firstName, String phoneNumber, long birthDay, int posteId, String title, int vacancy_days_remaining) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.posteId = posteId;
        this.title = title;
        this.vacancy_days_remaining = vacancy_days_remaining;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(long birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDate getBirthDayDateFormat() {
        return LocalDate.ofEpochDay(this.birthDay);
    }

    public int getPosteId() {
        return posteId;
    }

    public void setPosteId(int posteId) {
        this.posteId = posteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVacancy_days_remaining() {
        return vacancy_days_remaining;
    }

    public void setVacancy_days_remaining(int vacancy_days_remaining) {
        this.vacancy_days_remaining = vacancy_days_remaining;
    }

    @Override
    public String toString() {
        return lastName +  " | "  + firstName +  " | " + title;
    }
}
