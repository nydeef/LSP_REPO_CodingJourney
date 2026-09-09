package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

    public class ETLPipeline {

        public static void main(String[] args) {

            String inputFile = "data/employees.csv";
            String outputFile = "data/transformed_employees.csv";

            int rowsRead = 0;
            int rowsTransformed = 0;
            int rowsSkipped = 0;

            try (
                    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
            ) {

                // Read and write the header
                String header = reader.readLine();

                writer.write(
                        "EmployeeID,Name,Department,HoursWorked,HourlyRate," +
                                "GrossPay,PayLevel,EmploymentStatus"
                );
                writer.newLine();

                String line;

                while ((line = reader.readLine()) != null) {

                    rowsRead++;

                    // Skip blank rows
                    if (line.trim().isEmpty()) {
                        rowsSkipped++;
                        continue;
                    }

                    String[] fields = line.split(",", -1);

                    // Every valid row must have exactly 5 fields
                    if (fields.length != 5) {
                        rowsSkipped++;
                        continue;
                    }

                    try {
                        // 1. Trim whitespace
                        String employeeIdText = fields[0].trim();
                        String name = fields[1].trim().toUpperCase();
                        String department = fields[2].trim();
                        String hoursText = fields[3].trim();
                        String rateText = fields[4].trim();

                        // 2. Validate numeric values
                        int employeeId = Integer.parseInt(employeeIdText);
                        BigDecimal hours = new BigDecimal(hoursText);
                        BigDecimal hourlyRate = new BigDecimal(rateText);

                        if (hours.compareTo(BigDecimal.ZERO) < 0 ||
                                hourlyRate.compareTo(BigDecimal.ZERO) < 0) {
                            rowsSkipped++;
                            continue;
                        }

                        // 3. Calculate regular and overtime pay
                        BigDecimal normalHours =
                                hours.min(new BigDecimal("40"));

                        BigDecimal overtimeHours =
                                hours.subtract(normalHours);

                        BigDecimal normalPay =
                                normalHours.multiply(hourlyRate);

                        BigDecimal overtimePay =
                                overtimeHours
                                        .multiply(hourlyRate)
                                        .multiply(new BigDecimal("1.5"));

                        BigDecimal grossPay =
                                normalPay.add(overtimePay);

                        // 4. IT bonus
                        if (department.equals("IT")) {
                            grossPay = grossPay.multiply(new BigDecimal("1.05"));
                        }

                        // 5. Round GrossPay using round-half-up
                        grossPay = grossPay.setScale(2, RoundingMode.HALF_UP);

                        // 6. Determine PayLevel
                        String payLevel;

                        if (grossPay.compareTo(new BigDecimal("500")) < 0) {
                            payLevel = "Low";
                        } else if (grossPay.compareTo(new BigDecimal("1000")) < 0) {
                            payLevel = "Standard";
                        } else if (grossPay.compareTo(new BigDecimal("2000")) < 0) {
                            payLevel = "High";
                        } else {
                            payLevel = "Executive";
                        }

                        // 7. Determine EmploymentStatus
                        String employmentStatus;

                        if (hours.compareTo(new BigDecimal("30")) < 0) {
                            employmentStatus = "Part-Time";
                        } else {
                            employmentStatus = "Full-Time";
                        }

                        // Write transformed row
                        writer.write(
                                employeeId + "," +
                                        name + "," +
                                        department + "," +
                                        hours.setScale(2, RoundingMode.HALF_UP).toPlainString() + "," +
                                        hourlyRate.setScale(2, RoundingMode.HALF_UP).toPlainString() + "," +
                                        grossPay.toPlainString() + "," +
                                        payLevel + "," +
                                        employmentStatus
                        );

                        writer.newLine();

                        rowsTransformed++;

                    } catch (NumberFormatException e) {
                        rowsSkipped++;
                    }
                }

                System.out.println("Rows read: " + rowsRead);
                System.out.println("Rows transformed: " + rowsTransformed);
                System.out.println("Rows skipped: " + rowsSkipped);
                System.out.println("Output file: " + outputFile);

            } catch (IOException e) {
                System.out.println("Error reading or writing files: " + e.getMessage());
            }
        }
    }
