
package org.howard.edu.lsp.midterm.inheritance;

/**
 * Represents a full-time employee who receives overtime pay
 * at 1.5 times the hourly rate for hours worked beyond 40.
 */
public class FullTimeEmployee extends Employee {

    /**
     * Creates a full-time employee with the specified hours and rate.
     *
     * @param hoursWorked the number of hours worked
     * @param hourlyRate the employee's hourly pay rate
     */
    public FullTimeEmployee(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }

    /**
     * Calculates regular pay and any overtime pay.
     *
     * @return total pay, including overtime when applicable
     */
    @Override
    public double calculatePay() {
        if (hoursWorked <= 40) {
            return hoursWorked * hourlyRate;
        }

        double regularPay = 40 * hourlyRate;
        double overtimeHours = hoursWorked - 40;
        double overtimePay = overtimeHours * hourlyRate * 1.5;

        return regularPay + overtimePay;
    }
}
