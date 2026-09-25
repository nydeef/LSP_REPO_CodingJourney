package org.howard.edu.lsp.assignment3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CSVWriter {

    public void writeEmployees(String outputFile,
                               List<Employee> employees,
                               PayrollProcessor processor) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // Write the header
            writer.write(
                    "EmployeeID,Name,Department,HoursWorked,HourlyRate," +
                            "GrossPay,PayLevel,EmploymentStatus"
            );
            writer.newLine();

            for (Employee employee : employees) {

                BigDecimal grossPay =
                        processor.calculateGrossPay(employee);

                String payLevel =
                        processor.determinePayLevel(grossPay);

                String employmentStatus =
                        processor.determineEmploymentStatus(employee);

                writer.write(
                        employee.getEmployeeId() + "," +
                                employee.getName() + "," +
                                employee.getDepartment() + "," +
                                employee.getHoursWorked()
                                        .setScale(2, RoundingMode.HALF_UP)
                                        .toPlainString() + "," +
                                employee.getHourlyRate()
                                        .setScale(2, RoundingMode.HALF_UP)
                                        .toPlainString() + "," +
                                grossPay.toPlainString() + "," +
                                payLevel + "," +
                                employmentStatus
                );

                writer.newLine();
            }
        }
    }
}
