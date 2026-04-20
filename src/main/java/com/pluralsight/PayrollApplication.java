package com.pluralsight;

public class PayrollApplication {
    public static void main(String[] args) {

    }

    public static Employee createEmployee(String employeeData) {
        String[] splitEmployeeData = employeeData.split("\\|");
        int employeeId = Integer.parseInt(splitEmployeeData[0]);
        String employeeName = splitEmployeeData[1];
        double employeeHoursWorked = Double.parseDouble(splitEmployeeData[2]);
        double employeePayRate = Double.parseDouble(splitEmployeeData[3]);

        return new Employee(employeeId, employeeName, employeeHoursWorked, employeePayRate);
    }
}
