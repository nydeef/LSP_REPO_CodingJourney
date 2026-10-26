
package org.howard.edu.lsp.midterm.inheritance;

/**
 * Represents a contractor who receives a 15% premium on all hours worked.
 */
public class Contractor extends Employee {

    /**
     * Creates a contractor with the specified hours and rate.
     *
     * @param hoursWorked the number of hours worked
     * @param hourlyRate the contractor's hourly pay rate
     */
    public Contractor(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }

    /**
     * Calculates contractor pay with a 15% premium.
     *
     * @return hours worked multiplied by the hourly rate and 1.15
     */
    @Override
    public double calculatePay() {
        return hoursWorked * hourlyRate * 1.15;
    }
}

