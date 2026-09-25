package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.util.List;

public class ETLPipeline {

    public static void main(String[] args) {

        String inputFile = "data/employees.csv";
        String outputFile = "data/transformed_employees.csv";

        CSVReader reader = new CSVReader();
        PayrollProcessor processor = new PayrollProcessor();
        CSVWriter writer = new CSVWriter();

        try {

            // Read employees from the input CSV
            List<Employee> employees =
                    reader.readEmployees(inputFile);

            // Write transformed employees to the output CSV
            writer.writeEmployees(
                    outputFile,
                    employees,
                    processor
            );

            // Display results
            System.out.println("Rows read: " + reader.getRowsRead());
            System.out.println("Rows transformed: " + employees.size());
            System.out.println("Rows skipped: " + reader.getRowsSkipped());
            System.out.println("Output file: " + outputFile);

        } catch (IOException e) {
            System.out.println(
                    "Error reading or writing files: " + e.getMessage()
            );
        }
    }
}