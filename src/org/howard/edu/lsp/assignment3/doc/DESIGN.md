# Assignment 3 Design

## 1. Assignment 2 Organization

Assignment 2 was organized primarily around one `ETLPipeline` class. The `main` method handled most of the program's responsibilities, including reading the input CSV file, validating rows, parsing employee information, calculating regular and overtime pay, applying the IT bonus, determining pay levels and employment status, and writing the transformed CSV file.

The employee information was stored in individual variables such as employee ID, name, department, hours worked, and hourly rate. The program therefore had most of its processing and file-handling responsibilities contained within a single class.

## 2. Design Changes in Assignment 3

Assignment 3 refactors the program using object-oriented design. Instead of having `ETLPipeline` perform all of the work, the responsibilities are divided among several classes.

The Assignment 3 package contains:

* `ETLPipeline.java`
* `Employee.java`
* `CSVReader.java`
* `PayrollProcessor.java`
* `CSVWriter.java`

`ETLPipeline` now coordinates the overall process rather than performing every operation itself.

## 3. Classes and Abstractions Introduced

### Employee

The `Employee` class represents an employee and stores the employee's ID, name, department, hours worked, and hourly rate. The fields are private and are accessed through getter methods. This provides encapsulation and keeps employee data together in one object.

### CSVReader

The `CSVReader` class is responsible for reading the employee input file. It reads each row, checks the number of fields, validates numeric values, rejects invalid or negative values, and creates `Employee` objects for valid rows.

### PayrollProcessor

The `PayrollProcessor` class handles payroll-related calculations. It calculates regular pay, overtime pay, the IT bonus, and gross pay. It also determines the employee's pay level and employment status.

### CSVWriter

The `CSVWriter` class is responsible for creating the transformed CSV file. It receives the employee objects and payroll processor and writes the transformed employee information using the required output format.

### ETLPipeline

The `ETLPipeline` class coordinates the other classes. Its `main` method creates the necessary objects, reads the employees, processes the results, writes the output file, and displays the row statistics.

## 4. Division of Responsibilities

The main difference between the two assignments is how responsibilities are divided.

In Assignment 2, `ETLPipeline` was responsible for reading, validating, processing, and writing the data. In Assignment 3, these responsibilities are separated.

`CSVReader` handles input and validation, `Employee` represents employee data, `PayrollProcessor` handles payroll calculations and classifications, and `CSVWriter` handles output. `ETLPipeline` coordinates these components.

This allows each class to have a more focused responsibility instead of placing the majority of the program's logic in one class.

## 5. Why Assignment 3 Is an Improvement

The Assignment 3 design improves the organization and maintainability of the program by separating responsibilities into focused classes. Changes to one part of the program can be made with less impact on the other parts. For example, payroll calculations are contained in `PayrollProcessor`, while file-writing logic is contained in `CSVWriter`.

The `Employee` class also provides a clear object representation of an employee instead of using separate variables throughout the program. Private fields and getter methods provide encapsulation.

The refactored program also preserves the functional behavior of Assignment 2. When run through `ETLPipeline.main()`, it produces the same transformed employee CSV output and row statistics as the original implementation.

## AI and Internet Resources

AI was used to assist with the object-oriented refactoring of the Assignment 2 code and to explain the organization and responsibilities of the new classes.

AI resource: ChatGPT — OpenAI

No external Internet resources were used for the implementation.
