package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PayrollApplication {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {

            System.out.print("Enter the name of the file employee file to process: ");
            String fileToProcess = scanner.nextLine();

            System.out.print("Enter the name of the payroll file to create: ");
            String fileToCreate = scanner.nextLine();


            FileReader fileReader = new FileReader("src/main/resources/" + fileToProcess);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter("src/main/resources/" + fileToCreate, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


//            Cut the first line since it does not have data
            bufferedReader.readLine();

            String currentLine;
            int employeesProcessed = 0;

//            Print out each employee in the list with correct formatting
            while ((currentLine = bufferedReader.readLine()) != null) {

                Employee newEmployee = createEmployee(currentLine);

                System.out.printf("Adding Employee with ID: %s, Name: %s, Gross Pay: $%.2f\n", newEmployee.getId(), newEmployee.getName(), newEmployee.getGrossPay());

//                Write data to file
                bufferedWriter.write(newEmployee.getId() + "|" + newEmployee.getName() + "|" + newEmployee.getGrossPay() + "\n");
                employeesProcessed++;
            }

            bufferedWriter.close();
            bufferedReader.close();
            System.out.println();
            System.out.println("File Created: " + fileToCreate);
            System.out.println("Processed " + employeesProcessed + " Employees");


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
