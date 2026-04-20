package com.pluralsight;

public class Employee {
    private int id;
    private String name;
    private double hoursWorked;
    private double payRate;

    public Employee(int id, String name, double hoursWorked, double payRate) {
        this.id = id;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getGrossPay() {
        double grossPay = 0;
        if (this.hoursWorked > 40) {
            double overtimeHours = this.hoursWorked - 40;
            double overtimePayRate = this.payRate * 1.5;

            grossPay += (overtimePayRate * overtimeHours) + (40 * this.payRate);
        } else {
            grossPay += (this.payRate * this.hoursWorked);
        }
        return grossPay;
    }
}
