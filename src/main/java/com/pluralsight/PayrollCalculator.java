package com.pluralsight;
import java.io.*;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter the name of the file to process: ");
        String inputFileName = userInput.nextLine();

        System.out.print("Enter the name of the payroll file to create: ");
        String payrollFileName = userInput.nextLine();
        try {
            FileReader employeeFile = new FileReader("src/main/resources/" + inputFileName);
            BufferedReader employeeReader = new BufferedReader(employeeFile);

            FileWriter payrollFile = new FileWriter("src/main/resources/" + payrollFileName);
            BufferedWriter payrollWriter = new BufferedWriter(payrollFile);
            payrollWriter.write("id|name|gross pay\n");

            String input;
            employeeReader.readLine();

            while ((input = employeeReader.readLine()) != null) {
                String[] employeeInfo = input.split("\\|");
                int employeeId = Integer.parseInt(employeeInfo[0]);
                String name = employeeInfo[1];
                double hoursWorked = Double.parseDouble(employeeInfo[2]);
                double payRate = Double.parseDouble(employeeInfo[3]);

                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                String payrollLine = String.format("%d|%s|%.2f\n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
                payrollWriter.write(payrollLine);

            }
            employeeReader.close();
            payrollWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
