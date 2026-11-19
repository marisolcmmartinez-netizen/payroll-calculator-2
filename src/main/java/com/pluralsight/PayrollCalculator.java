package com.pluralsight;
import java.io.*;

public class PayrollCalculator {
    public static void main(String[] args) {
        try {
            FileReader employeeFile = new FileReader("src/main/resources/employees.csv");
            BufferedReader employeeReader = new BufferedReader(employeeFile);

            String input;
            employeeReader.readLine();

            while ((input = employeeReader.readLine()) != null) {
                String[] employeeInfo = input.split("\\|");
                int employeeId = Integer.parseInt(employeeInfo[0]);
                String name = employeeInfo[1];
                double hoursWorked = Double.parseDouble(employeeInfo[2]);
                double payRate = Double.parseDouble(employeeInfo[3]);

                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                System.out.printf("ID: %d, name: %s calculate gross pay: $%.2f\n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }
            employeeReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
