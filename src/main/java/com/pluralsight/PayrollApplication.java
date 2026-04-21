package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class PayrollApplication {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

//            Cut the first line since it does not have data
            bufferedReader.readLine();

            String currentLine;

//            Print out each employee in the list with correct formatting
            while ((currentLine = bufferedReader.readLine()) != null) {

                Employee newEmployee = createEmployee(currentLine);

                System.out.printf("ID: %s, Name: %s, Gross Pay: $%.2f\n", newEmployee.getId(), newEmployee.getName(), newEmployee.getGrossPay());

            }
        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
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
