package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private int rowsRead = 0;
    private int rowsSkipped = 0;

    public List<Employee> readEmployees(String inputFile) throws IOException {

        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

            // Read and ignore the header
            reader.readLine();

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
                    // Trim whitespace
                    String employeeIdText = fields[0].trim();
                    String name = fields[1].trim().toUpperCase();
                    String department = fields[2].trim();
                    String hoursText = fields[3].trim();
                    String rateText = fields[4].trim();

                    // Validate numeric values
                    int employeeId = Integer.parseInt(employeeIdText);
                    BigDecimal hours = new BigDecimal(hoursText);
                    BigDecimal hourlyRate = new BigDecimal(rateText);

                    // Reject negative hours or rates
                    if (hours.compareTo(BigDecimal.ZERO) < 0 ||
                            hourlyRate.compareTo(BigDecimal.ZERO) < 0) {
                        rowsSkipped++;
                        continue;
                    }

                    Employee employee = new Employee(
                            employeeId,
                            name,
                            department,
                            hours,
                            hourlyRate
                    );

                    employees.add(employee);

                } catch (NumberFormatException e) {
                    rowsSkipped++;
                }
            }
        }

        return employees;
    }

    public int getRowsRead() {
        return rowsRead;
    }

    public int getRowsSkipped() {
        return rowsSkipped;
    }
}